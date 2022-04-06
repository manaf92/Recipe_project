package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Recipe_project.models.dto.form.RecipeInstructionFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeInstructionViewDTO;
import se.lexicon.Recipe_project.service.entity.RecipeInstructionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("recipe_instruction/")
public class RecipeInstructionController {
    private final RecipeInstructionServiceImpl service;
    @Autowired
    public RecipeInstructionController(RecipeInstructionServiceImpl service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<RecipeInstructionViewDTO> create(@Validated @RequestBody RecipeInstructionFormDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<RecipeInstructionViewDTO> update(@Validated @RequestBody RecipeInstructionFormDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<RecipeInstructionViewDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<RecipeInstructionViewDTO> findById( @RequestParam String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete( @RequestParam String id){
        return ResponseEntity.ok(service.delete(id));
    }
}
