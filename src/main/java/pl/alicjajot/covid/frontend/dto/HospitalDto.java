package pl.alicjajot.covid.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospitalDto {
    private Long id;
    private String name;
    private Long supportHospitalId;

    @Override
    public String toString() {
        if (name == null) {
            return "Empty name";
        }
        return name;
    }
}
