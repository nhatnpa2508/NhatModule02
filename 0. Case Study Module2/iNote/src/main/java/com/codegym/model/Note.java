/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 9:36 PM                     *
 *************************************
 */

package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString(){
        return String.format("Note[id=%d,title='%s',content='%s']",id, title,content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
