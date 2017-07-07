package morozov.services.converters;

import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;
import morozov.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverterImpl implements  ProductConverter {

    public ProductDTO productToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroupName(product.getGroup().getGroupName());
        productDTO.setGroup(groupDTO);

        return  productDTO;
    }

    public List<ProductDTO> productToDTOs(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        if (products == null) {
            return productDTOs;
        }

        for (Product product : products) {
            productDTOs.add(productToDTO(product));
        }

        return productDTOs;
    }

    public Product productToEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setGroupId(productDTO.getGroupId());
        product.setGroup(null);

        return product;
    }

    public List<Product> productToEntitys(List<ProductDTO> productDTOs) {
        List<Product> products = new ArrayList<Product>();

        if (productDTOs == null) {
            return products;
        }

        for (ProductDTO productDTO : productDTOs) {
            products.add(productToEntity(productDTO));
        }
        return products;
    }
}

