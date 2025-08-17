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

}
