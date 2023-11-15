package ro.sda.seedjavaremote60.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.seedjavaremote60.entities.AuthorEntity;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<AuthorEntity, Long> {

    List<AuthorEntity> findAllByNames(String name);
}
