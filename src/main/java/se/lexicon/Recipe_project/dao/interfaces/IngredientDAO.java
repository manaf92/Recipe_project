package se.lexicon.Recipe_project.dao.interfaces;

import se.lexicon.Recipe_project.models.entity.Ingredient;

import java.util.Optional;

public interface IngredientDAO extends CRUD<Ingredient,Integer>{
    Optional<Ingredient> findByIngredientName(String name);
}
