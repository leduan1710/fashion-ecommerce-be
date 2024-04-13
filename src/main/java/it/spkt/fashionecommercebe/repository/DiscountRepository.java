package it.spkt.fashionecommercebe.repository;

import it.spkt.fashionecommercebe.model.entity.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<Discount,Integer> {
}
