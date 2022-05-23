package com.example.doanandroid;

public class nhanvien {

    String tk,mk,manv,tennv;


    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }



    public nhanvien(String tk, String mk, String manv, String tennv) {
        this.tk = tk;
        this.mk = mk;
        this.manv = manv;
        this.tennv = tennv;

    }

    public nhanvien() {

    }


}
