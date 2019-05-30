package pl.pw.notes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.pw.notes.models.Note;
import pl.pw.notes.service.NoteService;

public class NoteConverter implements Converter <String, Note> {

    @Autowired
    NoteService noteService;

    @Override
    public Note convert(String s) {
        return noteService.findById(Integer.parseInt(s));
    }
}
