package pl.pw.notes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pw.notes.dao.NoteDao;
import pl.pw.notes.models.Note;
import pl.pw.notes.service.NoteService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    //Restowe
//    @GetMapping("/notes")
//    @ResponseBody
//    public List<Note> notes() {
//
//        List<Note> notes = new ArrayList<>();
//        notes.add(new Note("note", "przykladowa notatka"));
//        notes.add(new Note("note2", "przykladowa notatka2"));
//
//        return notes;
//    }

    @GetMapping("/notes")
    @ResponseBody
    public List<Note> notes(){



        return noteService.notes();
    }



    @GetMapping("/saveNote")
    public String  addNote(Note note) {


        return "addNote";
    }

    @PostMapping("/saveNote")
    @ResponseBody
    public String seveNote(Note note) {


        noteService.saveNote(note);

        return "redirect:index";
    }

//    @PostMapping("/note")
//
//    public String updateNote(Note note) {
//
//
//        return "addNote";
//    }
}
