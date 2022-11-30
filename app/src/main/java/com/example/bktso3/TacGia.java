package com.example.bktso3;

public class TacGia {
    String ten, moTa, sao;
    int hinhAnh;

    public TacGia(String ten, String moTa, String sao, int hinhAnh) {
        this.ten = ten;
        this.moTa = moTa;
        this.sao = sao;
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSao() {
        return sao;
    }

    public void setSao(String sao) {
        this.sao = sao;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
