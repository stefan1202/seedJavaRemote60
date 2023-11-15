package ro.sda.seedjavaremote60.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.seedjavaremote60.entities.AuthorEntity;
import ro.sda.seedjavaremote60.exceptions.EntityNotFoundException;
import ro.sda.seedjavaremote60.mappers.AuthorMapper;
import ro.sda.seedjavaremote60.models.Author;
import ro.sda.seedjavaremote60.repositories.AuthorsRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorsRepository authorsRepository;
    private final AuthorMapper authorMapper;
    public Author create(Author author) {
        AuthorEntity entity = authorMapper.toEntity(author);

        entity = authorsRepository.save(entity);
        return authorMapper.toDto(entity);

    }
    public void remove(Author author) throws EntityNotFoundException {
        authorsRepository.findById(author.getId()).orElseThrow(()-> new EntityNotFoundException("Author with id " + author.getId() + " not found"));
        authorsRepository.deleteById(author.getId());
    }

    public List<Author> getAuthors() {
        return authorsRepository.findAll().stream().map(authorMapper::toDto).toList();
    }

    public List<Author> findAuthorsByName(String name) {
        return authorsRepository.findAllByNameStartingWith(name).stream().map(authorMapper::toDto).toList();
    }

    public Author findAuthorByID(Long id) throws EntityNotFoundException {
        AuthorEntity entity = authorsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Author with id " + id + " not found"));

        return authorMapper.toDto(entity);
    }
}
