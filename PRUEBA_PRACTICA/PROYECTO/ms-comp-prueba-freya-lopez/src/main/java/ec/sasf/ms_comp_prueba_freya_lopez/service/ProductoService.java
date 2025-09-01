package ec.sasf.ms_comp_prueba_freya_lopez.service;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ProductoEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public List<ProductoEntity> listaProductos() {
        return productoRepository.findByDisponibleTrue();
    }

    public ProductoEntity actualizarDisponible(Long id, boolean disponible) {
        ProductoEntity producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setDisponible(disponible);
            productoRepository.save(producto);
        }
        return producto;
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public List<ProductoEntity> listarTodos() {
        return productoRepository.findAll();
    }

    public ProductoEntity editarProducto(Long id, ProductoEntity producto) {
        ProductoEntity existente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        existente.setNombre(producto.getNombre());
        existente.setPrecio(producto.getPrecio());
        return productoRepository.save(existente);
    }

}
