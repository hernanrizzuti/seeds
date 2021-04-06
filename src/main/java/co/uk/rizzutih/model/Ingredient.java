package co.uk.rizzutih.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredient", schema = "seeds")
@SequenceGenerator(name = "default_gen", sequenceName = "ingredient_id_seq", allocationSize = 1)
@NoArgsConstructor
@Builder
@Getter
public class Ingredient {

    @Id
    private long id;

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ingredient_ingredient_group",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "ingredient_ingredient_group_pkey",
                    columnNames = {"ingredient_id", "ingredient_group_id"}))
    private List<IngredientGroup> ingredientGroups;

}
