package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.alicjajot.covid.frontend.client.AppClient;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private AppClient appClient;

    @Autowired
    private CaseForm caseForm;
    @Autowired
    private HospitalForm hospitalForm;

    @Autowired
    private CaseGrid caseGrid;

    @Autowired
    private HospitalGrid hospitalGrid;

    @Autowired
    private CountryGrid countryGrid;
    @Autowired
    private LogGrid logGrid;

    @PostConstruct
    void init() {
        showButtons();
        caseGrid.initialize();
        show(caseGrid);
    }

    private void showButtons() {
        Button backToMainView = new Button("Cancel", e -> {
            hideAll();
            caseGrid.initialize();
            show(caseGrid);
        });

        Button addHospital = new Button("Add hospital", e -> {
            hideAll();
            hospitalForm.initialize(backToMainView);
            show(hospitalForm);
        });
        addHospital.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button addCase = new Button("Add case", e -> {
            hideAll();
            caseForm.initialize(backToMainView);
            show(caseForm);
        });

        Button updateData = new Button("Update Countries data", e -> {
            hideAll();
            appClient.update();
            countryGrid.initialize();
            show(countryGrid);
        });

        Button showHospitals = new Button("Hospitals", e -> {
            hideAll();
            hospitalGrid.initialize();
            show(hospitalGrid);
        });

        Button showCases = new Button("Cases", e -> {
            hideAll();
            caseGrid.initialize();
            show(caseGrid);
        });

        Button showCountries = new Button("Countries", e -> {
            hideAll();
            countryGrid.initialize();
            show(countryGrid);
        });

        Button showLogs = new Button("Logs", e -> {
            hideAll();
            logGrid.initialize();
            show(logGrid);
        });

        addCase.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Text covid19_info_app = new Text("Covid19 Info App");
        add(covid19_info_app);
        add(new HorizontalLayout(addCase, addHospital, updateData));
        add(new HorizontalLayout(showCases, showHospitals, showCountries));
    }

    private void show(Component component) {
        hide(component);
        add(component);
    }

    private void hide(Component caseForm) {
        if (getChildren().collect(Collectors.toList()).contains(caseForm)) {
            remove(caseForm);
        }
    }

    private void hideAll() {
        getChildren().forEach(child -> remove(child));
        showButtons();
    }

}
