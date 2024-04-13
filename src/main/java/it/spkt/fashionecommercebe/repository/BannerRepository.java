package it.spkt.fashionecommercebe.repository;

import it.spkt.fashionecommercebe.model.entity.Banner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends CrudRepository<Banner,Integer> {
}
