package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tiposPropiedades")
public class TipoPropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "tipoPropiedad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Propiedad> propiedades;
}
