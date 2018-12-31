/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serveredd;

/**
 *
 * @author edwrick
 */
public class NodoHeader {
//    String tipo,name,desc,date;
//    double ponde;
    NodoHeader ant;
    NodoHeader next;
    ListaV column;
    int x;
    public NodoHeader(int x){
        this.ant=null;
        this.next=null;
        this.column=new ListaV();
        this.x=x;
    }
//    public NodoHeader(String tipo, String name, String desc, String date, double ponde, int x) {
//        this.tipo = tipo;
//        this.name = name;
//        this.desc = desc;
//        this.date = date;
//        this.ponde = ponde;
//        this.x=x;
//        this.ant=null;
//        this.next=null;
//        this.column=new ListaV();
//    }
//
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public double getPonde() {
//        return ponde;
//    }
//
//    public void setPonde(double ponde) {
//        this.ponde = ponde;
//    }

    public NodoHeader getAnt() {
        return ant;
    }

    public void setAnt(NodoHeader ant) {
        this.ant = ant;
    }

    public NodoHeader getNext() {
        return next;
    }

    public void setNext(NodoHeader next) {
        this.next = next;
    }

    public ListaV getColumn() {
        return column;
    }

    public void setColumn(ListaV column) {
        this.column = column;
    }
    
}
