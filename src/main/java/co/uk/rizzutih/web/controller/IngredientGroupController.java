package co.uk.rizzutih.web.controller;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.service.IngredientGroupService;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import co.uk.rizzutih.web.response.factory.IngredientGroupResponseFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ingredients")
public class IngredientGroupController {

    private IngredientGroupService ingredientGroupService;

    private IngredientGroupResponseFactory ingredientGroupresponseFactory;

    public IngredientGroupController(IngredientGroupService ingredientGroupService, IngredientGroupResponseFactory ingredientGroupresponseFactory) {
        this.ingredientGroupService = ingredientGroupService;
        this.ingredientGroupresponseFactory = ingredientGroupresponseFactory;
    }

    @GetMapping("{id}")//TODO: continue defining endpoint
    public ResponseEntity<IngredientGroupResponse> get(@PathVariable final Long id) {
        final IngredientGroup ingredientGroup = ingredientGroupService.get(id);

        final IngredientGroupResponse ingredientGroupResponse = ingredientGroupresponseFactory.getInstance(ingredientGroup);

        return ResponseEntity.ok(ingredientGroupResponse);
    }

}
