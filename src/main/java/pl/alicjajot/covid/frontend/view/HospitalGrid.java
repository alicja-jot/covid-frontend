package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.alicjajot.covid.frontend.client.AppClient;
import pl.alicjajot.covid.frontend.dto.CaseDto;
import pl.alicjajot.covid.frontend.dto.HospitalDto;

@Component
public class HospitalGrid extends FormLayout {

    @Autowired
    private AppClient appClient;

    Grid gridCases = new Grid<>(HospitalDto.class);

    public void initialize() {
        gridCases.setColumns("name", "supportHospitalId");
        gridCases.setItems(appClient.getHospitals());
        add(gridCases);
    }

}
