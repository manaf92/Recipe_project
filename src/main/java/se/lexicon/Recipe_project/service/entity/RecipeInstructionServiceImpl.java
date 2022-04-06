package se.lexicon.Recipe_project.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.Repositories.RecipeInstructionDAORepository;
import se.lexicon.Recipe_project.models.dto.form.RecipeInstructionFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeInstructionViewDTO;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;
import se.lexicon.Recipe_project.service.convertor.EntityFormDTOConverter;
import se.lexicon.Recipe_project.service.entity.interfaces.RecipeInstructionService;
import se.lexicon.Recipe_project.service.facade.EntityViewConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {
    private final RecipeInstructionDAORepository repository;
    private final EntityFormDTOConverter formDTOConverter;
    private final EntityViewConverter viewConverter;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionDAORepository repository, EntityFormDTOConverter formDTOConverter, EntityViewConverter viewConverter) {
        this.repository = repository;
        this.formDTOConverter = formDTOConverter;
        this.viewConverter = viewConverter;
    }

    @Override
    public RecipeInstructionViewDTO create(RecipeInstructionFormDTO dto) {
        if (dto == null) throw new IllegalArgumentException("RecipeInstructionFormDTO was null");
        RecipeInstruction recipeInstruction =repository.create(formDTOConverter.DTOToRecipeInstruction(dto));
        return viewConverter.toRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public List<RecipeInstructionViewDTO> findAll() {
        List<RecipeInstructionViewDTO> list = new ArrayList<>();
        repository.findAll().forEach(recipeInstruction -> list.add(viewConverter.toRecipeInstructionDTO(recipeInstruction)));
        return list;
    }

    @Override
    public RecipeInstructionViewDTO findById(String id) {
        if (id == null ) throw new IllegalArgumentException("id was null");
        Optional<RecipeInstruction> found =repository.findById(id);
        if (found.isEmpty()) throw new IllegalArgumentException("id does not match");
         return  viewConverter.toRecipeInstructionDTO(found.get());

    }

    @Override
    public RecipeInstructionViewDTO update(RecipeInstructionFormDTO dto) {
        if (dto == null) throw new  IllegalArgumentException("dto was null");
        if (dto.getInstructionId() == null) throw new  IllegalArgumentException("dto.getInstructionId() was null");
        Optional<RecipeInstruction> found = repository.findById(dto.getInstructionId());
        if (!found.isPresent()) throw new  IllegalArgumentException("the object was not found");
        RecipeInstruction recipeInstruction = found.get();
        recipeInstruction.setInstructions(dto.getInstructions());
        return viewConverter.toRecipeInstructionDTO(recipeInstruction);

    }

    @Override
    public boolean delete(String id) {
        if (repository.findById(id).isPresent()){
            repository.delete(id);
            return true;
        }
        else {
            return false;
        }
    }
}
