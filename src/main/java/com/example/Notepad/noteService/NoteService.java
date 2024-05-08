package com.example.Notepad.noteService;

import com.example.Notepad.model.Note;
import com.example.Notepad.noteRepository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    /**
     * Возвращает список всех заметок.
     *
     * @return список всех заметок
     */
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    /**
     * Возвращает заметку по её идентификатору.
     *
     * @param id идентификатор заметки
     * @return заметка, если найдена, иначе null
     */
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    /**
     * Сохраняет новую заметку или обновляет существующую.
     *
     * @param note заметка для сохранения
     * @return сохраненная заметка
     */
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Удаляет заметку по её идентификатору.
     *
     * @param id идентификатор заметки для удаления
     */
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}