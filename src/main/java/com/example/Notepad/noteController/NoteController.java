package com.example.Notepad.noteController;

import com.example.Notepad.model.Note;
import com.example.Notepad.noteService.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для управления заметками.
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    // Получение всех заметок
    @GetMapping
    public List<Note> findAll() {
        return noteService.findAll();
    }

    // Получение заметки по идентификатору
    @GetMapping("/{id}")
    public ResponseEntity<Note> findByid(@PathVariable Long id) {
        Optional<Note> note = noteService.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Сохранение новой заметки
    @PostMapping
    public Note save(@RequestBody Note note) {
        return noteService.save(note);
    }

    // Редактирование существующей заметки
    @PutMapping("/{id}")
    public Note update(@RequestBody Note note, @PathVariable Long id) {
        note.setId(id);
        return noteService.save(note);
    }

    // Удаление заметки по идентификатору
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}