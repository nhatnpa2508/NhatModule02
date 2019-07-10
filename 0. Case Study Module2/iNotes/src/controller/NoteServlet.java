package controller;

import model.Note;
import service.NoteServiceImplement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = "/iNotes")
public class NoteServlet extends HttpServlet {
    private NoteServiceImplement noteService = new NoteServiceImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNote(request,response);
                break;
            case "edit":
                updateNote(request,response);
                break;
            case "delete":
                deleteNote(request,response);
                break;
            default:
                break;
        }
    }
    private void deleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = this.noteService.findById(id);
        if (note == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.noteService.remove(id);
            try {
                response.sendRedirect("/iNotes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");

        Note note = this.noteService.findById(id);
        RequestDispatcher dispatcher;
        if (note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            note.setTitle(title);
            note.setContent(content);
            note.setType(type);
            this.noteService.update(id,note);
            request.setAttribute("note",note);
            request.setAttribute("message","Note was update");
            dispatcher = request.getRequestDispatcher("iNote/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNote(HttpServletRequest request, HttpServletResponse response) {
        int id = (int)(Math.random()*100);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");

        Note note = new Note(id,title,content,type);
        this.noteService.save(note);
        RequestDispatcher dispatcher = request.getRequestDispatcher("iNote/create.jsp");
        request.setAttribute("message","New Note was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                showCreateNote(request,response);
                break;
            case "edit":
                showEditNote(request,response);
                break;
            case "delete":
                showDeleteNote(request,response);
                break;
            case "view":
                viewNote(request,response);
                break;
            default:
                noteList(request,response);
                break;
        }
    }

    private void showCreateNote(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("iNote/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = this.noteService.findById(id);
        RequestDispatcher dispatcher;
        if(note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("note", note);
            dispatcher = request.getRequestDispatcher("iNote/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = this.noteService.findById(id);
        RequestDispatcher dispatcher;
        if (note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("note",note);
            dispatcher = request.getRequestDispatcher("iNote/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = this.noteService.findById(id);
        RequestDispatcher dispatcher;
        if (note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("note",note);
            dispatcher = request.getRequestDispatcher("iNote/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void noteList(HttpServletRequest request, HttpServletResponse response) {
        List<Note> notes = this.noteService.getListNote();

        request.setAttribute("notes",notes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("iNote/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
