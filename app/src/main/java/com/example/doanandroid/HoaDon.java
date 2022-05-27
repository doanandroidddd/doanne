package com.example.doanandroid;

import java.sql.Date;
import java.util.List;

public class HoaDon {
    String mahd;
    List<sanpham> sanphams;
    nhanvien nv;
    khachhang kh;


    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public List<sanpham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(List<sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public nhanvien getNv() {
        return nv;
    }

    public void setNv(nhanvien nv) {
        this.nv = nv;
    }

    public khachhang getKh() {
        return kh;
    }

    public void setKh(khachhang kh) {
        this.kh = kh;
    }

    public HoaDon(String mahd, List<sanpham> sanphams, nhanvien nv, khachhang kh) {
        this.mahd = mahd;
        this.sanphams = sanphams;
        this.nv = nv;
        this.kh = kh;

    }
    public HoaDon() {

    }
}
