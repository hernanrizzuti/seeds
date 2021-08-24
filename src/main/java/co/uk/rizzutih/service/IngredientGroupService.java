package co.uk.rizzutih.service;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;

public interface IngredientGroupService {

    IngredientGroup getIngredientGroup(final Long id) throws IngredientGroupNotFoundException;

}
