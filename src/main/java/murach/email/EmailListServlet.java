package murach.email;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;
import murach.data.UserDB;

import java.io.IOException;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";

        // Lấy hành động hiện tại
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // Mặc định
        }

        // Thực hiện hành động
        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            // Lấy các tham số từ form
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // Lưu dữ liệu vào User object
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            // Đặt đối tượng user vào request để truyền sang JSP
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        // Chuyển hướng nội bộ (forward)
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}