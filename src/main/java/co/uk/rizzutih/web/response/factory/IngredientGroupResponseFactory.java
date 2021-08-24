package co.uk.rizzutih.web.response.factory;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import org.springframework.stereotype.Component;

@Component
public class IngredientGroupResponseFactory {

    public IngredientGroupResponse getInstance(final IngredientGroup ingredientGroup) {
        return IngredientGroupResponse.builder()
                .id(ingredientGroup.getId())
                .name(ingredientGroup.getName())
                .build();
    }

}
