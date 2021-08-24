package co.uk.rizzutih.web.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IngredientGroupResponse {

    private Long id;

    private String name;
}
