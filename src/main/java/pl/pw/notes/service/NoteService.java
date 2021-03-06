package pl.pw.notes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.notes.dao.NoteDao;
import pl.pw.notes.models.Note;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {



    @Autowired
    private NoteDao noteDao;

    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }


    public void saveNote(Note note) {
        note.setCreated(LocalDateTime.now());
        noteDao.saveNote(note);
    }

    public Note findById(Integer id) {

       return noteDao.findById(id);
    }

    public List<Note> notes(){

        return noteDao.findAll();
    }

    public void update(Note note){
        note.setModiefied(LocalDateTime.now());
        noteDao.update(note);
    }

    public void delete(Integer id){

        Note found=findById(id);
        noteDao.delete(found);
    }
}
