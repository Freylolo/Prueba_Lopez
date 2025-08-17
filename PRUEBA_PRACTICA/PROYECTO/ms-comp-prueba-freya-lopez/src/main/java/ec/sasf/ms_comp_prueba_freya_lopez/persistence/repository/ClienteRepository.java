package ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ClienteEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ClienteRepository extends ListCrudRepository<ClienteEntity, Long> {
    ClienteEntity findByCorreo(String correo);

}
