package morozov.services.techService;

import morozov.dto.ProductDTO;
import morozov.services.business.ProductBusinessService;
import morozov.services.converters.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTechServiceImpl implements ProductTechService {

    @Autowired
    private ProductBusinessService productBusinessService;

    @Autowired
    private ProductConverter productConverter;

    public void saveProduct(ProductDTO productDTO) {
        productBusinessService.saveProduct(productConverter.productToEntity(productDTO));
    }

    public List<ProductDTO> findAllProducts() {
        return productConverter.productToDTOs(productBusinessService.findAllProducts());
    }

    public void deleteProduct(Long id) {
        productBusinessService.deleteProduct(id);
    }

    public ProductDTO findProduct(Long id) {
        return productConverter.productToDTO(productBusinessService.findProduct(id));
    }
}