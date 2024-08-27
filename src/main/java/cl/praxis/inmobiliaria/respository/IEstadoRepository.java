package cl.praxis.inmobiliaria.respository;

import cl.praxis.inmobiliaria.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
}
