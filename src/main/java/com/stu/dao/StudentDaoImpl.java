package com.stu.dao;
import po.Student;
import utils.DBTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    Connection conn = null; // 连接对象
    Statement st = null; // 语句对象
    ResultSet rs = null; // 结果集合对象

    @Override
    public boolean login(int uid, String pwd) {
        // 在这里需要连接数据库，根据int sno, String pwd这两个参数来查询student表
        // jdbc
        // 1:配置环境，下载数据库连接驱动jar文件，拷贝到项目中来
        // 2:加载驱动，根据驱动创建数据库的连接对象

        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            // 3:执行sql语句，完成对数据库中表的数据的增删该查。必须创建一个语句对象（执行sql语句的）
            st = conn.createStatement();

            int count = 0;
            String sqlStr = "select * from login where uid =" + uid + " and pwd = '" + pwd + "'";

            rs = st.executeQuery(sqlStr);
            while(rs.next()) {
                count++;
            }
            if(count>0)
                return true;
            else
                return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Student> getAllStudents() {
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            // 3:执行sql语句，完成对数据库中表的数据的增删该查。必须创建一个语句对象（执行sql语句的）
            st = conn.createStatement();

            String sqlStr = "select * from student";

            rs = st.executeQuery(sqlStr);

            List<Student> allStudents = new ArrayList<Student>();

            while (rs.next()) {
                int _sno = rs.getInt(1);
                String _sname = rs.getString(2);
                String _sex = rs.getString(3);
                int _age = rs.getInt(4);
                String _phone = rs.getString(5);
                Student s = new Student(_sno, _sname, _sex, _age, _phone);
                allStudents.add(s);
            }

            return allStudents;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Student> queryStudentByPage(int current, int pageSize) {
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            // 3:执行sql语句，完成对数据库中表的数据的增删该查。必须创建一个语句对象（执行sql语句的）
            st = conn.createStatement();

            int startPosition = current * pageSize;

            String sqlStr = "select * from student limit " + startPosition + "," + pageSize;
            rs = st.executeQuery(sqlStr);
            List<Student> allStudents = new ArrayList<Student>();
            while (rs.next()) {
                int _sno = rs.getInt(1);
                String _sname = rs.getString(2);
                String _sex = rs.getString(3);
                int _age = rs.getInt(4);
                String _phone = rs.getString(5);
                Student s = new Student(_sno, _sname, _sex, _age, _phone);
                allStudents.add(s);
            }
            return allStudents;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getTotalCount() {//查询总数据数

        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            // 3:执行sql语句，完成对数据库中表的数据的增删该查。必须创建一个语句对象（执行sql语句的）
            st = conn.createStatement();
            String sql = "select count(*) from student";
            rs = st.executeQuery(sql);
            while (rs.next()){
                int totalCount = rs.getInt(1);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addStudent(Student student) {

        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            st = conn.createStatement();
            String sqlStr = "insert into student values("+student.getSno()+",'" + student.getSname()+ "','" + student.getSex() +"',"+student.getAge()+",'"+student.getPhone()+"')";
            System.out.println(sqlStr);
            int result = st.executeUpdate(sqlStr);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public boolean addLogin(int uid, String pwd) {
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            st = conn.createStatement();
            String sqlStr = "insert into login values(" + uid + ",'" + pwd + "')";

            int result = st.executeUpdate(sqlStr);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Student deleteStudent(int sno) {
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动
            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            st = conn.createStatement();
            String sqlStr = "delete from student where sno = " + sno;
            System.out.println(sqlStr);
            int result = st.executeUpdate(sqlStr);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student queryStudentBySno(int sno) {
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动

            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);

            st = conn.createStatement();

            String sqlStr = "select * from student where sno = "+ sno;
            rs = st.executeQuery(sqlStr);

            if (rs.next()) {
                int _sno = rs.getInt(1);
                String _sname = rs.getString(2);
                String _sex = rs.getString(3);
                int _age = rs.getInt(4);
                String _phone = rs.getString(5);
                Student s = new Student(_sno, _sname, _sex, _age, _phone);
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int updateStudentBySno(int sno, Student stu){
        try {
            Class.forName(DBTools.DRIVER_CLASS);// 加载驱动
            conn = DriverManager.getConnection(DBTools.CONN_STR, DBTools.USRENAME, DBTools.PWD);
            st = conn.createStatement();
            String sql = "update student set sname= '"+stu.getSname()+"', sex='"+stu.getSex()+"', age="+stu.getAge()+", phone='"+stu.getPhone()+"' where sno="+sno;
            System.out.println(sql);
            int result = st.executeUpdate(sql);

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}


