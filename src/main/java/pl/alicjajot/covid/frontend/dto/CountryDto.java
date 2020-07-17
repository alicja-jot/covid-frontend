package pl.alicjajot.covid.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryDto {
    private String name;
    private StatisticsDto statistics;
}
