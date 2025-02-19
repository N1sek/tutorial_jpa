package org.iesvdm.tutorial.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;


    private String nombre;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNac;

    @ManyToOne
    @ToString.Exclude
    private Mision mision;

    @ManyToMany(mappedBy = "heroes")
    @Builder.Default
    Set<Poder> poderes = new HashSet<>();

}
