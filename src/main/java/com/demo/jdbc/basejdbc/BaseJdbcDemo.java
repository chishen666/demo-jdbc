package com.demo.jdbc.basejdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;

public class BaseJdbcDemo {
    public static void main(String[] args) {
        try {
            // 1.注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.获取数据连接
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "root", "123456");

            JdbcTemplate jdbcTemplate = new JdbcTemplate();

            // 3.定义sql语句
            String username = "'' or 1=1";
            String sql1 = "select * from demo_user where username = " + username;
            String sql2 = "select * from demo_user where username = ?";

            // 4.获取执行sql的对象
            Statement st = conn.createStatement();
            PreparedStatement pst = conn.prepareStatement(sql2);
            pst.setString(1, username);

            // 5.执行sql
            ResultSet rs1 = st.executeQuery(sql1);
            ResultSet rs2 = pst.executeQuery();
            while (rs1.next()) {

                System.out.print(rs1.getString(1));
                System.out.print(" ");
                System.out.print(rs1.getString(2));
                System.out.print(" ");
                System.out.print(rs1.getString(3));
                System.out.println(" ");
            }
            rs1.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
