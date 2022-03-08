package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import se.lexicon.Recipe_project.models.RecipeInstruction;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
class RecipeInstructionDAORepositoryTest {

    List<RecipeInstruction> recipeInstructions;
    RecipeInstruction ri1;
    @Autowired
    private RecipeInstructionDAORepository testObject ;
    @Autowired
    private TestEntityManager em;
    @BeforeEach
    void setUp() {
        recipeInstructions = new ArrayList<>(Arrays.asList(
                new RecipeInstruction(null,"svenson"),
                new RecipeInstruction(null,"Sy"),
                new RecipeInstruction(null,"Anderson")
        ));
        recipeInstructions.forEach(d-> em.persist(d));
        ri1 = recipeInstructions.get(0);

    }

    @Test
    void create() {
        RecipeInstruction ri4= new RecipeInstruction(null,"Anderson");
        testObject.create(ri4);
        System.out.println(em.find(RecipeInstruction.class,"s") + "\ncount ");;

    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }
}