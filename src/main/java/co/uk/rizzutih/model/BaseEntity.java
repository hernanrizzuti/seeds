package co.uk.rizzutih.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@SuperBuilder
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "default_gen")
    private long id;

    @CreationTimestamp
    private LocalDateTime createdDatetime;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDatetime;
}
