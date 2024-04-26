package it.spkt.fashionecommercebe.controller.admin;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class AdminCategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/getAll")
    public ResponseEntity<Iterable<CategoryDTO>> getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getAll());
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(200).body(categoryService.createCategory(categoryDTO));
    }
}
