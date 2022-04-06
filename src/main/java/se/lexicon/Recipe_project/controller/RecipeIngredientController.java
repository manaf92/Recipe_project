package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Recipe_project.models.dto.form.RecipeIngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeIngredientViewDTO;
import se.lexicon.Recipe_project.service.entity.RecipeIngredientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("recipe_ingredient/")

public class RecipeIngredientController {
    private final RecipeIngredientServiceImpl service;
    @Autowired
    public RecipeIngredientController(RecipeIngredientServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<RecipeIngredientViewDTO> create(@Validated @RequestBody RecipeIngredientFormDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<RecipeIngredientViewDTO> update(@Validated @RequestBody RecipeIngredientFormDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<RecipeIngredientViewDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<RecipeIngredientViewDTO> findById( @RequestParam String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete( @RequestParam String id){
        return ResponseEntity.ok(service.delete(id));
    }
}
