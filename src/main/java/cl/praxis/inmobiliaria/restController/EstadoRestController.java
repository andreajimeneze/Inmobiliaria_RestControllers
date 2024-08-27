package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.Estado;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import cl.praxis.inmobiliaria.services.impl.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Estado buscarEstado(@RequestParam int id) {
        return estadoService.buscarPorId(id);
    }

    @PostMapping("/nuevo")
    public Estado agregarEstado(@RequestBody Estado estado) {
        return estadoService.guardar(estado);
    }

    @PutMapping("/actualizar")
    public Estado actualizarEstado(@RequestBody Estado estado) {
        return estadoService.actualizar(estado);
    }

    @DeleteMapping("/eliminar")
    public void eliminarEstado(@RequestBody Estado estado) {
        estadoService.remover(estado);
    }
}
