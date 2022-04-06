package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Recipe_project.models.dto.form.IngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.IngredientViewDTO;
import se.lexicon.Recipe_project.service.entity.IngredientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("ingredient/")
public class IngredientController {
    private final IngredientServiceImpl service;
    @Autowired
    public IngredientController(IngredientServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<IngredientViewDTO> create(@Validated @RequestBody IngredientFormDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<IngredientViewDTO> update(@Validated @RequestBody IngredientFormDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<IngredientViewDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<IngredientViewDTO> findById( @RequestParam int id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete( @RequestParam int id){
        return ResponseEntity.ok(service.delete(id));
    }
    
}
