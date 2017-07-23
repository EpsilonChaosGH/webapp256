package morozov.repository;

import morozov.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByGroup_id(Long id);

//     @Query("SELECT t FROM Product t where t.group.id = :id")
//     List<Product> findByGroup_id(@Param("id") Long id);
}


