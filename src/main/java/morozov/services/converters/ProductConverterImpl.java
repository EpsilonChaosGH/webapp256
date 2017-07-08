package morozov.services.converters;

import morozov.dto.ProductDTO;
import morozov.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverterImpl implements ProductConverter {

    @Autowired
    GroupConverter groupConverter;

    public ProductDTO productToDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setGroup(groupConverter.groupToDTO(product.getGroup()));

        return productDTO;
    }

    public List<ProductDTO> productToDTOs(List<Product> products) {
        if (products == null) {
            return null;
        }

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for (Product product : products) {
            productDTOs.add(productToDTO(product));
        }

        return productDTOs;
    }

    public Product productToEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setGroupId(productDTO.getGroupId());
        product.setGroup(groupConverter.groupToEntity(productDTO.getGroup()));

        return product;
    }

    public List<Product> productToEntities(List<ProductDTO> productDTOs) {
        if (productDTOs == null) {
            return null;
        }

        List<Product> products = new ArrayList<Product>();

        for (ProductDTO productDTO : productDTOs) {
            products.add(productToEntity(productDTO));
        }

        return products;
    }
}

