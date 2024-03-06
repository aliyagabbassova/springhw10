package ru.gb.springhw6.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gb.springhw6.model.Note;
import ru.gb.springhw6.services.NoteService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteControllerTest {

    @Mock
    private NoteService noteService;

    @InjectMocks
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