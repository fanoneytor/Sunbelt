package com.microservicio.sunbelt.servicio;

import com.microservicio.sunbelt.entidad.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {
    public Cliente consultarCliente(String tipo_documento, String numero_documento){
        Cliente cliente = new Cliente();
        cliente.setTipo_documento(tipo_documento);
        cliente.setNumero_documento(numero_documento);
        cliente.setPrimer_nombre("Stefano");
        cliente.setPrimer_apellido("Arias");
        cliente.setSegundo_apellido("Machado");
        cliente.setTelefono("3152658972");
        cliente.setDireccion("Calle 17 #5-39");
        cliente.setCiudad_residencia("Pereira");

        return cliente;
    }
}
