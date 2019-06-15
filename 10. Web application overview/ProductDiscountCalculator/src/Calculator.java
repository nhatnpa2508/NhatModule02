import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", urlPatterns = "/calculator")
public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        float price =Float.parseFloat(request.getParameter("price"));
        float percent =Float.parseFloat(request.getParameter("percent"));
        float result = price*percent/100;
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        writer.println("<h1>Product: " + product+ "</h1>");
        writer.println("<h1>Price: " + price+ "</h1>");
        writer.println("<h1>Percent: " + percent+ "</h1>");
        writer.println("<h1>Product Discount Calculator: " + result+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
