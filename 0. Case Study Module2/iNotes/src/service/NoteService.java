/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/20/2019                     *
 * Time: 8:32 AM                     *
 *************************************
 */

package service;

import model.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();

    void save(Note note);

    Note findById(int id);

    void update(int id, Note note);

    void remove(int id);
}
