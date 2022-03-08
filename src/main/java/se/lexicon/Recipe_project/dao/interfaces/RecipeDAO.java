package se.lexicon.Recipe_project.dao.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.Recipe_project.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO extends CRUD<Recipe, Integer>{

    List<Recipe> findByName( String name);


    List<Recipe> findByIngredientName( String ingredientName);


    List<Recipe> findByCategoryName(String categoryName);

    List<Recipe> findByCategories(List<String> categories);

}
