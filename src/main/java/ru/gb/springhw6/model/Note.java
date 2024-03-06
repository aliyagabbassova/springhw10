package ru.gb.springhw6.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")

public class Note {

//ID (автоинкрементное)(тип - Long)
//- Заголовок (не может быть пустым)(тип - String)
//- Содержимое (не может быть пустым)(тип - String)
//- Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private String content;
    @Column
    private LocalDateTime timeOfCreation = LocalDateTime.now();
}
