package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "condiciones")
public class Condicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "tipoCondicion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Propiedad> propiedades;
}
