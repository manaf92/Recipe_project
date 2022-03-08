package se.lexicon.Recipe_project.dao.interfaces;

import se.lexicon.Recipe_project.models.entity.Recipe;

import java.util.List;

public interface RecipeDAO extends CRUD<Recipe, Integer>{

    List<Recipe> findByName( String name);


    List<Recipe> findByIngredientName( String ingredientName);


    List<Recipe> findByCategoryName(String categoryName);

    List<Recipe> findByCategories(List<String> categories);

}
