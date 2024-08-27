package cl.praxis.inmobiliaria.services.impl;

import cl.praxis.inmobiliaria.entities.Condicion;
import cl.praxis.inmobiliaria.respository.ICondicionRepository;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionService implements ICrudGenericoService<Condicion> {
    @Autowired
    ICondicionRepository condicionRepo;

    @Override
    public List<Condicion> listar() {
        return condicionRepo.findAll();
    }

    @Override
    public Condicion buscarPorId(int id) {
        return condicionRepo.findById(id).orElse(null);
    }

    @Override
    public Condicion guardar(Condicion condicion) {
        return condicionRepo.save(condicion);
    }

    @Override
    public Condicion actualizar(Condicion condicion) {
        return condicionRepo.save(condicion);
    }

    @Override
    public void remover(Condicion condicion) {
        condicionRepo.delete(condicion);
    }
}
