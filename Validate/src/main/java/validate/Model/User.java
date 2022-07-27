package validate.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validate.Validated.ValidatedPhone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User {
    @Id
    private int id;

    @NotBlank(message = "Name can't blank!!")
    private String name;

    @NotBlank(message = "Address can't blank!!")
    private String address;

    @NotBlank(message = "Phone can't blank!!")
    @ValidatedPhone
    private String phone;
}
