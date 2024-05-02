package com.microservicio.sunbelt.service.implement;

import com.microservicio.sunbelt.exceptions.responses.BadRequestException;
import com.microservicio.sunbelt.exceptions.responses.InternalServerErrorException;
import com.microservicio.sunbelt.exceptions.responses.NotFoundException;
import com.microservicio.sunbelt.model.Cliente;
import com.microservicio.sunbelt.model.dto.ClienteResponseDto;
import com.microservicio.sunbelt.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClienteServiceImp implements ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    public ClienteResponseDto consultarCliente(String tipoDocumento, String numeroDocumento) {
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

        try {
            if (tipoDocumento == null || tipoDocumento.isEmpty() || numeroDocumento == null || numeroDocumento.isEmpty()) {
                logger.warn("Problemas con Tipo de documento o numero de documento ingresado.");
                throw new BadRequestException("Bad Request");
            }

            if (!Objects.equals(tipoDocumento, "C") && !Objects.equals(tipoDocumento, "P")) {
                throw new BadRequestException("Bad Request");
            }

            if ("C".equals(tipoDocumento) && "10121314".equals(numeroDocumento)) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map(cliente, ClienteResponseDto.class);
            } else {
                logger.warn("tipo de documento no es C o numero de documento diferente a 10121314");
                throw new NotFoundException("Not Found");
            }
        } catch (InternalServerErrorException e) {
            throw new InternalServerErrorException("Internal Server Error");
        }
    }
}
