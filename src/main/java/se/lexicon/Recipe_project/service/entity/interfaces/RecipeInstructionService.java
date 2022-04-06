package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.RecipeInstructionFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeInstructionViewDTO;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;

public interface RecipeInstructionService extends GenericServiceCRUD<RecipeInstructionViewDTO, RecipeInstructionFormDTO,String>{
}
