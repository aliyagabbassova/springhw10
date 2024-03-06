package ru.gb.springhw6.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.springhw6.model.Note;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import ru.gb.springhw6.services.NoteService;

@SpringBootTest

public class NoteControllerIntegrationTest {
    @Mock
    private NoteService noteService;
    @Autowired
    private NoteController noteController;
    @Test
    public void testCreateNote() {
        Note note = new Note();
        when(noteService.createNote(any())).thenReturn(note);
        ResponseEntity<Note> response = noteController.createNote(note);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(note, response.getBody());
    }
}
