package co.uk.rizzutih.builders;

import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.web.response.IngredientGroupResponse;

import static uk.org.fyodor.generators.RDG.longVal;
import static uk.org.fyodor.generators.RDG.string;

public class TestIngredientGroupBuilder {

    private Long id = longVal().next();

    private String name = string().next();

    private TestIngredientGroupBuilder() {
    }

    public static TestIngredientGroupBuilder testIngredientGroupBuilder(){
        return new TestIngredientGroupBuilder();
    }

    public IngredientGroup build(){
        return IngredientGroup.builder()
                .id(id)
                .name(name)
                .build();
    }
}
