package ru.gb.springhw6.repositories;
import ru.gb.springhw6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    public Optional<Note> findById(Integer id);

}
