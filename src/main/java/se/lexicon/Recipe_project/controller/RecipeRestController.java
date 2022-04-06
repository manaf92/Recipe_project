package se.lexicon.Recipe_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.Recipe_project.models.dto.view.RecipeViewDTO;
import se.lexicon.Recipe_project.service.entity.RecipeServiceImpl;

import java.util.List;

@RestController
public class RecipeRestController {

    RecipeServiceImpl recipeService;

    @Autowired
    public RecipeRestController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeViewDTO>> getPremises(){

        List<RecipeViewDTO> recipes =  (List<RecipeViewDTO>) recipeService.findAll();

        if (recipes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(recipes);
        }
    }
}
