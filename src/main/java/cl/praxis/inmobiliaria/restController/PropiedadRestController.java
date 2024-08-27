package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.Propiedad;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedad")
public class PropiedadRestController {
    @Autowired
    ICrudGenericoService<Propiedad> propiedadService;

    @GetMapping("/propiedades")
    public List<Propiedad> listarPropiedades() {
        return propiedadService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPropiedad(@PathVariable int id) {
        Propiedad propiedadEncontrada = propiedadService.buscarPorId(id);
        if (propiedadEncontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Propiedad no encontrada");
        }
        return ResponseEntity.ok(propiedadEncontrada);
    }

    @PostMapping("/nuevo")
    public Propiedad guardarPropiedad(@RequestBody Propiedad propiedad) {
        return propiedadService.guardar(propiedad);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarPropiedad(@RequestBody Propiedad propiedad) {
        Propiedad propiedadEncontrada = propiedadService.buscarPorId(propiedad.getId());
        if (propiedadEncontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Propiedad no encontrada");
        }
        propiedadService.actualizar(propiedad);
        return ResponseEntity.ok(propiedad);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarPropiedad(@RequestBody Propiedad propiedad) {
        Propiedad propiedadEncontrada = propiedadService.buscarPorId(propiedad.getId());
        if (propiedadEncontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Propiedad no encontrada");
        }
        propiedadService.remover(propiedad);
        return ResponseEntity.ok(propiedad);
    }
}
