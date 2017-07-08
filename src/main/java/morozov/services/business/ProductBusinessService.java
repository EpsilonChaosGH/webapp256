package morozov.services.business;

import morozov.entity.Product;

import java.util.List;

public interface ProductBusinessService {

    void createProduct(Product product);

    List<Product> findAllProducts();

    void deleteProduct(Long id);
}