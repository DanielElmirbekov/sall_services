package it_schoolkg.sall_services.controllers;

import it_schoolkg.sall_services.Models.dtos.CategoriesDTO;
import it_schoolkg.sall_services.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory (@RequestHeader String token , @RequestBody CategoriesDTO categoriesDTO){
        return categoryService.saveCategory(token,categoriesDTO);
    }
    @PutMapping("/update")
    public ResponseEntity<?>updateCategory(@RequestHeader String token , @RequestBody CategoriesDTO categoriesDTO){
        return categoryService.saveCategory(token,categoriesDTO);
    }
    @GetMapping("/gegtByName")
    public ResponseEntity<?>getByName(@RequestHeader String token , @RequestParam String name){
        return categoryService.getByName(token,name);
    }
}
