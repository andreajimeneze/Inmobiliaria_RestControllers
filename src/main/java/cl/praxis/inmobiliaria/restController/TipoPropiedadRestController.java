package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.TipoPropiedad;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> obtenerTipoPropiedad(@RequestParam int id) {
        TipoPropiedad tipoEncontrado = tipoPropiedadService.buscarPorId(id);
        if (tipoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo Propiedad no encontrado");
        }
        return ResponseEntity.ok(tipoEncontrado);
    }

    @PostMapping("/nuevo")
    public TipoPropiedad agregarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        return tipoPropiedadService.guardar(tipoPropiedad);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        TipoPropiedad tipoEncontrado = tipoPropiedadService.buscarPorId(tipoPropiedad.getId());
        if(tipoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo Propiedad no encontrado");
        }
        tipoPropiedadService.actualizar(tipoPropiedad);
        return ResponseEntity.ok(tipoEncontrado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarTipoPropiedad(@RequestBody TipoPropiedad tipoPropiedad) {
        TipoPropiedad tipoEncontrado = tipoPropiedadService.buscarPorId(tipoPropiedad.getId());
        if(tipoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo Propiedad no encontrado");
        }
        tipoPropiedadService.remover(tipoPropiedad);
        return ResponseEntity.ok(tipoEncontrado);
    }
}
