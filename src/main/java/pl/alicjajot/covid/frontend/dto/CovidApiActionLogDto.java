package pl.alicjajot.covid.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidApiActionLogDto {
    private LocalDateTime time;
    private String action;
}
