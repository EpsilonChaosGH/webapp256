package morozov.services.converters;

import morozov.dto.ProductDTO;
import morozov.entity.Product;

import java.util.List;


public interface ProductConverter {

    ProductDTO productToDTO(Product product);

    List<ProductDTO> productToDTOs(List<Product> products);

    Product productToEntity(ProductDTO productDTO);

    List<Product> productToEntitys(List<ProductDTO> productDTOs);
}
