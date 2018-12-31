/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serveredd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author edwrick
 */
public class Matriz {
    Laterales l;
    Headers h;
    
    
    public Matriz(){
        this.l= new Laterales();
        this.h= new Headers();
    }
    public void insert(int id,int x, int y,String elem){
        NodoOrto nodo;
        nodo = new NodoOrto(id,x,y);
        nodo.elemento= elem;
        switch(elem){
            case "deepskyblue":
                nodo.z=0;
                break;
            case "greenyellow":
                nodo.z=1;
                break;
            case "chartreuse4":
                nodo.z=2;
                break;
            case "bisque4":
                nodo.z=3;
                break;
            case "chocolate":
                nodo.z=4;
                break;
        }
        nodo.c++;
        NodoHeader tempH;
        NodoLate tempL;
        tempH = h.buscar(x);
        tempL = l.buscar(y);
        System.out.println("Punto de busqueda.");
        if(tempH==null){ h.add(x); tempH = h.buscar(x);}
        if(tempL==null){ l.add(y); tempL = l.buscar(y);}
        tempH.column.add(nodo);
        tempL.row.add(nodo);
        System.out.println("Punto de insercion.");
        //cout<<"Dato insertado en pos: "<<x<<","<<y<<endl;
    }

    public NodoOrto search(int x,int y){
        NodoHeader tempH;
        tempH = h.search(x);
        NodoOrto temp=null ;
        if(tempH!=null) temp = tempH.column.get(y);
        return temp;
    }
    
    public String dot() throws IOException{
        StringBuilder texto = new StringBuilder("digraph G {");
        StringBuilder colision = new StringBuilder();
        texto.append("\n  \r\n  node [shape=record];\r\n");
        texto.append("\r\n M00 [label = \"Matriz\" ");
        texto.append(",group=a];\n");
        NodoHeader auxH = h.first;
        while(auxH!=null){
            texto.append("\r\n node"+auxH.x+"Y0 [label = \""+auxH.x);
            texto.append("\",group=X"+auxH.x+"];\n");
            
            auxH=auxH.next;
        }
        auxH = h.first;
        texto.append("{rank=same;");
        texto.append("M00;");
        while(auxH!=null){
            texto.append("node"+auxH.x+"Y0;");
            auxH=auxH.next;
        }
        texto.append("}");
        texto.append("M00").append(" -> ").append("node"+h.first.x+"Y0");
        auxH = h.first;
        while(auxH!=null){
            if(auxH.next!=null){ 
                texto.append("\r\n node"+auxH.x+"Y0 ").append(" -> ").append("node"+auxH.next.x+"Y0 ");
                texto.append("\r\n node"+auxH.next.x+"Y0 ").append(" -> ").append("node"+auxH.x+"Y0 ");
            }
            auxH=auxH.next;
        }
        
        
        NodoLate auxL = l.first;
        while(auxL!=null){
            texto.append("\r\n node0Y"+auxL.y+"[label = \""+auxL.y);
            texto.append("\",group=a];\n");
            
            auxL=auxL.next;
        }
        auxL = l.first;
        if(auxL.next!=null) texto.append("node0Y"+auxL.y).append(" -> ").append("node0Y"+auxL.next.y);
        auxL=auxL.next;
        while(auxL.next!=null){
            texto.append(" -> ").append("node0Y"+auxL.next.y);
            auxL=auxL.next;
        }
        auxL = l.first;
        while(auxL!=null){
            if(auxL.row.first!=null){
                NodoOrto ortoTemp = auxL.row.first;
                while(ortoTemp!=null){
                    texto.append("\r\n node"+ortoTemp.x+"Y"+ortoTemp.y+ "[label = \"X:"+ortoTemp.x+",Y:"+ortoTemp.y);
                    texto.append("\",group=X"+ortoTemp.x+"];\n");
                    ortoTemp=ortoTemp.der;
                }
                ortoTemp = auxL.row.first;
                texto.append("{rank=same;");
                texto.append("node0Y"+auxL.y+";");
                while(ortoTemp!=null){
                    texto.append("node"+ortoTemp.x+"Y"+ortoTemp.y+";");
                    ortoTemp=ortoTemp.der;
                }
                texto.append("}");
                ortoTemp = auxL.row.first;
                texto.append("\r\n node0Y"+auxL.y).append(" -> ").append("node"+ortoTemp.x+"Y"+ortoTemp.y);
                while(ortoTemp!=null){
                    if(ortoTemp.der!=null){
                        texto.append("\r\n node"+ortoTemp.x+"Y"+ortoTemp.y).append(" -> ").append("node"+ortoTemp.der.x+"Y"+ortoTemp.der.y);
                        texto.append("\r\n node"+ortoTemp.der.x+"Y"+ortoTemp.der.y).append(" -> ").append("node"+ortoTemp.x+"Y"+ortoTemp.y);
                    }
                    ortoTemp=ortoTemp.der;
                }
            }
            
            auxL=auxL.next;
        }
        if(l.first!=null) texto.append("\r\n M00").append(" -> ").append("\r\n node0Y"+l.first.y);
        auxH = h.first;
        while(auxH!=null){
            if(auxH.column.first!=null){
                NodoOrto ortoTemp = auxH.column.first;
                texto.append("\r\n node"+auxH.x+"Y0").append(" -> ").append("node"+ortoTemp.x+"Y"+ortoTemp.y);
                while(ortoTemp!=null){
                    if(ortoTemp.down!=null){
                        texto.append("\r\n node"+ortoTemp.x+"Y"+ortoTemp.y).append(" -> ").append("node"+ortoTemp.down.x+"Y"+ortoTemp.down.y);
                        texto.append("\r\n node"+ortoTemp.down.x+"Y"+ortoTemp.down.y).append(" -> ").append("node"+ortoTemp.x+"Y"+ortoTemp.y);
                    }    
                    ortoTemp=ortoTemp.down;
                }
            }
            auxH=auxH.next;
        }
                        
        
        texto.append(colision);
        texto.append("}");

        File archivo = new File("capa.dot");
        BufferedWriter bw;
        bw =new BufferedWriter(new FileWriter(archivo));
        bw.write(texto.toString());
        bw.close();        
        Runtime.getRuntime().exec("dot -Tpng capa.dot -o capa.png");
        Runtime.getRuntime().exec("feh capa.png");        
        return texto.toString();
    }
}

