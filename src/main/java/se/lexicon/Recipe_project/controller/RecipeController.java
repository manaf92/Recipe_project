package se.lexicon.Recipe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.Recipe_project.service.entity.implementation.RecipeServiceImpl;

@Controller
public class RecipeController {

    private RecipeServiceImpl recipeService;
    @Autowired
    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipes")
    public String getRecipes(Model model){
         model.addAttribute("recipes",recipeService.findAll());
        return "recipes";
    }

}
