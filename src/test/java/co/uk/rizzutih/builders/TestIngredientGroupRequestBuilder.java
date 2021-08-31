package co.uk.rizzutih.builders;

import co.uk.rizzutih.web.request.IngredientGroupRequest;

import static uk.org.fyodor.generators.RDG.string;

public class TestIngredientGroupRequestBuilder {

    private String name = string().next();

    private TestIngredientGroupRequestBuilder() {
    }

    public static TestIngredientGroupRequestBuilder testIngredientGroupRequestBuilder() {
        return new TestIngredientGroupRequestBuilder();
    }

    public IngredientGroupRequest build() {
        return IngredientGroupRequest.builder().name(name).build();
    }
}
