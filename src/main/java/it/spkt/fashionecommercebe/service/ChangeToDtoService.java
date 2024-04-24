package it.spkt.fashionecommercebe.service;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.model.entity.category.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChangeToDtoService {
    @Autowired
    ModelMapper modelMapper;

    public ArrayList<CategoryDTO> changeListCategoryToDTO(Iterable<Category> categories) {
        ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(category -> {
            categoryDTOS.add(modelMapper.map(category, CategoryDTO.class));
        });
        return categoryDTOS;
    }

    public CategoryDTO changeCategoryToDTO(Category category){
        CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        return categoryDTO;
    }

}