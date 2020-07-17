package pl.alicjajot.covid.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StatisticsDto {

    private Long totalConfirmed;
    private Long newConfirmed;
    private Long newDeaths;
    private Long totalDeaths;
    private Long newRecovered;
    private Long totalRecovered;
    private LocalDateTime date;

}
