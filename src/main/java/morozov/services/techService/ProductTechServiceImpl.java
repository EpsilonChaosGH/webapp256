package morozov.services.techService;

import morozov.dto.ProductDTO;
import morozov.entity.Product;
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

    public void createProduct(ProductDTO productDTO) {
        productBusinessService.createProduct(productConverter.productToEntity(productDTO));
    }

    public List<ProductDTO> findAllProducts() {
        List<Product> products = productBusinessService.findAllProducts();
        return productConverter.productToDTOs(products);
    }

    public void deleteProduct(Long id) {
        productBusinessService.deleteProduct(id);
    }
//        new Product(productDTO.getId(), productDTO.getProductName(),productDTO.getGroupId(), null)
}