package co.uk.rizzutih.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_group", schema = "seeds")
@SequenceGenerator(name = "default_gen", sequenceName = "ingredient_group_id_seq", allocationSize = 1)
@NoArgsConstructor
@Builder
@Getter
public class IngredientGroup {

    @Id
    private long id;

    private String name;

}
