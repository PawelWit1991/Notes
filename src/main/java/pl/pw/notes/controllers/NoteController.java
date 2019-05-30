package pl.pw.notes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pw.notes.dao.NoteDao;
import pl.pw.notes.models.Note;
import pl.pw.notes.service.NoteService;

import javax.validation.Valid;
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





    @GetMapping("/saveNote")
    public String  addNote(Note note) {


        return "addNote";
    }

    @PostMapping("/saveNote")
//    @ResponseBody
    public String seveNote(Note note) {


        noteService.saveNote(note);

        return "redirect:/";
    }

    //Lista notatek
    @GetMapping("/notes")
    @ResponseBody
    public List<Note> notes(){



        return noteService.notes();
    }

    @GetMapping("/readNote")
    @ResponseBody
    public Note readNote(Note note) {

//        noteService.findById(1L);

    return noteService.findById(1);

    }

//    @GetMapping("/editNote")
//
//    public String updateNote(Note note) {
//
//        noteService.update(note);
//
//        return "addNote";
//    }

    @GetMapping("/edit/{id}")

    public String editNote(@PathVariable Integer id, Model model) {


        Note note=noteService.findById(id);
        model.addAttribute("note",note);

        noteService.update(note);

        return "editNote";
    }

    @PostMapping("/edit/{id}")       // w ten sposob odbieram edytowana clienta z widoku edit.jsp
    public String editNote2(@PathVariable Long id, Note note) {



        noteService.update(note);

        return "redirect:/";
    }


    @RequestMapping("/allNotes")
    public String allNotes(Model model) {
        model.addAttribute("notes", noteService.notes());
        return "allNotes";
    }
}
