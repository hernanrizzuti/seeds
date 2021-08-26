package co.uk.rizzutih.web.controller;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.service.IngredientGroupService;
import co.uk.rizzutih.web.request.IngredientGroupRequest;
import co.uk.rizzutih.web.response.BaseResponse;
import co.uk.rizzutih.web.response.IngredientGroupResponse;
import co.uk.rizzutih.web.response.factory.IngredientGroupResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/ingredients-group")
public class IngredientGroupController {

    private IngredientGroupService ingredientGroupService;

    private IngredientGroupResponseFactory ingredientGroupresponseFactory;

    public IngredientGroupController(final IngredientGroupService ingredientGroupService,
                                     final IngredientGroupResponseFactory ingredientGroupresponseFactory) {
        this.ingredientGroupService = ingredientGroupService;
        this.ingredientGroupresponseFactory = ingredientGroupresponseFactory;
    }

    @GetMapping(produces=APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<IngredientGroupResponse> get(@PathVariable final Long id) throws IngredientGroupNotFoundException {

        final IngredientGroup ingredientGroup = ingredientGroupService.getIngredientGroup(id);

        final IngredientGroupResponse ingredientGroupResponse = ingredientGroupresponseFactory.getInstance(ingredientGroup);

        return ResponseEntity.ok(ingredientGroupResponse);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(final @RequestBody @Valid IngredientGroupRequest ingredientGroupRequest){
        final Long id = ingredientGroupService.createIngredientGroup(ingredientGroupRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.builder().id(id).build());
    }

}
