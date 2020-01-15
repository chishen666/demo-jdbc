package com.demo.jdbc.basejdbc;

import java.sql.*;

public class BaseJdbcDemo {
    public static void main(String[] args) {
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.获取数据连接
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false",
                "root", "123456");

            // 3.定义sql语句
            String sql = "select * from demo_user";

            // 4.获取执行sql的对象
            Statement st = conn.createStatement();

            // 5.执行sql
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
