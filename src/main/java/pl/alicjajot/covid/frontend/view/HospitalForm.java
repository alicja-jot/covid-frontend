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
import pl.alicjajot.covid.frontend.dto.HospitalDto;

@Component
public class HospitalForm extends FormLayout {

    @Autowired
    private AppClient appClient;

    private Text titleText = new Text("Add Hospital");
    private Text infoText = new Text("Support hospital is used to transfer Covid Cases when hospital is deleted");
    private TextField nameTextField = new TextField("Name");
    private ComboBox<HospitalDto> supportHospital = new ComboBox<>("Supporting Hospital");
    private Button save;

    public void initialize(Button backToMainView) {
        supportHospital.setItems(appClient.getHospitals());

        if (save == null) {
            save = new Button("Save", e -> {
                String name = this.nameTextField.getValue();
                if (supportHospital.getValue() == null) {

                    appClient.postHospital(new HospitalDto(null, name, null));
                } else {
                    appClient.postHospital(new HospitalDto(null, name, supportHospital.getValue().getId()));
                }

                nameTextField.clear();
                supportHospital.clear();
                supportHospital.setItems(appClient.getHospitals());

                backToMainView.click();
            });
        }

        HorizontalLayout nameSurname = new HorizontalLayout(nameTextField, supportHospital);
        HorizontalLayout buttons = new HorizontalLayout(save, backToMainView);
        VerticalLayout mainLayout = new VerticalLayout(titleText, nameSurname, infoText, buttons);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(mainLayout);
    }

}
