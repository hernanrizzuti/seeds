package co.uk.rizzutih.web.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class IngredientGroupResponse extends BaseResponse{

    private String name;
}
