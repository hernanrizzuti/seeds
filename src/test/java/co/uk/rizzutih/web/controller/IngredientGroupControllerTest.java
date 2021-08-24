package co.uk.rizzutih.web.controller;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.service.IngredientGroupService;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import co.uk.rizzutih.web.response.factory.IngredientGroupResponseFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static co.uk.rizzutih.builders.TestIngredientGroupBuilder.testIngredientGroupBuilder;
import static co.uk.rizzutih.builders.TestIngredientGroupResponseBuilder.testIngredientGroupResponseBuilder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.org.fyodor.generators.RDG.longVal;

@ExtendWith(MockitoExtension.class)
class IngredientGroupControllerTest {

    @Mock
    private IngredientGroupService ingredientGroupService;

    @Mock
    private IngredientGroupResponseFactory ingredientGroupresponseFactory;

    @Test
    public void shouldReturnIngredientGroup() throws IngredientGroupNotFoundException {
        final IngredientGroupController ingredientGroupController = new IngredientGroupController(ingredientGroupService,
                ingredientGroupresponseFactory);
        final Long id = longVal().next();
        final IngredientGroup ingredientGroup = testIngredientGroupBuilder().build();
        final IngredientGroupResponse ingredientGroupResponse = testIngredientGroupResponseBuilder().build();
        when(ingredientGroupService.getIngredientGroup(id)).thenReturn(ingredientGroup);
        when(ingredientGroupresponseFactory.getInstance(ingredientGroup)).thenReturn(ingredientGroupResponse);

        ingredientGroupController.get(id);
        verify(ingredientGroupService).getIngredientGroup(id);
        verify(ingredientGroupresponseFactory).getInstance(ingredientGroup);
    }

}