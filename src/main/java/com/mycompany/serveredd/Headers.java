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
public class Headers {
    NodoHeader first;
    NodoHeader last;
    int size;

    public Headers() {
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
    
    NodoHeader buscar( int x){
        if(!Vacia()){
            NodoHeader temp = first;
            while(temp!=null){
                if(temp.x==x) return temp;
                temp= temp.next;
            }
        }
        return null;
    }

//    boolean existsWTitle(String title){
//
//        if(Vacia()){
//            return false;
//        }else{
//            NodoHeader temp;
//            temp = first;
//            while(temp!=null){
//                if(temp.name== title){
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
//
//        if(existsWTitle(title)){
//            NodoHeader temp;
//            temp = first;
//            while(temp.name!= title){
//                temp = temp.next;
//
//            }
//            return temp.x;
//        }else{
//            return 0;
//        }
//    }
    boolean exists(int x){
        if(Vacia()){
            return false;
        }else{
            NodoHeader temp;
            temp = first;
            while(temp!=null){
                if(temp.x == x) return true;
                temp = temp.next;
            }
        }
        return false;
    }

    NodoHeader search(int x){
        if(exists(x)){
            NodoHeader temp;
            temp = first;
            while(temp.x != x){
                temp = temp.next;
            }
            return temp;
        }else{
            return null ;
        }
    }
    NodoHeader searchByPos(int x){
        if(!Vacia()){
            NodoHeader temp;
            temp = first;
            for(int i=0;i<x;i++){
                temp = temp.next;
            }
            return temp;
        }else{
            return null;
        }
    }

//    NodoHeader getNodeByTitle(String title){
//        if(existsWTitle(title)){
//            NodoHeader temp;
//            temp = first;
//            while(temp.name!= title){
//                temp = temp.next;
//            }
//            return temp;
//        }else{
//            return null ;
//        }
//    }

    void add(int x){
        NodoHeader nodo=new NodoHeader(x);
        if(Vacia())first=last= nodo;
        else{
            if(nodo.x<first.x) addFirst(nodo);
            else if(nodo.x>last.x) addLast(nodo);
            else addMiddle(nodo);
        }
        size++;
    }
    
    void addLast(NodoHeader nodo){
        last.next = nodo;
        nodo.ant = last;
        last = last.next;
    }

    void addFirst(NodoHeader nodo){
        first.ant=nodo;
        nodo.next= first;
        first=first.ant;
    }

    void addMiddle(NodoHeader nodo){
        NodoHeader temp1;
        NodoHeader temp2;
        temp1 = first;
        while(temp1.x<nodo.x){
            temp1 = temp1.next;
        }
        temp2 = temp1.ant;
        temp2.next = nodo;
        temp1.ant = nodo;
        nodo.ant = temp2;
        nodo.next = temp1;
    }

    /*void addLast(NodoHeader<T> nodo){
        last.next = nodo;
        nodo.ant = last;
        last = last.next;
    }

    void addFirst(NodoHeader<T> nodo){
        first.ant=nodo;
        nodo.next= first;
        first=first.ant;
    }

    void addMiddle(NodoHeader<T> nodo){
        NodoHeader<T> temp1;
        NodoHeader<T> temp2;
        temp1 = first;
        while(temp1.x<nodo.x){
            temp1 = temp1.ant;
        }
        temp2 = temp1.next;
        temp2.ant = nodo;
        temp1.next = nodo;
        nodo.ant = temp1;
        nodo.next = temp2;
    }*/
//    String getName(int x){
//        if(exists(x)){
//            NodoHeader temp;
//            temp = first;
//            while(temp.x != x){
//                temp = temp.next;
//            }
//            return temp.name;
//        }else{
//            return "inexistente";
//        }
//    }
//
//    String getNameByPos(int x){
//        if(!Vacia()){
//            NodoHeader temp;
//            temp = first;
//            for(int i=0;i<x;i++){
//                temp = temp.next;
//            }
//            return temp.name;
//        }else{
//            return "inexistente";
//        }
//    }

    void recorrer(){
        if(!Vacia()){
        NodoHeader temp=first;
        while(temp!=null){
            //cout<<"x: "<<temp.x<<endl;
            temp = temp.next;
        }
        }
    }
}

