package cl.praxis.inmobiliaria.respository;

import cl.praxis.inmobiliaria.entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropiedadRepository extends JpaRepository<Propiedad, Integer> {
}
