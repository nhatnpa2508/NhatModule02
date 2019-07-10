package controller;

import model.Note;
import service.INote;
import service.NoteImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = "/notes")
public class NoteServlet extends HttpServlet {
    private INote note = new NoteImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNote(request, response);
                break;
            case "edit":
                updateNote(request, response);
                break;
            case "delete":
                deleteNote(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = new Note(id);
        RequestDispatcher dispatcher;
        if(note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.note.deleteNote(note);
            request.setAttribute("message", "Note was deleted");
            dispatcher = request.getRequestDispatcher("note/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateNote(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = new Note(id,title,content,type);
        RequestDispatcher dispatcher;
        if(note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.note.updateNote(note);
            request.setAttribute("message", "Note information was updated");
            dispatcher = request.getRequestDispatcher("note/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNote(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        int type_id = 1;
        int user_id = 1;
        int id = 0;

        Note note = new Note(id,title, content, type, type_id, user_id);
        this.note.createNote(note);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");
        request.setAttribute("message", "New Note was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            default:
                listNote(request, response);
                break;
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note iNote = note.getNoteById(id);
        request.setAttribute("note",iNote);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note iNote = note.getNoteById(id);
        request.setAttribute("note",iNote);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/delete.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note iNote = note.getNoteById(id);
        request.setAttribute("note",iNote);

        RequestDispatcher dispatcher = request.getRequestDispatcher("note/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listNote(HttpServletRequest request, HttpServletResponse response) {
        List<Note> notes = this.note.getAllNote();
        request.setAttribute("notes",notes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/list.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}