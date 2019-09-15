package com.previred.solution.controller;

import com.previred.solution.dto.PeriodResponseDto;
import com.previred.solution.service.PeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/periods")
@Api(tags = {"Periodos"}, value = "Servicios de periodos")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @ApiOperation(value = "Retorna una lista con todas las fechas del periodo")
    @GetMapping()
    public ResponseEntity<PeriodResponseDto> getPeriods() {
        PeriodResponseDto period = new PeriodResponseDto();
        period = periodService.getPeriods();
        return new ResponseEntity<>(period, HttpStatus.OK);
    }
}
