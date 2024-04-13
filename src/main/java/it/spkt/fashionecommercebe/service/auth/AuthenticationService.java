package it.spkt.fashionecommercebe.service.auth;

import it.spkt.fashionecommercebe.auth.AuthenticationRequest;
import it.spkt.fashionecommercebe.auth.AuthenticationResponse;
import it.spkt.fashionecommercebe.auth.RegisterRequest;
import it.spkt.fashionecommercebe.common.RankEnum;
import it.spkt.fashionecommercebe.common.RoleEnum;
import it.spkt.fashionecommercebe.common.StatusEnum;
import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .email(request.getEmail())
                .createDate(new Date())
                .updateDate(new Date())
                .image("https://frontend.tikicdn.com/_desktop-next/static/img/account/avatar.png")
                .role(RoleEnum.USER)
                .status(StatusEnum.ACTIVE)
                .rankUser(RankEnum.BRONZE)
                .point(0)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }
    public AuthenticationResponse resetPassword(String password,User newUser){
        newUser.setPassword(passwordEncoder.encode(password));
        repository.save(newUser);
        var jwtToken = jwtService.generateToken(newUser);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }
    public Boolean check(AuthenticationRequest request){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
