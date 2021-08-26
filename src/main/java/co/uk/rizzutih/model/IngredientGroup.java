package co.uk.rizzutih.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_group", schema = "seeds")
@SequenceGenerator(name = "default_gen", sequenceName = "ingredient_group_id_seq", allocationSize = 1)
@Getter
@SuperBuilder
@NoArgsConstructor
public class IngredientGroup extends BaseEntity {

    private String name;

}




