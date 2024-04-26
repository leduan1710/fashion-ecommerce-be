package it.spkt.fashionecommercebe.repository;

import it.spkt.fashionecommercebe.model.entity.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
    @Override
    Optional<Category> findById(Integer integer);
    Category findByName(String categoryName);
    Iterable<Category> findAllByPrevious(Integer integer);
}
