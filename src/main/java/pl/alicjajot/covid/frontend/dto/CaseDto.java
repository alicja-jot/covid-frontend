package pl.alicjajot.covid.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDto {
    private String name;
    private String surname;
    private CaseStatus status;
    private Long hospitalId;

    @Override
    public String toString() {
        if (name == null) {
            return "Empty name";
        }
        return name;
    }
}
