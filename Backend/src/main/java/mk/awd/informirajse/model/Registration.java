package mk.awd.informirajse.model;

import lombok.Data;
import mk.awd.informirajse.model.enums.RegisterError;

import java.util.List;

@Data
public class Registration {
    Integer errorType = RegisterError.None;

    Boolean ok;

    public Registration() {}
}
