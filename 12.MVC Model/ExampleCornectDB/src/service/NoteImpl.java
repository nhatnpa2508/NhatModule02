/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/21/2019                     *
 * Time: 3:11 PM                     *
 *************************************
 */

package service;

import model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NoteImpl implements INote {

    Connection connection = DataAccessLayout.getConnection();
    Statement statement;
    PreparedStatement preparedStatement;
    String sql;
    ResultSet resultSet;

    @Override
    public List<Note> getAllNote() {
        List<Note> noteList = new ArrayList<>();
/*        int[] numberList = new int[100];
        for (int i = 0 ; i < 100; i++){
            numberList[i] = i;
        }*/
        sql = "select * from notes";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String type = resultSet.getString("typeNote");
                int type_id = resultSet.getInt("type_id");
                int user_id = resultSet.getInt("user_id");
                Note note = new Note(id, title, content, type, type_id, user_id);
                noteList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteList;
    }

    @Override
    public Note getNoteById(int id) {

        sql = "select * from notes where id = '"+ id+"'";
        Note note = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String type = resultSet.getString("typeNote");
                int type_id = resultSet.getInt("type_id");
                int user_id = resultSet.getInt("user_id");
                note = new Note(id, title, content, type, type_id, user_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    @Override
    public boolean createNote(Note note) {
        try {
            statement = (Statement) connection.createStatement();
            sql = "insert into notes(title,content,typeNote,type_id,user_id)" +
                    " values('" + note.getTitle() + "','" + note.getContent() + "','" + note.getType() + "','" + note.getType_id() + "','" + note.getUser_id() + "')";
            statement.executeUpdate(sql);
            statement.close();
        /*  cach 2:
            sql = "insert into notes(title,content,typeNote,type_id,user_id) value (?,?,?,?,?)";
            cach 3:
            sql = "insert into notes(title,content,typeNote,type_id,user_id)" +
                    " values('"+note.getTitle()+"','"+note.getContent()+"','"+note.getType()+"','"+note.getType_id()+"','"+note.getUser_id()+"')";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,note.getTitle());
            preparedStatement.setString(2,note.getContent());
            preparedStatement.setString(3,note.getType());
            preparedStatement.setInt(4,note.getType_id());
            preparedStatement.setInt(5,note.getUser_id());
            preparedStatement.execute();
            preparedStatement.close();*/
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteNote(Note note) {
        try {
            statement = (Statement) connection.createStatement();
            sql = "delete from notes where id = '" + note.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateNote(Note note) {
        try {
            statement = (Statement) connection.createStatement();
            sql = "update notes set title = '" + note.getTitle() + "', content = '" + note.getContent() + "', typeNote = '" + note.getType() + "' where id = '" + note.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
/*            sql = "update `notes` set `title` = ?, `content` = ?, `typeNote` = ? where `id` = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,note.getTitle());
            preparedStatement.setString(2,note.getContent());
            preparedStatement.setString(3,note.getType());
            preparedStatement.setInt(4,note.getId());
            preparedStatement.execute();
            preparedStatement.close();*/
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
