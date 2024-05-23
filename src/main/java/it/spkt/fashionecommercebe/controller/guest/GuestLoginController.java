package it.spkt.fashionecommercebe.controller.guest;

import it.spkt.fashionecommercebe.auth.*;
import it.spkt.fashionecommercebe.common.RoleEnum;
import it.spkt.fashionecommercebe.model.dto.user.UserInfoDTO;
import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.repository.UserRepository;
import it.spkt.fashionecommercebe.service.UserService;
import it.spkt.fashionecommercebe.service.auth.AuthenticationService;
import it.spkt.fashionecommercebe.service.auth.JwtService;
import it.spkt.fashionecommercebe.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@RestController
@RequestMapping("/guest/authenticate")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
@RequiredArgsConstructor
public class GuestLoginController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationService authenticationService;
    public String getToken(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest()
                .getHeader("Authorization")
                .replace("Bearer ","");
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        try{
            if(userService.findByUsername(request.getUsername()).isEmpty()){
                return ResponseEntity.ok(authenticationService.register(request));
            } else{
                authenticationResponse.setMessage("Account already exists");
                return ResponseEntity.ok(authenticationResponse);
            }
        }catch(Exception e){
            authenticationResponse.setMessage("Fail to register");
            return ResponseEntity.ok(authenticationResponse);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        AuthenticationResponse authenticationResponse=new AuthenticationResponse();
        try{
            return ResponseEntity.ok(authenticationService.authenticate(request));
        }
        catch(Exception e){
            authenticationResponse.setMessage("Fail to login");
            System.out.println(e.getMessage());
            return ResponseEntity.ok(authenticationResponse);
        }
    }
    @PostMapping("/login-gmail")
    public ResponseEntity<AuthenticationResponse> authenticateGmail(
            @RequestBody AuthenticationGmailRequest request
    ){
        AuthenticationResponse authenticationResponse=new AuthenticationResponse();
        try{
            return ResponseEntity.ok(authenticationService.authenticateGmail(request));
        }
        catch(Exception e){
            authenticationResponse.setMessage("Fail to login by gmail");
            return ResponseEntity.ok(authenticationResponse);
        }
    }
    @GetMapping("/get-role")
    public RoleEnum getRole(){
        try{
            Optional<User> user=userService.findByUsername(jwtService.extractUserName(getToken()));

            return user.map(User::getRole).orElse(null);
        }
        catch (Exception e){
            return null;
        }
    }
    @PostMapping("/check")
    public Boolean Check(@RequestBody CheckUsernameRequest checkUsernameRequest){
        try{
            Optional<User> user=userService.findByUsername(checkUsernameRequest.getUsername());

            return user.isPresent();
        }
        catch (Exception e){
            return false;
        }
    }
    @PostMapping("/new-password")
    public Boolean NewPassword(@RequestBody NewPasswordRequest newPasswordRequest){
        try{
            Optional<User> user=userService.findByUsername(newPasswordRequest.getUsername());
            if(user.isPresent()){
                user.get().setPassword(passwordEncoder.encode(newPasswordRequest.getNewPassword()));
                userService.save(user.get());
                return true;
            }else{
                return false;
            }

        }
        catch (Exception e){
            return false;
        }
    }

}
