package se.lexicon.Recipe_project.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.Repositories.IngredientDaoRepository;
import se.lexicon.Recipe_project.models.dto.form.IngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.IngredientViewDTO;
import se.lexicon.Recipe_project.models.entity.Ingredient;
import se.lexicon.Recipe_project.service.convertor.EntityFormDTOConverter;
import se.lexicon.Recipe_project.service.entity.interfaces.IngredientService;
import se.lexicon.Recipe_project.service.facade.EntityViewConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private EntityFormDTOConverter formDTOConverter;
    private EntityViewConverter viewConverter;
    private final IngredientDaoRepository repository;

    @Autowired
    public IngredientServiceImpl(EntityFormDTOConverter formDTOConverter, EntityViewConverter viewConverter, IngredientDaoRepository repository) {
        this.formDTOConverter = formDTOConverter;
        this.viewConverter = viewConverter;
        this.repository = repository;
    }

    @Override
    public IngredientViewDTO create(IngredientFormDTO ingredientFormDTO) {
       return viewConverter.toIngredientDTO( repository.create(formDTOConverter.DTOToIngredient(ingredientFormDTO)));
    }

    @Override
    public Collection<IngredientViewDTO> findAll() {
        List<IngredientViewDTO> ingredientViewDTOS= new ArrayList<>();
        repository.findAll().forEach(ingredient -> ingredientViewDTOS.add(viewConverter.toIngredientDTO(ingredient)));
        return ingredientViewDTOS;
    }

    @Override
    public IngredientViewDTO findById(Integer id) {
        Optional<Ingredient> found = repository.findById(id);
        if (found.isEmpty()) throw new IllegalArgumentException("ingredient with id "+ id +" not found");
        return viewConverter.toIngredientDTO(found.get()) ;
    }

    @Override
    public IngredientViewDTO update(IngredientFormDTO ingredientFormDTO) {
        if (ingredientFormDTO == null) throw new  IllegalArgumentException("ingredientFormDTO was null");
        if (ingredientFormDTO.getIngredientId() == 0) throw new  IllegalArgumentException("ingredientFormDTO.getIngredientId() was 0");
        Optional<Ingredient> found = repository.findById(ingredientFormDTO.getIngredientId());
        if (!found.isPresent()) throw new  IllegalArgumentException("ingredient with id: "+ found.get().getIngredientId() +" is not found");
        Ingredient ingredient = found.get();
        ingredient.setIngredientName(ingredient.getIngredientName());
        return viewConverter.toIngredientDTO(ingredient);
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
