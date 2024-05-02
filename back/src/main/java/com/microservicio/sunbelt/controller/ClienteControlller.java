package com.microservicio.sunbelt.controller;

import com.microservicio.sunbelt.model.dto.ClienteRequestDto;
import com.microservicio.sunbelt.model.dto.ClienteResponseDto;
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

    /**
     * Endpoint para consultar un cliente por tipo de documento y número de documento.
     *
     * @param clienteRequestDTO los datos aislados para consultar el cliente.
     * @return La información del cliente consultado.
     */
    @PostMapping("/consultarCliente")
    public ResponseEntity<ClienteResponseDto> consultarCliente(@RequestBody ClienteRequestDto clienteRequestDTO) {
        logger.info("Se realiza la peticion, se obtienen los datos: {}", clienteRequestDTO);
        ClienteResponseDto clienteResponseDTO = clienteServicio.consultarCliente(clienteRequestDTO.getTipoDocumento(), clienteRequestDTO.getNumeroDocumento());
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponseDTO);
    }
}
