package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.Models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapToProduct(ProductDTO productDTO);

    ProductDTO mapToProductDto(Product product);


}
