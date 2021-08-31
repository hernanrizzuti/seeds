package co.uk.rizzutih.factory;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.request.IngredientGroupRequest;
import org.junit.jupiter.api.Test;

import static co.uk.rizzutih.builders.TestIngredientGroupRequestBuilder.testIngredientGroupRequestBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientGroupFactoryTest {

    @Test
    public void shouldReturnIngredientGroup() {
        final IngredientGroupRequest ingredientGroupRequest = testIngredientGroupRequestBuilder().build();
        final IngredientGroupFactory ingredientGroupFactory = new IngredientGroupFactory();
        final IngredientGroup ingredientGroup = ingredientGroupFactory.getInstance(ingredientGroupRequest);
        assertEquals(ingredientGroupRequest.getName(), ingredientGroup.getName());
    }
}
