package cl.praxis.inmobiliaria.respository;

import cl.praxis.inmobiliaria.entities.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondicionRepository extends JpaRepository<Condicion, Integer> {
}
