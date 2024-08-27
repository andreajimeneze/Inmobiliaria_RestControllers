package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.TipoPropiedad;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import cl.praxis.inmobiliaria.services.impl.TipoPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipopropiedad")
public class TipoPropiedadRestController {
    @Autowired
    private ICrudGenericoService<TipoPropiedad> tipoPropiedadService;

    @GetMapping("/tipos")
    public List<TipoPropiedad> listarTiposPropiedades() {
        return tipoPropiedadService.listar();
    }

    @GetMapping("/tipo")
    public TipoPropiedad obtenerTipoPropiedad(@RequestParam int id) {
        return tipoPropiedadService.buscarPorId(id);
    }

    @PostMapping("/nuevo")
    public TipoPropiedad agregarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        return tipoPropiedadService.guardar(tipoPropiedad);
    }

    @PutMapping("/actualizar")
    public TipoPropiedad actualizarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        return tipoPropiedadService.actualizar(tipoPropiedad);
    }

    @DeleteMapping("/eliminar")
    public void eliminarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        tipoPropiedadService.remover(tipoPropiedad);
    }
}
