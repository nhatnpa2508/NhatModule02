/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/20/2019                     *
 * Time: 8:32 AM                     *
 *************************************
 */

package model;

import service.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Note{
    private long id;
    private String title;
    private String content;
    private String type;

    public Note() { }

    public Note(String title) {
        this.title = title;
    }

    public Note(long id, String title, String content, String type){
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }

    public boolean save() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
