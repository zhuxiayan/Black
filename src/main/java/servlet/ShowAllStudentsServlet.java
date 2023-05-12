package servlet;
import po.Student;
import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ShowAllStudentsServlet")
public class ShowAllStudentsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service = new StudentServiceImpl();
        HttpSession  session =   request.getSession();
        List<Student> allStudents = service.getAllStudents();
        session.setAttribute("allStudents", allStudents);
        response.sendRedirect("showAllStudent.jsp");
    }

}

