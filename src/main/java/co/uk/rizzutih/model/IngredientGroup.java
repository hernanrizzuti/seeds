package co.uk.rizzutih.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_group", schema = "seeds")
@SequenceGenerator(name = "default_gen", sequenceName = "ingredient_group_id_seq", allocationSize = 1)
@Getter
@Builder
public class IngredientGroup {

    @Id
    private long id;

    private String name;

}




