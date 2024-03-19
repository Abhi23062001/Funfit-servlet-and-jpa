package com.astr.gymproject.dao;

import com.astr.gymproject.dao.util.MySQLJDBCUtil;
import com.astr.gymproject.entity.Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BatchDAO {
    private final static String SELECT_FROM_BATCH = "SELECT * FROM batch";
    private final static String INSERT_INTO_BATCH= "INSERT INTO batch(name, startdate, enddate) VALUES(?, ?, ?)";
    private final static String DELETE_FROM_BATCH= "DELETE FROM batch WHERE id=?";
    private final static String UPDATE_BATCH = "UPDATE batch SET name = ?, startdate = ?, enddate = ? WHERE id = ?";

    private static Connection mySQLConnection;
    private static PreparedStatement psSelect;
    private static PreparedStatement psInsert;
    private static PreparedStatement psDelete;
    private static PreparedStatement psUpdate;
    private static BatchDAO batchDao = new BatchDAO();

    private static List<Batch> batchList;


    static {
        mySQLConnection = MySQLJDBCUtil.getConnection();
        try {
            psSelect = mySQLConnection.prepareStatement(SELECT_FROM_BATCH);
            psInsert = mySQLConnection.prepareStatement(INSERT_INTO_BATCH);
            psDelete = mySQLConnection.prepareStatement(DELETE_FROM_BATCH);
            psUpdate = mySQLConnection.prepareStatement(UPDATE_BATCH);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static BatchDAO createBatchDao(){
        return batchDao;
    }

    public List<Batch> getBatchList(){
        batchList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = psSelect.executeQuery();
            while (rs.next()) {
                batchList.add(new Batch(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MySQLJDBCUtil.close(rs);
        }
        return batchList;
    }

    public void addNewBatch(Batch batch){
        try {
            psInsert.setString(1, batch.getName());
            psInsert.setString(2, batch.getStartDate());
            psInsert.setString(3, batch.getEndDate());
            psInsert.executeUpdate();
            batchList.add(batch);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBatch(Batch batch){
        try {
            psDelete.setInt(1, batch.getId());
            psDelete.executeUpdate();
            batchList.remove(batch);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Batch getBatchById(int id){
        for (Batch batch:batchList){
            if (id == batch.getId()){
                return batch;
            }
        }
        return null;
    }

    public void updateBatch(Batch batch){
        try {
            psUpdate.setString(1, batch.getName());
            psUpdate.setString(2, batch.getStartDate());
            psUpdate.setString(3, batch.getEndDate());
            psUpdate.setInt(4, batch.getId());
            psUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
