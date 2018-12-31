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
public class ListaV {
    NodoOrto first;
    NodoOrto last;
    int size;
    public ListaV(){
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

    NodoOrto get(int y){
        if(!Vacia()){
            NodoOrto aux=first;
            while(aux.down!=null){
                if(aux.y==y){
                    return aux;
                }
                aux= aux.down;
            }
            if(aux.y==y){
                return aux;
            }
        }
        //cout<< "Nodo ortogonal inexistente";
        return null;
    }

    NodoOrto searchByPos(int no){
        if(!Vacia()){
            NodoOrto aux=first;
            for(int i=0;i<no;i++){
                aux = aux.down;
            }
            return aux;
        }
        //cout<<"Lista vacia";
        return null;
    }

    void add(NodoOrto nodo){
        if(Vacia()){
            first=last= nodo;
        }else{
            if(nodo.y<first.y){
                addFirst(nodo);
            }else if(nodo.y>last.y){
                addLast(nodo);
            }else{
                addMiddle(nodo);
            }
        }
        size++;
    }

    void addLast(NodoOrto nodo){
        last.down = nodo;
        nodo.up = last;
        last = last.down;
    }

    void addFirst(NodoOrto nodo){
        first.up=nodo;
        nodo.down= first;
        first=first.up;
    }

    void addMiddle(NodoOrto nodo){
        NodoOrto temp1;
        NodoOrto temp2;
        temp1 = first;
        while(temp1.y<nodo.y){
            temp1 = temp1.down;
        }
        if(temp1.y==nodo.y) return;
        temp2 = temp1.up;
        temp2.down = nodo;
        temp1.up = nodo;
        nodo.down = temp1;
        nodo.up = temp2;
    }

    void recorrer(){
        if(!Vacia()){
        NodoOrto temp=first;
        while(temp!=null){
            //cout<<"y: "<<temp.y<<endl;
            temp = temp.down;
        }
        }
    }
}
