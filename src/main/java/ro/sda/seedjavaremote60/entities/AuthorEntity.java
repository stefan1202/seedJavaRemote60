package ro.sda.seedjavaremote60.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name ="authors")
@Getter
@Setter
@Table(name = "authors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue
    private Long authorId;
    private String name;
    private String lastName;
    private int varsta;

}
