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
public class NodoOrto {
    NodoOrto izq;
    NodoOrto der;
    NodoOrto up;
    NodoOrto down;
    String elemento;
    String nombreTropa;
    double nota=0;
    int x,y,z;
    public int c=0;
    public NodoOrto(double nota, int x, int y) {
        this.nota = nota;
        this.x = x;
        this.y = y;
        this.izq=null;
        this.der=null;
        this.up=null;
        this.down=null;
        this.elemento="White";
        this.nombreTropa="";
    }

    public NodoOrto() {
    }

    public NodoOrto getIzq() {
        return izq;
    }

    public void setIzq(NodoOrto izq) {
        this.izq = izq;
    }

    public NodoOrto getDer() {
        return der;
    }

    public void setDer(NodoOrto der) {
        this.der = der;
    }

    public NodoOrto getUp() {
        return up;
    }

    public void setUp(NodoOrto up) {
        this.up = up;
    }

    public NodoOrto getDown() {
        return down;
    }

    public void setDown(NodoOrto down) {
        this.down = down;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}

