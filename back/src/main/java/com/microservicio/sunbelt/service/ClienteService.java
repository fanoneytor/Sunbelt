package com.microservicio.sunbelt.service;

import com.microservicio.sunbelt.model.Cliente;
import com.microservicio.sunbelt.model.dto.ClienteDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    public ClienteDtoResponse consultarCliente(String tipo_documento, String numero_documento){
        logger.info("Se realiza consulta del cliente");
        Cliente cliente = new Cliente(
                "Carlos",
                "Andres",
                "Agudelo",
                "Morales",
                "3152658972",
                "Calle 17 #5-39",
                "Pereira",
                "C",
                "10121314");
        if(cliente.getTipo_documento().equals(tipo_documento) && cliente.getNumero_documento().equals(numero_documento)){
            ClienteDtoResponse respuesta = new ClienteDtoResponse();
            respuesta.setPrimer_nombre(cliente.getPrimer_nombre());
            respuesta.setSegundo_nombre(cliente.getSegundo_nombre());
            respuesta.setPrimer_apellido(cliente.getPrimer_apellido());
            respuesta.setSegundo_apellido(cliente.getSegundo_apellido());
            respuesta.setTelefono(cliente.getTelefono());
            respuesta.setDireccion(cliente.getDireccion());
            respuesta.setCiudad_residencia(cliente.getCiudad_residencia());

            return respuesta;
        }else{
            return null;
        }
    }
}
