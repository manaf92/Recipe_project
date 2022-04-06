package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.Recipe_project.dao.Data;
import se.lexicon.Recipe_project.dao.interfaces.RecipeDAO;
import se.lexicon.Recipe_project.models.entity.Recipe;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;

import javax.transaction.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class RecipeDAORepositoryTest {
    Recipe recipe1;
    Recipe recipe3;
    RecipeInstruction recipeInstruction1;
    @Autowired
    private RecipeDAO recipeDAO;
    @Autowired
    private TestEntityManager em;
    @BeforeEach
    void setUp() {
        //Data Class is  in: test/java/se/lexicon/Recipe_project/dao/Data.java
        Data data = new Data(em);
        recipe1 =data.getR1();
        recipe3 =data.getR3();
        recipeInstruction1 =data.getRecipeInstruction1();
    }

    @Test
    void findByName() {

        int ex = 2;
        List<Recipe> recipes= recipeDAO.findByName("salmon");
        int ac=  recipes.size();

        assertEquals(ex,ac);
        recipes.forEach(System.out::println);

    }

    @Test
    void findByIngredientName() {
        int ex = 1;
        List<Recipe> recipes= recipeDAO.findByIngredientName("tomato");
        int ac=  recipes.size();

        assertEquals(ex,ac);
        assertEquals("salmon",recipes.get(0).getRecipeName());
        recipes.forEach(System.out::println);
    }

    @Test
    void findByCategoryName() {
        int ex = 4;
        List<Recipe> recipes= recipeDAO.findByCategoryName("lunch");
        int ac=  recipes.size();
        assertEquals(ex,ac);
        recipes.forEach(System.out::println);
    }

    @Test
    void findByCategories() {
        int ex = 4;
        List<Recipe> recipes= recipeDAO.findByCategories(List.of("lunch","holidays"));
        int ac= (int) recipes.stream().distinct().count();
        assertEquals(ex,ac);
        recipes.forEach(System.out::println);
    }

    @Test
    void create() {
        int ex = recipeDAO.findAll().size() + 1;
        recipeDAO.create(new Recipe(0,"empty", recipeInstruction1,null,null));
        int ac = recipeDAO.findAll().size();
       assertEquals(ex,ac);
    }

    @Test
    void findById() {

        int ex = recipe1.getRecipeId();
        Recipe r = recipeDAO.findById(recipe1.getRecipeId()).get();
        int ac = r.getRecipeId();
        assertEquals(ex,ac);
    }

    @Test
    void findAll() {
        int ex = 4;
        List<Recipe> recipes= recipeDAO.findAll();
        int ac=  recipes.size();
        System.out.println(recipes.get(0).getRecipeCategories());;
        assertEquals(ex,ac);
        recipes.forEach(System.out::println);
    }

    @Test
    void update() {
        Recipe r= new Recipe(recipe3.getRecipeId(),"chicken", recipeInstruction1,null,null);
        recipeDAO.update(r);
         Recipe result = recipeDAO.findById(recipe3.getRecipeId()).get();
        String ex = "chicken";

        String ac = result.getRecipeName();
        assertEquals(ex,ac);

    }

    @Test
    void delete() {
        int id= recipe1.getRecipeId();
        Recipe toRemove = em.find(Recipe.class, id);
        System.out.println(toRemove.getRecipeId());
        recipeDAO.delete(toRemove.getRecipeId());

        Recipe findingRemovedRecipe = em.find(Recipe.class, toRemove.getRecipeId());

        assertNull(findingRemovedRecipe);

    }
}