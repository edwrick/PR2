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
public class listaCD {
    public Nodo first;
    public Nodo last;
    public int size;
    public class Nodo {
    public String nombre;
    public  int  lvl;
    public Matriz mat;
    public  Nodo anterior;
    public  Nodo siguiente;
    
        public Nodo(String nombre,int nivel) {
            this.nombre = nombre;
            this.lvl = nivel;
            this.mat=new Matriz();
            this.anterior=null;
            this.siguiente=null;
        }
    
    }
    
    public listaCD(){
        this.first=null;
        this.last=null;
        this.size=0;
    }
    
    public void add(String name,int nivel){
        Nodo nuevo = new Nodo(name,nivel);
        if(first!=null){
            nuevo.anterior=last;
            nuevo.siguiente=first;
            last.siguiente=nuevo;
            last=nuevo;
        }else{
            first=last=nuevo;
            nuevo.siguiente=first;
            nuevo.anterior=last;
        }
        size++;
    }
    
    public void del(int lvl){
        Nodo delNodo = getByLvl(lvl);
        try{
        if(delNodo!=null){
            if(delNodo==first){
                last.siguiente=delNodo.siguiente;
                delNodo.siguiente.anterior= last;
                first= delNodo.siguiente;
            }else if(delNodo==last){
                first.anterior= delNodo.anterior;
                delNodo.anterior.siguiente=first;
                last = delNodo.anterior;
            }else{
                if (delNodo.anterior!=null) delNodo.anterior.siguiente=delNodo.siguiente;
                if (delNodo.siguiente!=null) delNodo.siguiente.anterior=delNodo.anterior;
            }
        }
        size--;
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public Nodo getByLvl(int nivel){
        if(first!=null){
            Nodo aux = first;
            if(aux.lvl==nivel) return aux;
                aux=aux.siguiente;
                while(aux!=first){
                    if(aux.lvl==nivel) return aux;
                    aux=aux.siguiente;
                }
            
        }
        return null;
    }
    
    public Nodo get(String room){
        if(first!=null){
            Nodo aux = first;
            if(aux.nombre.equals(room)) return aux;
                aux=aux.siguiente;
                while(aux!=first){
                    if(aux.nombre.equals(room)) return aux;
                    aux=aux.siguiente;
                }
            
        }
        return null;
    }
}
