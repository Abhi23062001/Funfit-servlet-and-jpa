package com.astr.gymproject.entity;

public class Participant {
    private int id;
    private String name;
    private int age;
    private int batchId;
    public Participant() {
    }

    public Participant(int id, String name, int age, int batchId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.batchId = batchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", batchId=" + batchId +
                '}';
    }
}
