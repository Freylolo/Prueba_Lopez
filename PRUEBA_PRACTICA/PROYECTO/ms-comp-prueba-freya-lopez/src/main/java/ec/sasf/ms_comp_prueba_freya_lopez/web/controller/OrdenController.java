package ec.sasf.ms_comp_prueba_freya_lopez.web.controller;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.OrdenEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public OrdenEntity crearOrden(@RequestParam Long idCliente, @RequestBody List<Long> idsProducto) {
        return ordenService.crearOrden(idCliente, idsProducto);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<OrdenEntity> listaPorCliente(@PathVariable Long idCliente) {
        return ordenService.listaCliente(idCliente);
    }

}
