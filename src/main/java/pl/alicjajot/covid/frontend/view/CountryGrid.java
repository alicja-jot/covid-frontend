package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.alicjajot.covid.frontend.client.AppClient;
import pl.alicjajot.covid.frontend.dto.CountryDto;
import pl.alicjajot.covid.frontend.dto.HospitalDto;

@Component
public class CountryGrid extends FormLayout {

    @Autowired
    private AppClient appClient;

    Grid gridCases = new Grid<CountryDto>(CountryDto.class);

    public void initialize() {
        gridCases.setColumns("name",
                "statistics.totalConfirmed",
                "statistics.newConfirmed",
                "statistics.newDeaths",
                "statistics.totalDeaths",
                "statistics.newRecovered",
                "statistics.totalRecovered",
                "statistics.date");
        gridCases.setItems(appClient.getCountries());
        add(gridCases);
    }

}
