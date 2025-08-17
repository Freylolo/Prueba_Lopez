package ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ProductoEntity;


import java.util.List;

public interface ProductoRepository extends ListCrudRepository<ProductoEntity, Long>{
    List<ProductoEntity> findByDisponibleTrue();
}
