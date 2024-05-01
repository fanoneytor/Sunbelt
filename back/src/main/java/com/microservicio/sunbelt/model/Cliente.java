package com.microservicio.sunbelt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String direccion;
    private String ciudad_residencia;
    private String tipo_documento;
    private String numero_documento;
}
