package morozov.services.business;

import morozov.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductBusinessService {

    Product createProduct(Product product);

    Page<Product> findAllProducts(Pageable pageable);

}