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
public class NodoLate {
    //String name,carnet;
    NodoLate ant;
    NodoLate next;
    int y;
    ListaH row;
    
    public NodoLate(int y){
        this.y=y;
        this.ant=null;
        this.next=null;
        this.row= new ListaH();
    }
//    public NodoLate(String name, String carnet, int y) {
//        this.name = name;
//        this.carnet = carnet;
//        this.y = y;
//        this.ant=null;
//        this.next=null;
//        this.row= new ListaH();
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
//    public String getCarnet() {
//        return carnet;
//    }
//
//    public void setCarnet(String carnet) {
//        this.carnet = carnet;
//    }

    public NodoLate getAnt() {
        return ant;
    }

    public void setAnt(NodoLate ant) {
        this.ant = ant;
    }

    public NodoLate getNext() {
        return next;
    }

    public void setNext(NodoLate next) {
        this.next = next;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
