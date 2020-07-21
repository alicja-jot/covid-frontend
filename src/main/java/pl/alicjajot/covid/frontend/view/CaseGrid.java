package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.alicjajot.covid.frontend.client.AppClient;
import pl.alicjajot.covid.frontend.dto.CaseDto;

@Component
public class CaseGrid extends FormLayout {

    @Autowired
    private AppClient appClient;

    Grid gridCases = new Grid<>(CaseDto.class);

    public void initialize() {
        gridCases.setColumns("name", "surname", "status");
        gridCases.setItems(appClient.getCases());
        add(gridCases);
    }

}
