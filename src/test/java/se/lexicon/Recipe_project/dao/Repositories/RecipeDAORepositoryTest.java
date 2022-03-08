package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.Recipe_project.dao.interfaces.RecipeDAO;
import se.lexicon.Recipe_project.models.*;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class RecipeDAORepositoryTest {
    Recipe r1;
    Recipe r2;
    Recipe r3;
    Recipe r4;
    List<Recipe> list;
    RecipeInstruction recipeInstruction2;
    @Autowired
    private RecipeDAO recipeDAO;
    @Autowired
    private TestEntityManager em;
    @BeforeEach
    void setUp() {
        Ingredient ingredient1 = new Ingredient(0,"potato");
        Ingredient ingredient2 = new Ingredient(0,"tomato");
        em.persist(ingredient1);
        em.persist(ingredient2);
        RecipeInstruction recipeInstruction1 = new RecipeInstruction(null,"sa");
        recipeInstruction2 = new RecipeInstruction(null,"bf");
        em.persist(recipeInstruction1);
        em.persist(recipeInstruction2);
        list= Arrays.asList(
                new Recipe(0,"lunch", recipeInstruction1),
                new Recipe(0,"salmon", recipeInstruction2),
                new Recipe(0,"salmon", recipeInstruction2),
                new Recipe(0,"tuna", recipeInstruction2)
        );
        list.forEach(em::persist);
        r1 =  list.get(0);
        r2 =  list.get(1);
        r3 =  list.get(2);
        r4 =  list.get(3);


        RecipeCategory recipeCategory1 = new RecipeCategory(0,"lunch");
        RecipeCategory recipeCategory2 = new RecipeCategory(0,"breakfast");
        RecipeCategory recipeCategory3 = new RecipeCategory(0,"holidays");

        r1.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2));
        r2.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2));
        r3.setRecipeCategories(Set.of(recipeCategory1));
        r4.setRecipeCategories(Set.of(recipeCategory1,recipeCategory2,recipeCategory3));
        em.persist(recipeCategory1);
        em.persist(recipeCategory2);
        em.persist(recipeCategory3);


        RecipeIngredient recipeIngredient1 = new RecipeIngredient( null ,2,ingredient1, Measurement.CL);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient( null ,4,ingredient2, Measurement.KG);
        r1.addRecipeIngredient(recipeIngredient1);
        r3.addRecipeIngredient(recipeIngredient2);
        em.persist(recipeIngredient1);
        em.persist(recipeIngredient2);
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
        int ex = list.size() + 1;
        recipeDAO.create(new Recipe(0,"empty",recipeInstruction2));
        int ac = recipeDAO.findAll().size();
       assertEquals(ex,ac);
    }

    @Test
    void findById() {

        int ex = r1.getRecipeId();
        Recipe r = recipeDAO.findById(r1.getRecipeId());
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
        Recipe r= new Recipe(r3.getRecipeId(),"chicken", recipeInstruction2);
        recipeDAO.update(r);
         Recipe result = recipeDAO.findById(r3.getRecipeId());
        String ex = "chicken";

        String ac = result.getRecipeName();
        assertEquals(ex,ac);

    }

    @Test
    void remove() {
        int id=r1.getRecipeId();


        Recipe toRemove = em.find(Recipe.class, id);
        System.out.println(toRemove.getRecipeId());
        recipeDAO.delete(toRemove.getRecipeId());

        Recipe findingRemovedAuthor = em.find(Recipe.class, toRemove.getRecipeId());

        assertNull(findingRemovedAuthor);

    }
}