package ro.sda.seedjavaremote60.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sda.seedjavaremote60.entities.AuthorEntity;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<AuthorEntity, Long> {

    List<AuthorEntity> findAllByNameStartingWith(String name);

    List<AuthorEntity> findTop3ByNameStartingWith(String name);

    @Query(value="Select a from authors a where a.varsta>:age", nativeQuery = false)
    List<AuthorEntity> giveAllAuthorsByAge(@Param("age") int paramAge );
}
