package com.ll.cmu.servlets;

import com.ll.cmu.dto.Member;
import com.ll.cmu.dto.MemberStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/usr/member/join")
public class MemberJoinServlet extends HttpServlet {

    static String url = "jdbc:mariadb://localhost:3307/community";
    static String user = "dmkim";
    static String password = "dmkim";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("/member/joinForm.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if(connection != null) {
                System.out.println("DB 접속 성공!!");
            }

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String email = req.getParameter("email");

            String sql = """
                    insert into member(username, password, name, email, admin_level)
                    values(?, ?, ?, ?, ?)
                    """;
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.setString(3, name);
            pstm.setString(4, email);
            pstm.setString(5, MemberStatus.USER.getLevel());

            int row = pstm.executeUpdate();
            if (row > 0) {
                System.out.println("데이터 추가 성공!!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
