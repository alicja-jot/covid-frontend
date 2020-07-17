package pl.alicjajot.covid.frontend.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.alicjajot.covid.frontend.client.AppClient;
import pl.alicjajot.covid.frontend.dto.CaseDto;
import pl.alicjajot.covid.frontend.dto.CaseStatus;
import pl.alicjajot.covid.frontend.dto.HospitalDto;

@Component
public class CaseForm extends FormLayout {

    @Autowired
    private AppClient appClient;

    private Text titleText = new Text("Add Covid case");
    private TextField nameTextField = new TextField("Name");
    private TextField surnameTextField = new TextField("Surname");
    private ComboBox<CaseStatus> statusComboBox = new ComboBox<CaseStatus>("Case status");
    private ComboBox<HospitalDto> hospitalComboBox = new ComboBox<>("Hospital");
    private Button save;

    public void initialize(Button backToMainView) {
        statusComboBox.setItems(CaseStatus.values());
        hospitalComboBox.setItems(appClient.getHospitals());

        if (save == null) {
            save = new Button("Save", e -> {
                String name = this.nameTextField.getValue();
                String value1 = surnameTextField.getValue();
                CaseStatus value = statusComboBox.getValue();
                if (hospitalComboBox.getValue() == null) {

                    appClient.postCase(new CaseDto(name, value1, value, null));
                } else {
                    appClient.postCase(new CaseDto(name, value1, value, hospitalComboBox.getValue().getId()));
                }

                nameTextField.clear();
                surnameTextField.clear();
                statusComboBox.clear();
                hospitalComboBox.clear();
                statusComboBox.setItems(CaseStatus.values());
                hospitalComboBox.setItems(appClient.getHospitals());

                backToMainView.click();
            });
        }

        HorizontalLayout nameSurname = new HorizontalLayout(nameTextField, surnameTextField);
        HorizontalLayout statusHospital = new HorizontalLayout(statusComboBox, hospitalComboBox);
        HorizontalLayout buttons = new HorizontalLayout(save, backToMainView);
        VerticalLayout mainLayout = new VerticalLayout(titleText, nameSurname, statusHospital, buttons);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(mainLayout);
    }

}
