package com.microservicio.sunbelt.service;

import com.microservicio.sunbelt.model.dto.ClienteResponseDto;

public interface ClienteService {
    ClienteResponseDto  consultarCliente(String tipoDocumento, String numeroDocumento);
}
