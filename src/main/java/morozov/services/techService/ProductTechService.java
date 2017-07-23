package morozov.services.techService;

import morozov.dto.ProductDTO;

import java.util.List;


public interface ProductTechService {

    void saveProduct(ProductDTO productDTO);

    void saveProductWithMassage(ProductDTO productDTO);

    void deleteProduct(Long id);

    void deleteProductWithMessage(Long id);

    List<ProductDTO> findAllProducts();

    ProductDTO findProduct(Long id);
}
