package se.lexicon.Recipe_project.models.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "instruction_id")
    private String instructionId;
    @Column(name = "instructions", length = 1500)
    private String instructions;

    public RecipeInstruction(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public RecipeInstruction() {
    }

    public String getInstructionId() {
        return instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return instructionId.equals(that.instructionId) && instructions.equals(that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instructions);
    }
}
