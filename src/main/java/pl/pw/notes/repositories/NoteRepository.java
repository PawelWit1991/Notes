package pl.pw.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.notes.models.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository <Note, Long> {



}
