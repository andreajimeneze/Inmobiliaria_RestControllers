package cl.praxis.inmobiliaria.services.impl;

import cl.praxis.inmobiliaria.entities.Estado;
import cl.praxis.inmobiliaria.respository.IEstadoRepository;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements ICrudGenericoService<Estado> {
    @Autowired
    IEstadoRepository estadoRepo;

    @Override
    public List<Estado> listar() {
        return estadoRepo.findAll();
    }

    @Override
    public Estado buscarPorId(int id) {
        return estadoRepo.findById(id).orElse(null);
    }

    @Override
    public Estado guardar(Estado estado) {
        return estadoRepo.save(estado);
    }

    @Override
    public Estado actualizar(Estado estado) {
        return estadoRepo.save(estado);
    }

    @Override
    public void remover(Estado estado) {
        estadoRepo.delete(estado);
    }
}
