package it.spkt.fashionecommercebe.service;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.model.entity.category.Category;

public interface CategoryService {
    public String createCategory(CategoryDTO categoryDTO);
    public Iterable<CategoryDTO> getAll();
}
