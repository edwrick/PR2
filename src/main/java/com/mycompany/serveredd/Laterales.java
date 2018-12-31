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
public class Laterales {
    NodoLate first;
    NodoLate last;
    int size;
    public Laterales(){
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

//    String getNameByPos(int x){
//        if(!Vacia()){
//            NodoLate temp;
//            temp = first;
//            for(int i=0;i<x;i++){
//                temp = temp.next;
//            }
//            return temp.carnet;
//        }else{
//            return "inexistente";
//        }
//    }
//
//    NodoLate getNodeByTitle(String title){
//        if(existsWTitle(title)){
//            NodoLate temp;
//            temp = first;
//            while(temp.carnet!= title){
//                temp = temp.next;
//
//            }
//            return temp;
//        }else{
//            return null ;
//        }
//    }
    void add(int y){
        NodoLate nodo = new NodoLate(y);
        if(Vacia()) first=last=nodo;
        else{
            if(nodo.y<first.y) addFirst(nodo);
            else if(nodo.y>last.y) addLast(nodo);
            else addMiddle(nodo);
        }
        size++;
    }

    void addLast(NodoLate nodo){
        last.next = nodo;
        nodo.ant = last;
        last = last.next;
    }

    void addFirst(NodoLate nodo){
        first.ant=nodo;
        nodo.next= first;
        first=first.ant;
    }

    void addMiddle(NodoLate nodo){
        NodoLate temp1;
        NodoLate temp2;
        temp1 = first;
        while(temp1.y<nodo.y){
            temp1 = temp1.next;
        }
        temp2 = temp1.ant;
        temp2.next = nodo;
        temp1.ant = nodo;
        nodo.ant = temp2;
        nodo.next = temp1;
    }

    /*void recorrer(){
        if(!Vacia()){
        NodoLate temp=first;
        while(temp!=null){
            cout<<"y: "<<temp.y<<endl;
            temp = temp.next;
        }
        }
    }*/
//
//    boolean existsWTitle(String title){
//        if(Vacia()){
//            return false;
//        }else{
//            NodoLate temp;
//            temp = first;
//            while(temp!=null){
//                if(temp.carnet== title){
//                    return true;
//                }else if(temp.next==null){
//                    return false;
//                }
//                temp = temp.next;
//
//            }
//        }
//        return false;
//    }
//    int searchWTitle(String title){
//        if(existsWTitle(title)){
//            NodoLate temp;
//            temp = first;
//            while(temp.carnet!= title){
//                temp = temp.next;
//
//            }
//            return temp.y;
//        }else{
//            return 0;
//        }
//    }

    boolean exists(int y){
        if(Vacia()){
            return false;
        }else{
            NodoLate temp;
            temp = first;
            while(temp!=null){
                if(temp.y == y){
                    return true;
                }else if(temp.next==null){
                    return false;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    NodoLate buscar( int y){
        if(!Vacia()){
            NodoLate temp = first;
            while(temp!=null){
                if(temp.y==y) return temp;
                temp= temp.next;
            }
        }
        return null;
    }
    
    NodoLate search(int y){
        if(exists(y)){
            NodoLate temp;
            temp = first;
            while(temp.y != y){
                temp = temp.next;
            }
            return temp;
        }else{
            return null ;
        }
    }
//    String getNick(int y){
//        if(exists(y)){
//            NodoLate temp;
//            temp = first;
//            while(temp.y != y){
//                temp = temp.next;
//            }
//            return temp.carnet;
//        }else{
//            return "inexistente";
//        }
//    }
}

