package validate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import validate.Model.User;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.Valid;
import java.util.*;

@Controller
public class LoginController {

    private static final Comparator<FieldError> FIELD_ORDER_COMPARATOR = new Comparator<FieldError>() {

        // Your fields, ordered in the way they appear in the form
        private static final List<String> FIELDS_WITH_ORDER = ImmutableList.of("field1", "field2");

        @Override
        public int compare(FieldError fe1, FieldError fe2) {

            String field1 = fe1.getField();
            String field2 = fe2.getField();

            int field1Index = FIELDS_WITH_ORDER.indexOf(field1);
            int field2Index = FIELDS_WITH_ORDER.indexOf(field2);

            return Integer.compare(field1Index, field2Index);
        }
    };



    @GetMapping("")
    public String formLoginGet(Model model) {
        model.addAttribute("user", new User());
        return "formLogin";
    }

    @GetMapping("form")
    public String validateForm(Model model, @Valid User user, BindingResult rs) {
        if(rs.hasErrors()) {
            List<FieldError> list = rs.getFieldErrors();
            List<FieldError> fieldErrors = new ArrayList<>();
            for(FieldError f : list) {
                fieldErrors.add(f);
            }
            Collections.sort(fieldErrors, FIELD_ORDER_COMPARATOR);

            model.addAttribute("list", fieldErrors);
            return "formLogin";
        }
        model.addAttribute("user", user);
        return "showUser";
    }
}
