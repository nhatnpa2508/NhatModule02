/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/21/2019                     *
 * Time: 3:07 PM                     *
 *************************************
 */

package service;

import model.Note;

import java.util.List;

public interface INote {
    public boolean createNote(Note note);

    public Note getNoteById(int id);

    public List<Note> getAllNote();

    public boolean updateNote(Note note);

    public boolean deleteNote(Note note);
}
