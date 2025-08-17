package ec.sasf.ms_comp_prueba_freya_lopez.service;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ClienteEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.OrdenEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ProductoEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.ClienteRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.OrdenRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdenService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdenRepository ordenRepository;

    public OrdenEntity crearOrden(Long idCliente, List<Long> idsProducto) {
        ClienteEntity cliente = clienteRepository.findById(idCliente).orElseThrow();
        List<ProductoEntity> productos = productoRepository.findAllById(idsProducto);

       double total = productos.stream()
                .mapToDouble(ProductoEntity::getPrecio)
                .sum();

       OrdenEntity orden = new OrdenEntity();
       orden.setCliente(cliente);
       orden.setProductos(productos);
       orden.setTotal(total);
       orden.setFecha(new Date());

       return ordenRepository.save(orden);
    }

    public List<OrdenEntity> listaCliente(Long idCliente) {
        return ordenRepository.findByClienteId(idCliente);
    }
}
