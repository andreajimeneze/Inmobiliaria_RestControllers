package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.Condicion;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicion")
public class CondicionRestController {
    @Autowired
    private ICrudGenericoService<Condicion> condicionService;

    @GetMapping("/condiciones")
    public List<Condicion> listarCondiciones(){
        return condicionService.listar();
    }

    @GetMapping("/condicion")
    public ResponseEntity<?> obtenerCondicion(@RequestParam int id){
        Condicion condicion = condicionService.buscarPorId(id);
        if(condicion == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Condicion no encontrada");
        }
        return ResponseEntity.ok(condicion);
    }

    @PostMapping("/nuevo")
    public Condicion agregarCondicion(@RequestBody Condicion condicion){
        return condicionService.guardar(condicion);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCondicion(@RequestBody Condicion condicion){
        Condicion condicionActual = condicionService.buscarPorId(condicion.getId());
        if(condicionActual == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Condicion no encontrada");
        }
        condicionService.actualizar(condicion);
        return ResponseEntity.ok(condicion);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarCondicion(@RequestBody Condicion condicion){
        Condicion condicionAEliminar = condicionService.buscarPorId(condicion.getId());
        if(condicionAEliminar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Condicion no encontrada");
        }
        condicionService.remover(condicion);
        return ResponseEntity.ok(condicion);
    }
}
