package it.spkt.fashionecommercebe.controller.guest;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.service.CategoryService;
import it.spkt.fashionecommercebe.service.ChangeToDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest/category")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class GuestCategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ChangeToDtoService changeToDTOService;

    @RequestMapping("/getAll")
    public ResponseEntity<Iterable<CategoryDTO>> getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getAll());
    }
}
