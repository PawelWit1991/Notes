package pl.pw.notes.dao;


import org.springframework.stereotype.Component;
import pl.pw.notes.models.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class NoteDao {

    @PersistenceContext
    private EntityManager entityManager;



    public void saveNote(Note note){
        entityManager.persist(note);
    }
    public Note findById(Integer id) {
        return entityManager.find(Note.class, id);
    }


    public void update(Note note){
        entityManager.merge(note);
    }

    public void delete(Note note){
        entityManager.remove(note);
    }
    public List<Note> findAll(){
        Query query = entityManager.createQuery("SELECT n FROM Note n");
        return (List<Note>) query.getResultList();
    }


}
