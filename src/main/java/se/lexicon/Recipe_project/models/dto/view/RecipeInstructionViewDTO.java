package se.lexicon.Recipe_project.models.dto.view;

public class RecipeInstructionViewDTO {
    private String instructionId;
    private String instructions;

    public RecipeInstructionViewDTO(String instructionId, String instructions) {
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
