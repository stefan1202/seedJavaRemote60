package ro.sda.seedjavaremote60.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    private String Title;
    private int publishedYear;
    @ManyToOne
    private AuthorEntity authorEntity;

    private  int noOfPages;
    @Id
    @GeneratedValue
    private Long id;


}
