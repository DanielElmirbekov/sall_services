package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Mappers.CategoryMapper;
import it_schoolkg.sall_services.Models.dtos.CategoriesDTO;
import it_schoolkg.sall_services.Models.entities.Categories;
import it_schoolkg.sall_services.exception.ErrorResponse;
import it_schoolkg.sall_services.repository.dao.CategoriesRepo;
import it_schoolkg.sall_services.services.CategoryService;
import it_schoolkg.sall_services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> saveCategory(String token, CategoriesDTO categoriesDTO) {
        ResponseEntity<?> responseEntity =
                userService.verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return responseEntity;
        }
        Categories categories =
                CategoryMapper.
                        INSTANCE
                        .mapToCategories(categoriesDTO);
        if (!Objects.isNull(categoriesRepo.findByName(categories.getName()))) {
            categoriesRepo.save(categories);
        }else{
            return new ResponseEntity<>(
                    new ErrorResponse("Такая категория товара уже существует!",null)
                    ,HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(
                CategoryMapper
                        .INSTANCE
                        .mapToCategoriesDto(categories));
    }

    @Override
    public ResponseEntity<?> getByName(String token, String name) {
        return null;
    }
}
