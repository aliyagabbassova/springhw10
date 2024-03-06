package ru.gb.springhw6.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.gb.springhw6.model.Note;
import ru.gb.springhw6.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor

public class NoteController {
    private final NoteService noteService;

        @PostMapping   ("/create")                                //Создание заметки
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @PostMapping   ("/notes")                                //Добавление заметки
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.OK);
    }

    @GetMapping                   //Просмотр всех заметок
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    @PutMapping("/{id}")                 //Редактирование заметки
    public ResponseEntity<Note> updateNoteById(@PathVariable("id") Long id,
                                               @RequestBody Note note) {
        Note updatedNote;
        try {
            updatedNote = noteService.updateNote(id, note);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")                      //Удаление заметки
    public ResponseEntity <Void> deleteNote(@PathVariable ("id") Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
