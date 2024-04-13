package it.spkt.fashionecommercebe.controller.shop;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/product")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class ShopProductController {
}
