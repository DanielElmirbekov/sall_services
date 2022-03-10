package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.DiscountDTO;
import it_schoolkg.sall_services.Models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount mapToDiscount (DiscountDTO discountDTO);

    DiscountDTO mapToDiscountDTO(Discount discount);
}
