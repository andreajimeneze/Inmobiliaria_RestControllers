package cl.praxis.inmobiliaria.services.impl;

import cl.praxis.inmobiliaria.entities.Propiedad;
import cl.praxis.inmobiliaria.respository.IPropiedadRepository;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadService implements ICrudGenericoService<Propiedad> {
    @Autowired
    IPropiedadRepository propiedadRepo;

    @Override
    public List<Propiedad> listar() {
        return propiedadRepo.findAll();
    }

    @Override
    public Propiedad buscarPorId(int id) {
        return propiedadRepo.findById(id).orElse(null);
    }

    @Override
    public Propiedad guardar(Propiedad propiedad) {
        return propiedadRepo.save(propiedad);
    }

    @Override
    public Propiedad actualizar(Propiedad propiedad) {
        return propiedadRepo.save(propiedad);
    }

    @Override
    public void remover(Propiedad propiedad) {
        propiedadRepo.delete(propiedad);
    }
}
