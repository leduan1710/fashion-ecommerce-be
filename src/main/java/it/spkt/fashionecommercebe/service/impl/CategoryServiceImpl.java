package it.spkt.fashionecommercebe.service.impl;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.model.entity.category.Category;
import it.spkt.fashionecommercebe.repository.CategoryRepository;
import it.spkt.fashionecommercebe.service.CategoryService;
import it.spkt.fashionecommercebe.service.ChangeToDtoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ChangeToDtoService changeToDtoService;

    @Override
    public Iterable<CategoryDTO> getAll() {
        return changeToDtoService.changeListCategoryToDTO(categoryRepository.findAll());
    }
    @Override
    public String createCategory(CategoryDTO categoryDTO) {
        if(!categoryDTO.getName().isEmpty()) {
            Optional<Category> cate = Optional.ofNullable(categoryRepository.findByName(categoryDTO.getName()));
            if (cate.isEmpty()) {
                Category category = Category.builder().image(categoryDTO.getImage())
                        .name(categoryDTO.getName())
                        .build();
                categoryRepository.save(category);
                return "Tạo loại sản phẩm thành công";
            }
        }
        return "Tạo loại sản phẩm thất bại công";
    }
}
