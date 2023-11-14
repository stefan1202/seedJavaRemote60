package ro.sda.seedjavaremote60.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class Author {
    @NotNull
    @Length(min = 3,max = 50, message = "Name must contain between 3 and 50 characters")
    private String name;
    @NotNull
    @Length(min = 3,max = 50, message = "LastName must contain between 3 and 50 characters")
    private String lastName;
    @Min(value =18,message = "Age must be higher than 18")
    private int age;
}
