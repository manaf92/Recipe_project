package se.lexicon.Recipe_project.models.dto.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RecipeInstructionFormDTO {
    private String instructionId;

    @NotBlank(message = "instructions can not be empty.")
    @Size(min = 2, max = 1500, message = "instructions Needs to be between 2 and 1500 character")
    private String instructions;

    public RecipeInstructionFormDTO(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
