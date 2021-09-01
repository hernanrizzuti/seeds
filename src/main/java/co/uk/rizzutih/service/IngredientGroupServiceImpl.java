package co.uk.rizzutih.service;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.factory.IngredientGroupFactory;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.repository.IngredientGroupRepository;
import co.uk.rizzutih.web.request.IngredientGroupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@Slf4j
public class IngredientGroupServiceImpl implements IngredientGroupService {

    private IngredientGroupRepository ingredientGroupRepository;

    private IngredientGroupFactory ingredientGroupFactory;

    public IngredientGroupServiceImpl(final IngredientGroupRepository ingredientGroupRepository,
                                      final IngredientGroupFactory ingredientGroupFactory) {
        this.ingredientGroupRepository = ingredientGroupRepository;
        this.ingredientGroupFactory = ingredientGroupFactory;
    }

    @Override
    public IngredientGroup getIngredientGroup(final Long id) throws IngredientGroupNotFoundException {
        final Optional<IngredientGroup> ingredientGroup = ingredientGroupRepository.findById(id);
        if (ingredientGroup.isEmpty()) {
            final String message = format("IngredientGroup with id %s was not found", id);
            log.warn(message);
            //TODO: Add ControllerAdviseHandler
            throw new IngredientGroupNotFoundException(message);
        }
        return ingredientGroup.get();
    }

    @Override
    public Long createIngredientGroup(final IngredientGroupRequest ingredientGroupRequest) {
        final IngredientGroup ingredientGroup = ingredientGroupFactory.getInstance(ingredientGroupRequest);
        final Long id = ingredientGroupRepository.save(ingredientGroup).getId();
        log.info(format("Ingredient group with id %s", id));
        return id;
    }
}
