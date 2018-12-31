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
public class ListaH {
    NodoOrto first;
    NodoOrto last;
    int size;
    public ListaH(){
        first=null;
        last=null;
        size=0;
    }
    boolean Vacia(){
        if(first==null){
            return true;
        }
        return false;
    }

    void add(NodoOrto nodo){
        if(Vacia()){
            first=last= nodo;
        }else{
            if(nodo.x<first.x){
                addFirst(nodo);
            }else if(nodo.x>last.x){
                addLast(nodo);
            }else{
                addMiddle(nodo);
            }
        }
        size++;
    }

    void addLast(NodoOrto nodo){
        last.der = nodo;
        nodo.izq = last;
        last = last.der;
    }

    void addFirst(NodoOrto nodo){
        first.izq=nodo;
        nodo.der= first;
        first=first.izq;
    }

    public void addMiddle(NodoOrto nodo){
        NodoOrto temp1;
        NodoOrto temp2;
        temp1 = first;
        while(temp1.x<nodo.x){
            temp1 = temp1.der;
        }
        if(temp1.x==nodo.x) return;
        temp2 = temp1.izq;
        temp2.der = nodo;
        temp1.izq = nodo;
        nodo.izq = temp2;
        nodo.der = temp1;
    }
}
