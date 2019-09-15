package com.previred.solution.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class PeriodResponseDto {

    private Long id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;
    private List<LocalDate> fechasFaltantes;

}
