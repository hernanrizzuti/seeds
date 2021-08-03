package co.uk.rizzutih.builders;

import co.uk.rizzutih.web.response.IngredientGroupResponse;

import static uk.org.fyodor.generators.RDG.longVal;
import static uk.org.fyodor.generators.RDG.string;

public class TestIngredientGroupResponseBuilder {

    private Long id = longVal().next();

    private String name = string().next();

    private TestIngredientGroupResponseBuilder() {
    }

    public static TestIngredientGroupResponseBuilder testIngredientGroupResponseBuilder(){
        return new TestIngredientGroupResponseBuilder();
    }

    public IngredientGroupResponse build(){
        return IngredientGroupResponse.builder()
                .id(id)
                .name(name)
                .build();
    }
}
