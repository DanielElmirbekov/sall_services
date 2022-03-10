package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.CategoriesDTO;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> saveCategory(String token, CategoriesDTO categoriesDTO);

    ResponseEntity<?> getByName(String token, String name);

    ResponseEntity<?> getAllCategories(String token);
}
