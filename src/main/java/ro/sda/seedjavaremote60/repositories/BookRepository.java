package ro.sda.seedjavaremote60.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.seedjavaremote60.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

}
