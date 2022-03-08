package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.PriceDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.Models.entities.Price;
import it_schoolkg.sall_services.Models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDTO mapToPriceDto(Price price);

    Price mapToPrice(PriceDTO priceDTO);

}
