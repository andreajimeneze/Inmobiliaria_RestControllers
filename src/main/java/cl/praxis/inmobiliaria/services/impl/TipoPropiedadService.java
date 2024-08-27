package cl.praxis.inmobiliaria.services.impl;

import cl.praxis.inmobiliaria.entities.TipoPropiedad;
import cl.praxis.inmobiliaria.respository.ITipoPropiedadRepository;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPropiedadService implements ICrudGenericoService<TipoPropiedad> {
    @Autowired
    ITipoPropiedadRepository tipoPropiedadRepo;

    @Override
    public List<TipoPropiedad> listar() {
        return tipoPropiedadRepo.findAll();
    }

    @Override
    public TipoPropiedad buscarPorId(int id) {
        return tipoPropiedadRepo.findById(id).orElse(null);
    }

    @Override
    public TipoPropiedad guardar(TipoPropiedad tipoPropiedad) {
        return tipoPropiedadRepo.save(tipoPropiedad);
    }

    @Override
    public TipoPropiedad actualizar(TipoPropiedad tipoPropiedad) {
        return tipoPropiedadRepo.save(tipoPropiedad);
    }

    @Override
    public void remover(TipoPropiedad tipoPropiedad) {
        tipoPropiedadRepo.delete(tipoPropiedad);
    }
}
