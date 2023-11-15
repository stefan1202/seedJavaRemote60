package ro.sda.seedjavaremote60.mappers;

import org.springframework.stereotype.Controller;
import ro.sda.seedjavaremote60.entities.AuthorEntity;
import ro.sda.seedjavaremote60.models.Author;

@Controller
public class AuthorMapper implements Mapper<Author, AuthorEntity>{

    @Override
    public Author toDto(AuthorEntity entity) {

        return Author.builder()
                .age(entity.getVarsta())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .build();
    }

    @Override
    public AuthorEntity toEntity(Author dto) {
        return AuthorEntity.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .varsta(dto.getAge())
                .build();
    }
}
