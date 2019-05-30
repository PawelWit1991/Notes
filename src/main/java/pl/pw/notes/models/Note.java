package pl.pw.notes.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    String title;
    String content;
    LocalDateTime created;
    LocalDateTime modiefied;

    public Note(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModiefied() {
        return modiefied;
    }

    public void setModiefied(LocalDateTime modiefied) {
        this.modiefied = modiefied;
    }
}
