package morozov.services.techService;


import morozov.dto.ProductDTO;

import java.util.List;


public interface ProductTechService {

    void saveProduct(ProductDTO productDTO);

    List<ProductDTO> findAllProducts();

    void deleteProduct(Long id);

    ProductDTO findProduct(Long id);
}
