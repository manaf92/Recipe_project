package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Recipe_project.models.dto.form.RecipeCategoryFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeCategoryViewDTO;
import se.lexicon.Recipe_project.service.entity.RecipeCategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("recipe_category/")
public class RecipeCategoryController {
    private final RecipeCategoryServiceImpl service;
    
    @Autowired
    public RecipeCategoryController(RecipeCategoryServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<RecipeCategoryViewDTO> create(@Validated @RequestBody RecipeCategoryFormDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<RecipeCategoryViewDTO> update(@Validated @RequestBody RecipeCategoryFormDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<RecipeCategoryViewDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<RecipeCategoryViewDTO> findById( @RequestParam int id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete( @RequestParam int id){
        return ResponseEntity.ok(service.delete(id));
    }
}
