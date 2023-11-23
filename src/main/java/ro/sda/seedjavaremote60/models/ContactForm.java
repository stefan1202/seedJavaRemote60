package ro.sda.seedjavaremote60.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactForm {

    private String name;
    @Email
    private String email;
    private String subject;
    private String notes;

}
