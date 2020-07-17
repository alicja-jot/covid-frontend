package pl.alicjajot.covid.frontend.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestActionLogDto {
    private LocalDateTime time;
    private String action;
}
