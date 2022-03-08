package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.Recipe_project.dao.Data;
import se.lexicon.Recipe_project.models.entity.RecipeCategory;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class RecipeCategoryDAORepositoryTest {
    @Autowired
    private RecipeCategoryDAORepository categoryDAORepository;
    @Autowired
    private TestEntityManager em;

    RecipeCategory recipeCategory1;
    int id;

    @BeforeEach
    void setUp() {
        //Data Class is  in: test/java/se/lexicon/Recipe_project/dao/Data.java
        Data data = new Data(em);
        recipeCategory1=data.getRecipeCategory1();
        id = recipeCategory1.getCategoryId();
    }
    @Test
    void create() {
        int ex = categoryDAORepository.findAll().size() + 1;
        categoryDAORepository.create(new RecipeCategory(0,"fit"));
        int ac = categoryDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void findById() {
        int ex = id;
        RecipeCategory recipeCategory =  categoryDAORepository.findById(id);
        int ac = recipeCategory.getCategoryId();
        assertEquals(ex,ac);
    }

    @Test
    void findAll() {
        int ex = 3;
        int ac =  categoryDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void update() {
        String ex = "fit";
        RecipeCategory recipeCategory =  categoryDAORepository.update(new RecipeCategory(id,"fit"));
        String ac = categoryDAORepository.findById(id).getCategory();
        assertEquals(ex,ac);
    }

    @Test
    void delete() {
        System.out.println(id);
        categoryDAORepository.delete(id);
        RecipeCategory findingRemovedIngredient = em.find(RecipeCategory.class, id);
        assertNull(findingRemovedIngredient);
    }

}