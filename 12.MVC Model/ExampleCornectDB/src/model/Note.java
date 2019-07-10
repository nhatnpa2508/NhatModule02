/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/21/2019                     *
 * Time: 2:17 PM                     *
 *************************************
 */

package model;

public class Note{
    private int id;
    private String title;
    private String content;
    private String type;
    private int type_id;
    private int user_id;

    public Note() { }

    public Note(int id) {
        this.id = id;
    }
    public Note(int id, String title, String content, String type){
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
    }


    public Note(int id, String title, String content, String type, int type_id, int user_id){
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.type_id = type_id;
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
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

    public int getId() {
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
