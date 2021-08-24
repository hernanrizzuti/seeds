package co.uk.rizzutih.web.response.factory;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import org.junit.jupiter.api.Test;

import static co.uk.rizzutih.builders.TestIngredientGroupBuilder.testIngredientGroupBuilder;
import static org.junit.jupiter.api.Assertions.*;

class IngredientGroupResponseFactoryTest {

    @Test
    public void shouldReturnIngredientGroupResponse(){
        final IngredientGroup ingredientGroup = testIngredientGroupBuilder().build();
        final IngredientGroupResponseFactory  ingredientGroupResponseFactory = new IngredientGroupResponseFactory();
        final IngredientGroupResponse ingredientGroupResponse = ingredientGroupResponseFactory.getInstance(ingredientGroup);
        assertEquals(ingredientGroup.getId(), ingredientGroupResponse.getId());
        assertEquals(ingredientGroup.getName(), ingredientGroupResponse.getName());
    }

}