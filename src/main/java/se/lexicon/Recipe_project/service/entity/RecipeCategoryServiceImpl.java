package se.lexicon.Recipe_project.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.Repositories.RecipeCategoryDAORepository;
import se.lexicon.Recipe_project.models.dto.form.RecipeCategoryFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeCategoryViewDTO;
import se.lexicon.Recipe_project.models.entity.Recipe;
import se.lexicon.Recipe_project.models.entity.RecipeCategory;
import se.lexicon.Recipe_project.service.convertor.EntityFormDTOConverter;
import se.lexicon.Recipe_project.service.entity.interfaces.RecipeCategoryService;
import se.lexicon.Recipe_project.service.facade.EntityViewConverter;

import java.util.*;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    private final EntityFormDTOConverter formDTOConverter;
    private final EntityViewConverter viewConverter;
    private final RecipeCategoryDAORepository repository;
    @Autowired
    public RecipeCategoryServiceImpl(EntityFormDTOConverter formDTOConverter, EntityViewConverter viewConverter, RecipeCategoryDAORepository repository) {
        this.formDTOConverter = formDTOConverter;
        this.viewConverter = viewConverter;
        this.repository = repository;
    }

    @Override
    public RecipeCategoryViewDTO create(RecipeCategoryFormDTO recipeCategoryFormDTO) {
        return viewConverter.toSmallRecipeCategoryExcludingRecipe( repository.create(formDTOConverter.DTOToRecipeCategory(recipeCategoryFormDTO)));

    }

    @Override
    public List<RecipeCategoryViewDTO> findAll() {
        List<RecipeCategoryViewDTO> recipeCategoryViewDTOS= new ArrayList<>();
        repository.findAll().forEach(recipeCategory -> recipeCategoryViewDTOS.add(viewConverter.toSmallRecipeCategoryExcludingRecipe(recipeCategory)));
        return recipeCategoryViewDTOS;
    }

    @Override
    public RecipeCategoryViewDTO findById(Integer id) {

        Optional<RecipeCategory> found = repository.findById(id);
        if (found.isEmpty()) throw new IllegalArgumentException("RecipeCategory with id "+ id +" not found");
        return viewConverter.toSmallRecipeCategoryExcludingRecipe(found.get()) ;
    }

    @Override
    public RecipeCategoryViewDTO update(RecipeCategoryFormDTO recipeCategoryFormDTO) {
        if (recipeCategoryFormDTO == null) throw new  IllegalArgumentException("recipeCategoryFormDTO was null");
        if (recipeCategoryFormDTO.getCategoryId() == 0) throw new  IllegalArgumentException("recipeCategoryFormDTO.getCategoryId() was 0");
        Optional<RecipeCategory> found = repository.findById(recipeCategoryFormDTO.getCategoryId());
        if (found.isEmpty()) throw new  IllegalArgumentException("RecipeCategory with id: "+recipeCategoryFormDTO.getCategoryId() +" is not found");
        RecipeCategory recipeCategory = found.get();
        recipeCategory.setCategory(recipeCategoryFormDTO.getCategory());
        Set<Recipe> recipeSet = new HashSet<>();
        recipeCategoryFormDTO.getRecipes().forEach(dto -> recipeSet.add(formDTOConverter.DTOToRecipe(dto)));
        recipeCategory.setRecipes(recipeSet);
        return viewConverter.toSmallRecipeCategoryExcludingRecipe(recipeCategory);
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
