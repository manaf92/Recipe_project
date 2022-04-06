package se.lexicon.Recipe_project.dao;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.Recipe_project.models.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Data {
    private TestEntityManager em;

    Recipe r1;
    Recipe r2;
    Recipe r3;
    Recipe r4;
    Ingredient ingredient1;
    RecipeCategory recipeCategory1;
    RecipeIngredient recipeIngredient1;
    List<Recipe> list;
    RecipeInstruction recipeInstruction1;

    public Data(TestEntityManager em) {
        this.em = em;
        fillData();
    }

    public Ingredient getIngredient1() {
        return ingredient1;
    }

    public RecipeCategory getRecipeCategory1() {
        return recipeCategory1;
    }

    public RecipeIngredient getRecipeIngredient1() {
        return recipeIngredient1;
    }

    public Recipe getR1() {
        return r1;
    }

    public Recipe getR2() {
        return r2;
    }

    public Recipe getR3() {
        return r3;
    }

    public Recipe getR4() {
        return r4;
    }

    public List<Recipe> getList() {
        return list;
    }

    public RecipeInstruction getRecipeInstruction1() {
        return recipeInstruction1;
    }

    private void fillData(){
        ingredient1 = new Ingredient(0,"potato");
        Ingredient ingredient2 = new Ingredient(0,"tomato");
        em.persist(ingredient1);
        em.persist(ingredient2);
         recipeInstruction1 = new RecipeInstruction(null,"put oil");
        RecipeInstruction recipeInstruction2 = new RecipeInstruction(null,"put one spoon of sold ");
        em.persist(recipeInstruction1);
        em.persist(recipeInstruction2);
        list= Arrays.asList(
                new Recipe(0,"lunch", recipeInstruction1,null,null),
                new Recipe(0,"salmon", recipeInstruction2,null,null),
                new Recipe(0,"salmon", recipeInstruction2,null,null),
                new Recipe(0,"tuna", recipeInstruction2,null,null)
        );
        list.forEach(em::persist);
        r1 =  list.get(0);
        r2 =  list.get(1);
        r3 =  list.get(2);
        r4 =  list.get(3);


        recipeCategory1 = new RecipeCategory(0,"lunch",null);
        RecipeCategory recipeCategory2 = new RecipeCategory(0,"breakfast",null);
        RecipeCategory recipeCategory3 = new RecipeCategory(0,"holidays",null);

        r1.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2));
        r2.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2));
        r3.setRecipeCategories(Set.of(recipeCategory1));
        r4.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2,recipeCategory3));
        em.persist(recipeCategory1);
        em.persist(recipeCategory2);
        em.persist(recipeCategory3);


        recipeIngredient1 = new RecipeIngredient( null ,2,ingredient1, Measurement.CL,null);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient( null ,4,ingredient2, Measurement.KG,null);
        r1.addRecipeIngredient(recipeIngredient1);
        r3.addRecipeIngredient(recipeIngredient2);
        em.persist(recipeIngredient1);
        em.persist(recipeIngredient2);
    }

}
