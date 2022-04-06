package se.lexicon.Recipe_project.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.Repositories.RecipeIngredientDAORepository;
import se.lexicon.Recipe_project.models.dto.form.RecipeIngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeIngredientViewDTO;
import se.lexicon.Recipe_project.models.entity.RecipeIngredient;
import se.lexicon.Recipe_project.service.convertor.EntityFormDTOConverter;
import se.lexicon.Recipe_project.service.entity.interfaces.RecipeIngredientService;
import se.lexicon.Recipe_project.service.facade.EntityViewConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
    private final RecipeIngredientDAORepository repository;
    private final EntityFormDTOConverter formDTOConverter;
    private final EntityViewConverter viewConverter;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientDAORepository repository, EntityFormDTOConverter formDTOConverter, EntityViewConverter viewConverter) {
        this.repository = repository;
        this.formDTOConverter = formDTOConverter;
        this.viewConverter = viewConverter;
    }

    @Override
    public RecipeIngredientViewDTO create(RecipeIngredientFormDTO dto) {
        if(dto == null) throw new IllegalArgumentException("recipeIngredient was null");
        RecipeIngredient recipeIngredient = new RecipeIngredient(
                null,dto.getAmount(),
                formDTOConverter.DTOToIngredient(dto.getIngredient()),
                dto.getMeasurement(),
                formDTOConverter.DTOToRecipe(dto.getRecipe()));
        return viewConverter.toSmallRecipeIngredientExcludingRecipe(repository.create(recipeIngredient));
    }

    @Override
    public List<RecipeIngredientViewDTO> findAll() {
        List<RecipeIngredientViewDTO> list = new ArrayList<>();
        repository.findAll().forEach(ri -> list.add(viewConverter.toSmallRecipeIngredientExcludingRecipe(ri)));
        return list;
    }

    @Override
    public RecipeIngredientViewDTO findById(String id) {
        if (repository.findById(id).isEmpty()) throw new IllegalArgumentException("id: "+ id +" not ");
        return viewConverter.toFullRecipeIngredient(repository.findById(id).get());
    }

    @Override
    public RecipeIngredientViewDTO update(RecipeIngredientFormDTO dto) {
        if(dto == null || dto.getRecipeIngredientId() == null) throw new IllegalArgumentException("RecipeIngredientFormDTO or Id form was null");
        Optional<RecipeIngredient> found = repository.findById(dto.getRecipeIngredientId());
        if (found.isEmpty()) throw new  IllegalArgumentException("RecipeIngredient with id: "+dto.getRecipeIngredientId() +" is not found");
        RecipeIngredient recipeIngredient = found.get();
        recipeIngredient.setIngredient(formDTOConverter.DTOToIngredient(dto.getIngredient()));
        recipeIngredient.setRecipe(formDTOConverter.DTOToRecipe(dto.getRecipe()));
        return viewConverter.toFullRecipeIngredient(repository.update(recipeIngredient));
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
