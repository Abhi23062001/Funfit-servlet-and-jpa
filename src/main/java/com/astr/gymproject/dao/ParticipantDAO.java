package com.astr.gymproject.dao;

import com.astr.gymproject.dao.util.MySQLJDBCUtil;
import com.astr.gymproject.entity.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private final static String SELECT_FROM_PARTICIPANT = "SELECT * FROM participant ORDER BY batch_id";
    private final static String INSERT_INTO_PARTICIPANT = "INSERT INTO participant(name, age, batch_id) VALUES(?, ?, ?)";
    private final static String DELETE_FROM_PARTICIPANT = "DELETE FROM participant WHERE id=?";
    private final static String UPDATE_PARTICIPANT = "UPDATE participant SET name=?, age=?, batch_id=? WHERE id=?";

    private static Connection mySQLConnection;
    private static PreparedStatement psSelect;
    private static PreparedStatement psInsert;
    private static PreparedStatement psDelete;
    private static PreparedStatement psUpdate;
    private static ParticipantDAO participantDao = new ParticipantDAO();

    private static List<Participant> participantList;

    static {
        mySQLConnection = MySQLJDBCUtil.getConnection();

        try {
            psSelect = mySQLConnection.prepareStatement(SELECT_FROM_PARTICIPANT);
            psInsert = mySQLConnection.prepareStatement(INSERT_INTO_PARTICIPANT);
            psDelete = mySQLConnection.prepareStatement(DELETE_FROM_PARTICIPANT);
            psUpdate = mySQLConnection.prepareStatement(UPDATE_PARTICIPANT);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ParticipantDAO createParticipantDao(){
        return participantDao;
    }

    public List<Participant> getParticipantList(){
        participantList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = psSelect.executeQuery();
            while (rs.next()) {
                participantList.add(new Participant(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MySQLJDBCUtil.close(rs);
        }
        return participantList;
    }

    public void addNewParticipant(Participant participant){
        try {
            psInsert.setString(1, participant.getName());
            psInsert.setInt(2, participant.getAge());
            psInsert.setInt(3, participant.getBatchId());
            psInsert.executeUpdate();
            participantList.add(participant);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteParticipant(Participant participant){
        try {
            psDelete.setInt(1, participant.getId());
            psDelete.executeUpdate();
            participantList.remove(participant);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Participant getParticipantById(int id){
        for(Participant participant:participantList){
            if (id == participant.getId()){
                return participant;
            }
        }
        return null;
    }

    public void updateParticipant(Participant participant){
        try {
            psUpdate.setString(1, participant.getName());
            psUpdate.setInt(2, participant.getAge());
            psUpdate.setInt(3, participant.getBatchId());
            psUpdate.setInt(4, participant.getId());
            psUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
