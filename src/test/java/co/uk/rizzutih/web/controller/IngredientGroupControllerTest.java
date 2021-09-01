package co.uk.rizzutih.web.controller;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.service.IngredientGroupService;
import co.uk.rizzutih.web.request.IngredientGroupRequest;
import co.uk.rizzutih.web.response.BaseResponse;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import co.uk.rizzutih.web.response.factory.IngredientGroupResponseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static co.uk.rizzutih.builders.TestIngredientGroupBuilder.testIngredientGroupBuilder;
import static co.uk.rizzutih.builders.TestIngredientGroupRequestBuilder.testIngredientGroupRequestBuilder;
import static co.uk.rizzutih.builders.TestIngredientGroupResponseBuilder.testIngredientGroupResponseBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.org.fyodor.generators.RDG.longVal;

@ExtendWith(MockitoExtension.class)
class IngredientGroupControllerTest {

    @Mock
    private IngredientGroupService ingredientGroupService;

    @Mock
    private IngredientGroupResponseFactory ingredientGroupresponseFactory;

    private IngredientGroupController ingredientGroupController;

    @BeforeEach
    public void setUp() {
        ingredientGroupController = new IngredientGroupController(ingredientGroupService, ingredientGroupresponseFactory);
    }

    @Test
    public void shouldReturnIngredientGroup() throws IngredientGroupNotFoundException {
        final Long id = longVal().next();
        final IngredientGroup ingredientGroup = testIngredientGroupBuilder().build();
        final IngredientGroupResponse ingredientGroupResponse = testIngredientGroupResponseBuilder().build();
        when(ingredientGroupService.getIngredientGroup(id)).thenReturn(ingredientGroup);
        when(ingredientGroupresponseFactory.getInstance(ingredientGroup)).thenReturn(ingredientGroupResponse);

        ingredientGroupController.get(id);
        verify(ingredientGroupService).getIngredientGroup(id);
        verify(ingredientGroupresponseFactory).getInstance(ingredientGroup);
    }

    @Test
    public void shouldReturnCreatedIngredientGroupId() {
        final IngredientGroupRequest ingredientGroupRequest = testIngredientGroupRequestBuilder().build();
        final Long id = longVal().next();
        when(ingredientGroupService.createIngredientGroup(ingredientGroupRequest)).thenReturn(id);
        final ResponseEntity<BaseResponse> response = ingredientGroupController.create(ingredientGroupRequest);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(id, response.getBody().getId());
    }

}