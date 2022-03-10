package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.PriceDTO;
import it_schoolkg.sall_services.Models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price mapToPrice(PriceDTO priceDTO);

    PriceDTO mapToPriceDto(Price price);



}
