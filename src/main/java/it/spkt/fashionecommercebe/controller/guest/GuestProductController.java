package it.spkt.fashionecommercebe.controller.guest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guest/product")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class GuestProductController {
}
