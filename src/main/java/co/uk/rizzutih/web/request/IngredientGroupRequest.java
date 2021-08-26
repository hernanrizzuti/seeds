package co.uk.rizzutih.web.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class IngredientGroupRequest {

    @NotEmpty(message = "Name cannot be blank")
    private String name;
}
