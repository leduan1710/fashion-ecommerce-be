package it.spkt.fashionecommercebe.controller.user;

import it.spkt.fashionecommercebe.model.dto.user.UserInfoDTO;
import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.service.DTO.ModelMapService;
import it.spkt.fashionecommercebe.service.UserService;
import it.spkt.fashionecommercebe.service.auth.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class UserInfoController {
    @Autowired
    UserService userService;
    @Autowired
    ModelMapService modelMapService;
    @Autowired
    JwtService jwtService;
    public String getToken(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest()
                .getHeader("Authorization")
                .replace("Bearer ","");
    }
    @GetMapping("/info")
    public ResponseEntity<UserInfoDTO> getUser(){
        try{
            Optional<User> user=userService.findByUsername(jwtService.extractUserName(getToken()));
            return user.map(value -> ResponseEntity.ok(modelMapService.changeUserToDTO(value))).orElseGet(() -> ResponseEntity.ok(null));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";

    }
}
