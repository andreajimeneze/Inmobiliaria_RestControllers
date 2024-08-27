package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.Estado;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoRestController {
    @Autowired
    private ICrudGenericoService<Estado> estadoService;

    @GetMapping("/estados")
    public List<Estado> listarEstados() {
        return estadoService.listar();
    }

    @GetMapping("/estado")
    public ResponseEntity<?> buscarEstado(@RequestParam int id) {
        Estado estadoEncontrado = estadoService.buscarPorId(id);
        if (estadoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estado no encontrado");
        }
        return ResponseEntity.ok(estadoEncontrado);
    }

    @PostMapping("/nuevo")
    public Estado agregarEstado(@RequestBody Estado estado) {
        return estadoService.guardar(estado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarEstado(@RequestBody Estado estado) {
        Estado estadoEncontrado = estadoService.buscarPorId(estado.getId());
        if (estadoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estado no encontrado");
        }
        estadoService.actualizar(estado);
        return ResponseEntity.ok(estadoEncontrado);
    }


    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarEstado(@RequestBody Estado estado) {
        Estado estadoEncontrado = estadoService.buscarPorId(estado.getId());
        if(estadoEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estado no encontrado");
        }
        estadoService.remover(estado);
        return ResponseEntity.ok(estadoEncontrado);
    }
}
