package ro.sda.seedjavaremote60.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "books")
@Table(name = "books")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    private String title;
    private int publishedYear;
    @ManyToOne
    private AuthorEntity authorEntity;

    private  int noOfPages;
    @Id
    @GeneratedValue
    private Long id;


}
