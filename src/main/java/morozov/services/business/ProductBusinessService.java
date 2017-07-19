package morozov.services.business;

import morozov.entity.Product;

import java.util.List;

public interface ProductBusinessService {

    void saveProduct(Product product);

    List<Product> findAllProducts();

    void deleteProduct(Long id);

    Product findProduct(Long id);
}