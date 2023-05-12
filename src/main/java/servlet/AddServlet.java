package servlet;
import po.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentService service = new StudentServiceImpl();
        String sno  = request.getParameter("sno");
        String sname  = request.getParameter("sname");
        String sex  = request.getParameter("sex");
        String age  = request.getParameter("age");
        String phone  = request.getParameter("phone");

        int _sno = 0;
        if(sno != null || "".equals(sno)){
            _sno = Integer.parseInt(sno);
        }

        int _age = 0;
        if (age !=null || "".equals(age)){
            _age = Integer.parseInt(age);
        }

        Student s = new Student(_sno, sname, sex, _age, phone);
        int result = service.addStudent(s);

        HttpSession session = request.getSession();
        session.setAttribute("student", "stu");
        response.sendRedirect("main.jsp");

    }
}


