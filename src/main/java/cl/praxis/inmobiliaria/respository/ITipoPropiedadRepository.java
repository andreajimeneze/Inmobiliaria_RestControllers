package cl.praxis.inmobiliaria.respository;

import cl.praxis.inmobiliaria.entities.TipoPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPropiedadRepository extends JpaRepository<TipoPropiedad, Integer> {
}
