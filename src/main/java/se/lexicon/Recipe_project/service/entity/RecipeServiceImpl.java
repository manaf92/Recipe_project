package se.lexicon.Recipe_project.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.Repositories.RecipeDAORepository;
import se.lexicon.Recipe_project.models.dto.form.RecipeFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeViewDTO;
import se.lexicon.Recipe_project.models.entity.Recipe;
import se.lexicon.Recipe_project.service.convertor.EntityFormDTOConverter;
import se.lexicon.Recipe_project.service.entity.interfaces.RecipeService;
import se.lexicon.Recipe_project.service.facade.EntityViewConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAORepository repository;
    private final EntityFormDTOConverter formDTOConverter;
    private final EntityViewConverter viewConverter;

    @Autowired
    public RecipeServiceImpl(RecipeDAORepository repository, EntityFormDTOConverter formDTOConverter, EntityViewConverter viewConverter) {
        this.repository = repository;
        this.formDTOConverter = formDTOConverter;
        this.viewConverter = viewConverter;
    }



    @Override
    public RecipeViewDTO create(RecipeFormDTO dto) {
        if (dto == null) throw new IllegalArgumentException("RecipeInstructionFormDTO was null");
        Recipe recipe =repository.create(formDTOConverter.DTOToRecipe(dto));
        return viewConverter.toSmallRecipeExcludingCategory(recipe);
    }

    @Override
    public Collection<RecipeViewDTO> findAll() {
        List<RecipeViewDTO> list = new ArrayList<>();
        repository.findAll().forEach(recipe -> list.add(viewConverter.toSmallRecipeExcludingCategory(recipe)));
        return list;
    }

    @Override
    public RecipeViewDTO findById(Integer id) {
        if (id == null ) throw new IllegalArgumentException("id was null");
        Optional<Recipe> found =repository.findById(id);
        if (found.isEmpty()) throw new IllegalArgumentException("id does not match");
        return  viewConverter.toSmallRecipeExcludingCategory(found.get());
    }

    @Override
    public RecipeViewDTO update(RecipeFormDTO dto) {
        if (dto == null) throw new  IllegalArgumentException("dto was null");
        if (dto.getRecipeId() == 0) throw new  IllegalArgumentException("dto.getRecipeId() was null");
        Optional<Recipe> found = repository.findById(dto.getRecipeId());
        if (!found.isPresent()) throw new  IllegalArgumentException("the object is not found");
        Recipe recipe = found.get();
        recipe.setRecipeCategories(formDTOConverter.setOfDtoToSetOfRecipeCategory(dto.getRecipeCategories()));
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setRecipeInstruction(formDTOConverter.DTOToRecipeInstruction(dto.getRecipeInstruction()));
        recipe.setRecipeIngredients(formDTOConverter.listOfDtoToListOfRecipeIngredient(dto.getRecipeIngredients()));
        return viewConverter.toSmallRecipeExcludingCategory(recipe);
    }

    @Override
    public boolean delete(Integer id) {
        if (repository.findById(id).isPresent()){
            repository.delete(id);
            return true;
        }
        else {
            return false;
        }
    }
}
