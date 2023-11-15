package ro.sda.seedjavaremote60.mappers;

public interface Mapper<T,E>{
    T toDto(E entity);
    E toEntity(T dto);
}
