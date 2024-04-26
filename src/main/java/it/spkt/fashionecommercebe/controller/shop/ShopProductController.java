package it.spkt.fashionecommercebe.controller.shop;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/product")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class ShopProductController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/getAll")
    public ResponseEntity<Iterable<CategoryDTO>> getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getAll());
    }
}
