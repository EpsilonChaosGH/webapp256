package morozov.services.techService;


import morozov.dto.ProductDTO;
import morozov.entity.Product;

import java.util.List;


public interface ProductTechService {

    List<ProductDTO> productToDTOs(List<Product> products);

    void createProduct(ProductDTO productDTO);
}
