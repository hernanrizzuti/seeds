package co.uk.rizzutih.service;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.repository.IngredientGroupRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@Slf4j
public class IngredientGroupServiceImpl implements IngredientGroupService {

    private IngredientGroupRepository ingredientGroupRepository;

    public IngredientGroupServiceImpl(final IngredientGroupRepository ingredientGroupRepository) {
        this.ingredientGroupRepository = ingredientGroupRepository;
    }

    @Override
    public IngredientGroup getIngredientGroup(final Long id) throws IngredientGroupNotFoundException {
        final Optional<IngredientGroup> ingredientGroup = ingredientGroupRepository.findById(id);
        if(ingredientGroup.isEmpty()){
            final String message = format("IngredientGroup with id %s was not found", id);
            log.warn(message);
            throw new IngredientGroupNotFoundException(message);
        }
        return ingredientGroup.get();
    }
}
