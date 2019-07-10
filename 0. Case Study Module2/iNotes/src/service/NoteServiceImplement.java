/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/20/2019                     *
 * Time: 8:33 AM                     *
 *************************************
 */

package service;

import model.Note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteServiceImplement extends DatabaseConnection implements NoteService {

    private static Map<Integer, Note> notes;

    @Override
    public void remove(int id) {
        notes.remove(id);
    }

    @Override
    public Note findById(int id) {
        return notes.get(id);
    }

    @Override
    public List<Note> findAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public void save(Note note) {
        notes.put(note.getId(),note);
    }

    @Override
    public void update(int id, Note note) {
        notes.put(id,note);
    }
    Statement statement;
    Connection connection;

    public List<Note> getListNote(){
        ArrayList<Note> noteList = new ArrayList<>();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();

        String sql = "select id, title, content,typeNote from notes";

        statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString(3);
                String typeNote = resultSet.getString(4);
                Note note = new Note(id,title,content,typeNote);

                noteList.add(note);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return noteList;
    }

}
