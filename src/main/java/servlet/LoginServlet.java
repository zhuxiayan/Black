package servlet;
import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentService service = new StudentServiceImpl();
        HttpSession session = request.getSession();

        if (session.getAttribute("loginErrorMessage") != null) {
            session.invalidate();
        }
        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");


        int _uid = Integer.parseInt(uid);
        boolean result = service.login(_uid, pwd);

        if(result){
            session.setAttribute("login", "log");
            response.sendRedirect("main.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }

    }

}


