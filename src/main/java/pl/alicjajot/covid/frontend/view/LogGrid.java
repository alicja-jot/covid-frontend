package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.alicjajot.covid.frontend.client.AppClient;
import pl.alicjajot.covid.frontend.dto.HospitalDto;

@Component
public class LogGrid extends FormLayout {

    @Autowired
    private AppClient appClient;

    Grid restCallGrid = new Grid<>(HospitalDto.class);

    Grid apiCallGrid = new Grid<>(HospitalDto.class);

    public void initialize() {
        add(new Text("System logs"));
        restCallGrid.setColumns("time", "action");
        restCallGrid.setItems(appClient.getRestCalls());
        apiCallGrid.setColumns("time", "action");
        apiCallGrid.setItems(appClient.getApiCalls());
        add(new HorizontalLayout(restCallGrid, apiCallGrid));
    }

}
