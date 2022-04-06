package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Recipe_project.models.dto.form.RecipeFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeViewDTO;
import se.lexicon.Recipe_project.service.entity.RecipeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("recipe/")
public class RecipeController {

    private final RecipeServiceImpl service;
    @Autowired
    public RecipeController(RecipeServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<RecipeViewDTO> create(@Validated @RequestBody RecipeFormDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<RecipeViewDTO> update(@Validated @RequestBody RecipeFormDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<RecipeViewDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<RecipeViewDTO> findById( @RequestParam int id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete( @RequestParam int id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<RecipeViewDTO>> findByName( @RequestParam String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/find")
    public ResponseEntity<List<RecipeViewDTO>> findByIngredientName( @RequestParam("ingredient_name") String ingredientName){
        return ResponseEntity.ok(service.findByIngredientName(ingredientName));
    }

    @GetMapping("/find")
    public ResponseEntity<List<RecipeViewDTO>> findByCategoryName( @RequestParam("category_name") String categoryName){
        return ResponseEntity.ok(service.findByCategoryName(categoryName));
    }

    @GetMapping("/find")
    public ResponseEntity<List<RecipeViewDTO>> findByCategories( @RequestParam("category_name_list") List<String> categoryNames){
        return ResponseEntity.ok(service.findByCategories(categoryNames));
    }
}
