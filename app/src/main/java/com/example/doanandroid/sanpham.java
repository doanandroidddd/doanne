package com.example.doanandroid;

import java.io.Serializable;

public class sanpham implements Serializable {
int hinh;

    public int getSoluongkho() {
        return soluongkho;
    }

    public void setSoluongkho(int soluongkho) {
        this.soluongkho = soluongkho;
    }

    int soluongkho;

    public int getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }

    int soluongban;
String tensp,masp,mota;

    public sanpham(int hinh, String tensp, String masp, String mota,int soluongkho) {
        this.hinh = hinh;
        this.tensp = tensp;
        this.masp = masp;
        this.mota = mota;
        this.soluongkho=soluongkho;
        this.soluongban=0;
    }
    public sanpham(int hinh,int soluongban, String tensp, String masp, String mota) {
        this.hinh = hinh;
        this.tensp = tensp;
        this.masp = masp;
        this.mota = mota;
        this.soluongban=soluongban;
        this.soluongkho=0;
    }
    public sanpham() {
    }
    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
