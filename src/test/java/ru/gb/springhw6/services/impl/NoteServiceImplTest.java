package ru.gb.springhw6.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.springhw6.NoteRepo;
import ru.gb.springhw6.model.Note;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {
    @Mock
    private NoteRepo noteRepo;

    @InjectMocks
    private NoteServiceImpl noteService;
    @Test
    @DisplayName("noteServiceTest")
    public void testCreateNote() {
        Note note = new Note();
        when(noteRepo.save(any())).thenReturn(note);
        Note createdNote = noteService.createNote(note);
        assertNotNull(createdNote);
        verify(noteRepo, times(1)).save(any());
    }
}

