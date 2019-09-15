package com.previred.solution.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.solution.dto.PeriodResponseDto;
import com.previred.solution.dto.PeriodResponseGeneradorDto;
import com.previred.solution.service.PeriodService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    @Value("${custom.backendService}")
    private String BACKEND_SERVICE;

    @Override
    public PeriodResponseDto getPeriods() {
        PeriodResponseDto period = new PeriodResponseDto();
        PeriodResponseGeneradorDto periodGenerator = getDataService();
        periodGenerator = getDataService();
        period = getDates(periodGenerator);
        return period;
    }

    private PeriodResponseDto getDates(PeriodResponseGeneradorDto periodGenerator) {
        Set<LocalDate> missingDates = new HashSet();
        String init = periodGenerator.getFechaCreacion();
        String end = periodGenerator.getFechaFin();
        long diff = ChronoUnit.MONTHS.between(
                LocalDate.parse(init).withDayOfMonth(1),
                LocalDate.parse(end).withDayOfMonth(1));
        for (long i = 0; i <= diff; i++) {
            LocalDate date = LocalDate.parse(init).plusMonths(i);
            missingDates.add(date);
        }
        missingDates.stream()
                .sorted()
                .collect(Collectors.toList());
        for (String datePointer : periodGenerator.getFechas()) {
            missingDates.remove(LocalDate.parse(datePointer));
        }
        PeriodResponseDto period = new PeriodResponseDto();
        BeanUtils.copyProperties(periodGenerator, period);
        period.setFechasFaltantes(missingDates.stream()
                .sorted()
                .collect(Collectors.toList()));
        return period;
    }

    private PeriodResponseGeneradorDto getDataService() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> responseEntity = rest.exchange(BACKEND_SERVICE, HttpMethod.GET, null, String.class);
        ObjectMapper mapper = new ObjectMapper();
        PeriodResponseGeneradorDto obj = new PeriodResponseGeneradorDto();
        try {
            obj = mapper.readValue(responseEntity.getBody(), PeriodResponseGeneradorDto.class);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return obj;
    }

}
