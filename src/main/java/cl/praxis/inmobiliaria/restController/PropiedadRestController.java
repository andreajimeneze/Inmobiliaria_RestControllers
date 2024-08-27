package cl.praxis.inmobiliaria.restController;

import cl.praxis.inmobiliaria.entities.Propiedad;
import cl.praxis.inmobiliaria.services.ICrudGenericoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Propiedad buscarPropiedad(@PathVariable int id) {
        return propiedadService.buscarPorId(id);
    }

    @PostMapping("/nuevo")
    public Propiedad guardarPropiedad(@RequestBody Propiedad propiedad) {
        return propiedadService.guardar(propiedad);
    }

    @PutMapping("/actualizar")
    public Propiedad actualizarPropiedad(@RequestBody Propiedad propiedad) {
        return propiedadService.actualizar(propiedad);
    }

    @DeleteMapping("/eliminar")
    public void eliminarPropiedad(@RequestBody Propiedad propiedad) {
        propiedadService.remover(propiedad);
    }
}
