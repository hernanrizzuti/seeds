package co.uk.rizzutih.service;

import co.uk.rizzutih.exception.IngredientGroupNotFoundException;
import co.uk.rizzutih.model.IngredientGroup;
import co.uk.rizzutih.repository.IngredientGroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static co.uk.rizzutih.builders.TestIngredientGroupBuilder.testIngredientGroupBuilder;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.org.fyodor.generators.RDG.longVal;

@ExtendWith(MockitoExtension.class)
class IngredientGroupServiceImplTest {

    @Mock
    private IngredientGroupRepository ingredientGroupRepository;

    private IngredientGroupService ingredientGroupService;

    @BeforeEach
    public void setUp() {
        ingredientGroupService = new IngredientGroupServiceImpl(ingredientGroupRepository);
    }

    @Test
    public void shouldReturnIngredientGroupRepo() throws IngredientGroupNotFoundException {
        final long id = longVal().next();
        final IngredientGroup ingredientGroupExpected = testIngredientGroupBuilder().build();
        when(ingredientGroupRepository.findById(id)).thenReturn(Optional.of((ingredientGroupExpected)));
        final IngredientGroup ingredientGroupActual = ingredientGroupService.getIngredientGroup(id);
        assertEquals(ingredientGroupExpected, ingredientGroupActual);
    }

    @Test
    public void shouldThrowExceptionWhenIdNotFound() {
        final long id = longVal().next();
        when(ingredientGroupRepository.findById(id)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> ingredientGroupService.getIngredientGroup(id))
                .isInstanceOf(IngredientGroupNotFoundException.class)
                .hasMessage(format("IngredientGroup with id %s was not found", id));
    }

}