package Controller;

import Model.Image;
import Service.IImage;
import Service.ImageImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ImageServlet", urlPatterns = "/images")
public class ImageServlet extends HttpServlet {

    private IImage imageImpl = new ImageImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createImage(request, response);
                break;
            default:
                break;
        }
    }

    private void createImage(HttpServletRequest request, HttpServletResponse response) {
        String image = request.getParameter("response");
        this.imageImpl.createImage(image);
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("image/create.jsp");
            request.setAttribute("message", "New image was created");
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                listEvent(request, response);
                break;
        }
    }

    private void listEvent(HttpServletRequest request, HttpServletResponse response) {
        List<Image> imageList = this.imageImpl.getAllImage();
        request.setAttribute("imageList", imageList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("image/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("image/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
