package com.microservicio.sunbelt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDtoRequest {
    private String tipo_documento;
    private String numero_documento;
}
