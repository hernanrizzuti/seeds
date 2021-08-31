package co.uk.rizzutih.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientGroupRequest {

    @NotEmpty(message = "Name cannot be blank")
    private String name;
}
