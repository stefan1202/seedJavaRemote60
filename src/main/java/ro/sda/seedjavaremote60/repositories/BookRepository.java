package ro.sda.seedjavaremote60.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.seedjavaremote60.entities.AuthorEntity;
import ro.sda.seedjavaremote60.entities.BookEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findAllByTitleStartingWith(String title);
}
