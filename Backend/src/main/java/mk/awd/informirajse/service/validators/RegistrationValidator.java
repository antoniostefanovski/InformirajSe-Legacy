package mk.awd.informirajse.service.validators;

import mk.awd.informirajse.model.DTO.RegisterDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

    public static boolean isValidForSubmit(RegisterDTO userInfo){

        if(userInfo.getUsername() == null || userInfo.getUsername().isEmpty()) {
            return false;
        }

        if(userInfo.getPassword().isEmpty() ||
            userInfo.getRepeatedPassword().isEmpty() ||
            !userInfo.getPassword().equals(userInfo.getRepeatedPassword())) {
            return false;
        }

        String emailPattern = "^[a-z0-9]+(?:\\.[a-z0-9]+)*@[^\\s@]+\\.[^\\s@]+$";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userInfo.getEmail());

        if(userInfo.getEmail().isEmpty() || !matcher.matches()) {
            return false;
        }

        if(userInfo.getFullname().isEmpty()) {
            return false;
        }

        if(userInfo.getGender().isEmpty()) {
            return false;
        }

        if(userInfo.getDateOfBirth() == null) {
            return false;
        }

        return true;
    }
}
