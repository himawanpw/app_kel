package com.interfaces;

import com.entities.Kelengkeng;

import java.util.List;

public interface KelengkengInt {
    void createTableKelengkeng();
    void createTableTransaksi();
    void insert(Kelengkeng kelengkeng);
    Kelengkeng selectByName(String jenis);
    List<Kelengkeng> selectAll();
    void delete(int id);
    void update(Kelengkeng kelengkeng,int id);
    void calculate(Kelengkeng kelengkeng);
    List<Kelengkeng> showHistory();
    void addAdmin(Kelengkeng kelengkeng);
    void delAdmin(int id);
    void loginAdmin(Kelengkeng kelengkeng);
}
