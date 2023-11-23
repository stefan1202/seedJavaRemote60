package ro.sda.seedjavaremote60.mappers;

import org.springframework.stereotype.Component;
import ro.sda.seedjavaremote60.entities.BookEntity;
import ro.sda.seedjavaremote60.models.Book;
@Component
public class BookMapper implements Mapper<Book, BookEntity>{

    private final AuthorMapper authorMapper;

    public BookMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Override
    public Book toDto(BookEntity entity) {
        if (entity==null){
            return null;
        }
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(authorMapper.toDto(entity.getAuthorEntity()))
                .noOfPages(entity.getNoOfPages())
                .publishedYear(entity.getPublishedYear())
                .picture(entity.getPicture())
                .build();
    }

    @Override
    public BookEntity toEntity(Book dto) {
        if (dto==null){
            return null;
        }
        return BookEntity.builder()
                .authorEntity(authorMapper.toEntity(dto.getAuthor()))
                .title(dto.getTitle())
                .id(dto.getId())
                .noOfPages(dto.getNoOfPages())
                .publishedYear(dto.getPublishedYear())
                .picture(dto.getPicture())
                .build();
    }
}
