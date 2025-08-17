package ec.sasf.ms_comp_prueba_freya_lopez.web.controller;

import ec.sasf.ms_comp_prueba_freya_lopez.persistence.entity.ClienteEntity;
import ec.sasf.ms_comp_prueba_freya_lopez.persistence.repository.ClienteRepository;
import ec.sasf.ms_comp_prueba_freya_lopez.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteContoller {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteEntity crearCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.crearCliente(cliente);
    }
}
