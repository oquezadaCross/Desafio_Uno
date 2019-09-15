package com.previred.solution.dto;

import java.util.List;
import lombok.Data;

@Data
public class PeriodResponseGeneradorDto {

    private Long id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;

}
