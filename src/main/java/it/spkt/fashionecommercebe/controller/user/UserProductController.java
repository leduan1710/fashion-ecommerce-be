package it.spkt.fashionecommercebe.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/product")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class UserProductController {
}
