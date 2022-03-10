package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.CategoriesDTO;
import it_schoolkg.sall_services.Models.entities.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
        CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

        Categories mapToCategories(CategoriesDTO categoriesDTO);

        CategoriesDTO mapToCategoriesDto(Categories categories);
}
