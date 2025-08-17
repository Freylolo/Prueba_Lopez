package ec.sasf.ms_comp_prueba_freya_lopez.web.controller;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ProductoEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.ProductoRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @PostMapping
    public ProductoEntity crearProducto(@RequestBody ProductoEntity producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping("/disponibles")
    public List<ProductoEntity> listarDisponibles() {
        return productoService.listaProductos();

    }

    @PutMapping("/{id}/disponible")
    public ProductoEntity actualizarProducto(@PathVariable Long id, @RequestParam boolean disponible) {
        return productoService.actualizarDisponible(id, disponible);
    }
}
