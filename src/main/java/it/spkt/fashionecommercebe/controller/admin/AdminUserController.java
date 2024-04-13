package it.spkt.fashionecommercebe.controller.admin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class AdminUserController {
}
