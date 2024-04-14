package it.spkt.fashionecommercebe.controller.guest;

import it.spkt.fashionecommercebe.auth.AuthenticationGmailRequest;
import it.spkt.fashionecommercebe.auth.AuthenticationRequest;
import it.spkt.fashionecommercebe.auth.AuthenticationResponse;
import it.spkt.fashionecommercebe.auth.RegisterRequest;
import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.service.auth.AuthenticationService;
import it.spkt.fashionecommercebe.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/guest/authenticate")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
@RequiredArgsConstructor
public class GuestLoginController {
    @Autowired
    UserServiceImpl userService;
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        try{
            if(userService.findByPhone(request.getPhone()).isEmpty()){
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
    @PostMapping("/check")
    public Boolean check(
            @RequestBody AuthenticationRequest request
    ){
        try{
            return authenticationService.check(request);
        }
        catch (Exception e){
            return false;
        }
    }
}
