package com.example.baitapmau3.Class;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int id;
    private String ten, namsinh, que, trinhdo;

    public NhanVien(int id, String ten, String namsinh, String que, String trinhdo) {
        this.id = id;
        this.ten = ten;
        this.namsinh = namsinh;
        this.que = que;
        this.trinhdo = trinhdo;
    }

    public NhanVien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
