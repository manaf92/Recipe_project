package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import se.lexicon.Recipe_project.dao.Data;
import se.lexicon.Recipe_project.models.entity.Ingredient;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
class RecipeInstructionDAORepositoryTest {

    @Autowired
    private RecipeInstructionDAORepository instructionDAORepository;
    @Autowired
    private TestEntityManager em;

    RecipeInstruction RecipeInstruction1;
    String id;

    Ingredient ingredient;

    @BeforeEach
    void setUp() {
        //Data Class is  in: test/java/se/lexicon/Recipe_project/dao/Data.java
        Data data = new Data(em);
        RecipeInstruction1 =data.getRecipeInstruction1();
        id = RecipeInstruction1.getInstructionId();
        ingredient = data.getIngredient1();

    }
    @Test
    void create() {
        int ex = instructionDAORepository.findAll().size() + 1;
        instructionDAORepository.create(new RecipeInstruction(null,"put potato on"));
        int ac = instructionDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void findById() {
        String ex = id;
        RecipeInstruction RecipeInstruction =  instructionDAORepository.findById(id).get();
        String ac = RecipeInstruction.getInstructionId();
        assertEquals(ex,ac);
    }

    @Test
    void findAll() {
        int ex = 2;
        int ac =  instructionDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void update() {
        String ex = "put potato on";
        RecipeInstruction ri = new RecipeInstruction(id,"put potato on");
        instructionDAORepository.update(ri);
        String ac = instructionDAORepository.findById(id).get().getInstructions();
        assertEquals(ex,ac);
    }

    @Test
    void delete() {
        System.out.println(id);
        instructionDAORepository.delete(id);
        RecipeInstruction findingRemovedIngredient = em.find(RecipeInstruction.class, id);
        assertNull(findingRemovedIngredient);
    }

}