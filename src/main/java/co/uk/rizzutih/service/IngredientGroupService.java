package co.uk.rizzutih.service;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.request.IngredientGroupRequest;

public interface IngredientGroupService {

    IngredientGroup getIngredientGroup(final Long id) throws IngredientGroupNotFoundException;

    Long createIngredientGroup(final IngredientGroupRequest ingredientGroupRequest);
}
