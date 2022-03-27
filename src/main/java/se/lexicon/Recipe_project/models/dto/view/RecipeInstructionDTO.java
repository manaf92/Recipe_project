package se.lexicon.Recipe_project.models.dto.view;

public class RecipeInstructionDTO {
    private String instructionId;
    private String instructions;

    public RecipeInstructionDTO(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }
}
