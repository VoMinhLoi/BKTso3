package com.example.bktso3;

public class TacPham {
    String id, tenTP, idTG;

    public TacPham(String id, String tenTP, String idTG) {
        this.id = id;
        this.tenTP = tenTP;
        this.idTG = idTG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public String getIdTG() {
        return idTG;
    }

    public void setIdTG(String idTG) {
        this.idTG = idTG;
    }
}
