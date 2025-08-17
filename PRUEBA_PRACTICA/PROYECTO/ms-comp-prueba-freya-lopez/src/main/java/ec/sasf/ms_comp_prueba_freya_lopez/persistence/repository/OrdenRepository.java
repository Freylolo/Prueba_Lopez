package ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.OrdenEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrdenRepository extends ListCrudRepository<OrdenEntity, Long> {
    List<OrdenEntity> findByClienteId(Long clienteId);
}
