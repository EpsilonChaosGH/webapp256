package morozov.services.techService;

import morozov.dto.ProductDTO;
import morozov.services.business.ProductBusinessService;
import morozov.services.converters.ProductConverter;
import morozov.services.jms.JmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductTechServiceImpl implements ProductTechService {

    @Autowired
    private JmsMessageSender jmsMessageSender;

    @Autowired
    private ProductBusinessService productBusinessService;

    @Autowired
    private ProductConverter productConverter;

    public void saveProduct(ProductDTO productDTO) {
        productBusinessService.saveProduct(productConverter.productToEntity(productDTO));
    }

    public void saveProductWithMassage(ProductDTO productDTO) {
        productBusinessService.saveProduct(productConverter.productToEntity(productDTO));
        jmsMessageSender.sendAddProduct(productDTO);
    }

    public List<ProductDTO> findAllProducts() {

        return productConverter.productToDTOs(productBusinessService.findAllProducts());
    }

    public void deleteProduct(Long id) {
        productBusinessService.deleteProduct(id);
    }

    public void deleteProductWithMessage(Long id) {
        productBusinessService.deleteProduct(id);
        jmsMessageSender.sendDelObject(id, ProductDTO.class.getSimpleName());
    }

    public ProductDTO findProduct(Long id) {
        return productConverter.productToDTO(productBusinessService.findProduct(id));
    }
}