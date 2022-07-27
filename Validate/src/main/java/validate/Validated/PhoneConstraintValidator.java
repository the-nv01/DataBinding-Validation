package validate.Validated;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<ValidatedPhone, String> {
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        String reg="^0\\d{9}$";
        if(s.matches(reg)) return true;
        return false;
    }
}
