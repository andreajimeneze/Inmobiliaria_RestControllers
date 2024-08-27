package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "propiedades")
public class Propiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String direccion;
    private int numeroDireccion;
    private int metraje;
    private int numeroAmbientes;
    private int numeroBanos;
    private int precio;

    @ManyToOne
    @JoinColumn(name = "tipo_propiedad_id")
    private TipoPropiedad tipoPropiedad;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "condicion_id")
    private Condicion tipoCondicion;
}
