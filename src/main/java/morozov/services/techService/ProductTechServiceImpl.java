package morozov.services.techService;

import morozov.dto.ProductDTO;
import morozov.entity.Group;
import morozov.entity.Product;
import morozov.services.business.ProductBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTechServiceImpl implements ProductTechService {

    @Autowired
    private ProductBusinessService productBusinessService;

    public List<ProductDTO> productToDTOs(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
    public void createProduct(ProductDTO productDTO) {
        productBusinessService.createProduct(new Product(productDTO.getId(),productDTO.getProductName(),
                productDTO.getGroupId(),null));

    }
}
