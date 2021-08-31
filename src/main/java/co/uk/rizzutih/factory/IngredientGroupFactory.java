package co.uk.rizzutih.factory;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.request.IngredientGroupRequest;
import org.springframework.stereotype.Component;

@Component
public class IngredientGroupFactory {

    public IngredientGroup getInstance(final IngredientGroupRequest ingredientGroupRequest) {
        return IngredientGroup.builder().name(ingredientGroupRequest.getName()).build();
    }
}
