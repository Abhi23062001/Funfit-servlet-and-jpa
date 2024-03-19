package com.astr.gymproject.dao.util;

import java.sql.*;

public class MySQLJDBCUtil {

    private static final Connection mySqlJdbcConnection = new MySQLJDBCUtil().createConnection();

    public static Connection getConnection(){
        return mySqlJdbcConnection;
    }

    public Connection createConnection(){
        Connection connection;
        try {
            String connectionPath = "jdbc:mysql://localhost:3306/gym_project";
            String userName = "root";
            String password = "Abhiwhy8@";
            connection = DriverManager.getConnection(connectionPath, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
