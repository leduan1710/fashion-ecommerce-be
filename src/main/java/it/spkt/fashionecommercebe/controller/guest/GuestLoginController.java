package it.spkt.fashionecommercebe.controller.guest;

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
        if(userService.findByName(request.getUsername()).isEmpty()){
            request.setPhone(request.getUsername());
            return ResponseEntity.ok(authenticationService.register(request));
        }
        else{
            return null;
        }
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/check")
    public Boolean check(
            @RequestBody AuthenticationRequest request
    ){
        return authenticationService.check(request);
    }
}
