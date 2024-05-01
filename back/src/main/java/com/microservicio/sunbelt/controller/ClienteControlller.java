package com.microservicio.sunbelt.controller;

import com.microservicio.sunbelt.model.dto.ClienteDtoRequest;
import com.microservicio.sunbelt.model.dto.ClienteDtoResponse;
import com.microservicio.sunbelt.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlller {

    @Autowired
    private ClienteService clienteServicio;

    private static final Logger logger = LoggerFactory.getLogger(ClienteControlller.class);


    @PostMapping("/consultarCliente")
    public ResponseEntity<?> consultarCliente(@RequestBody ClienteDtoRequest peticion){
        logger.info("Se realiza la peticion, se obtienen los datos: {}", peticion);
        try{
            if(peticion.getTipo_documento() == null || peticion.getTipo_documento().isEmpty() || peticion.getNumero_documento() == null || peticion.getNumero_documento().isEmpty()){
                logger.warn("Problemas con Tipo de documento o numero de documento ingresado.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los campos tipo de documento y número de documento son obligatorios.");
            }

            if (!peticion.getTipo_documento().equals("C") && !peticion.getTipo_documento().equals("P")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El tipo de documento debe ser la cédula de ciudadanía o el pasaporte.");
            }

            ClienteDtoResponse clienteConsultado = null;
            if("C".equals(peticion.getTipo_documento()) && "10121314".equals(peticion.getNumero_documento())){
                clienteConsultado = clienteServicio.consultarCliente(peticion.getTipo_documento(), peticion.getNumero_documento());
            }else{
                logger.warn("tipo de documento no es C o numero de documento diferente a 10121314");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
            }

            if (clienteConsultado != null) {
                return ResponseEntity.status(HttpStatus.OK).body(clienteConsultado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
            }

        } catch(Exception e){
            logger.error("Error interno del servidor", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }
}
