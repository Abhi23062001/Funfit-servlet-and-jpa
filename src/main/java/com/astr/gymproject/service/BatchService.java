package com.astr.gymproject.service;

import com.astr.gymproject.dao.BatchDAO;
import com.astr.gymproject.entity.Batch;

import java.util.List;

public class BatchService {

    private BatchDAO batchDAO;

    private static BatchService batchService;
    static {
        batchService = new BatchService();
    }


    public BatchService(){
        this.batchDAO = BatchDAO.createBatchDao();
    }

    public static BatchService getBatchService(){
        return batchService;
    }

    public List<Batch> getBatchList(){
        return batchDAO.getBatchList();
    }

    public void addNewBatch(Batch batch){
        batchDAO.addNewBatch(batch);
    }

    public void deleteBatch(Batch batch){
        batchDAO.deleteBatch(batch);
    }

    public Batch getBatchById(int id){
        return batchDAO.getBatchById(id);
    }

    public void updateBatch(Batch batch){batchDAO.updateBatch(batch);}


}
