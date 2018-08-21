package tacos.data;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@RestResource(rel = "tacos", path = "tacos")
public class Taco {

	@NotNull
    @Size(min=5, message="Name must be at least 5 characters long.")
    private String tacoName;

	@ManyToMany(targetEntity = Ingredient.class)
	@Size(min=1, message="You must choose at least one ingredient.")
    private List<Ingredient> ingredients;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = new Date();
    }

}
