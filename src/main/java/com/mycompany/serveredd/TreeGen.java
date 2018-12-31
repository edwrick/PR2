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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edwrick
 */
public class TreeGen {
	public TreeNode root;
	private int alt;
        public String troops="";
	
	public void setRoot(Comparable x){
		root.setValue(x);
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void makeEmpty(){
		root=null;
	}
	public void printPreOrder(){
		root.preOrder();
	}
	public void printInOrder(){
		root.inOrder();
	}
	public void printPosOrder(){
		root.posOrder();
	}
        
        public void generateGrap(){
            try {
                StringBuilder texto = new StringBuilder("digraph G {");
                texto.append("\n  \r\n  node [style = filled];\r\n");
                texto.append("\r\n rankdir=TB;");
                graph(root,texto);
                texto.append("}");
                File archivo = new File("tree.dot");
                BufferedWriter bw;
                bw =new BufferedWriter(new FileWriter(archivo));
                bw.write(texto.toString());
                bw.close();
                Runtime.getRuntime().exec("dot -Tpng tree.dot -o tree.png");
                Runtime.getRuntime().exec("feh tree.png");
            } catch (IOException ex) {
                Logger.getLogger(TreeGen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public String getTroops(TreeNode raiz){
            if(raiz!=null){
                if(raiz==root) troops+=raiz.id;
                else troops+=","+raiz.id;
                if(raiz.getLeft()!=null) getTroops(raiz.getLeft());
                if(raiz.getRight()!=null) getTroops(raiz.getRight());
            }
            return troops;
        }
        
        public void graph(TreeNode root,StringBuilder texto){
            if(root!=null){
                texto.append("\r\nn"+root.id).append("[label=\"Id:").append(root.id).append("Vida:").append(root.vida).append("PosX:"+root.x).append("PosY:"+root.y).append("\"]");
                if(root.getLeft()!=null && root.getRight()!=null){
                    texto.append("\r\nn"+root.id).append("->").append("n"+root.getLeft().id);
                    graph(root.getLeft(),texto);
                    texto.append("\r\nn"+root.id).append("->").append("n"+root.getRight().id);
                    graph(root.getRight(),texto);
                }else if(root.getLeft()!=null){
                    texto.append("\r\nn"+root.id).append("->").append("n"+root.getLeft().id);
                    texto.append("\r\nn"+root.id).append("->").append("nFake"+root.id+"[style=\"invis\"]");
                    texto.append("\r\nnFake"+root.id+"[label=\"W\", style=\"invis\"];");
                    graph(root.getLeft(),texto);
                }
                else if(root.getRight()!=null){
                    texto.append("\r\nn"+root.id).append("->").append("nFake"+root.id+"[style=\"invis\"]");
                    texto.append("\r\nnFake"+root.id+"[label=\"W\", style=\"invis\"];");
                    texto.append("\r\nn"+root.id).append("->").append("n"+root.getRight().id);
                    graph(root.getRight(),texto);
                }
            }
        }
        
        public TreeNode search(TreeNode root,int num){
            if(root!=null){
                if(root.id==num) return root;
                if(root.getLeft()!=null && root.getRight()!=null){
                    search(root.getLeft(),num);
                    search(root.getRight(),num);
                }else if(root.getLeft()!=null) search(root.getLeft(),num);
                else if(root.getRight()!=null)search(root.getRight(),num);
            }
            return null;
        }
        
	//Insertar elementos en el arbol sin repetidos.
	private TreeNode insert(Comparable value, int x,int y,int z,int num,  TreeNode current){
		//caso 1: si el arbol es vacio.
		if (current==null){
			current=new TreeNode(x,y,z,(int) value, num);
                }
		//si el arbol no es vacio.
		else{			
			//ubico por derecha
			if (  value.compareTo(  current.getValue() ) > 0 ) {
				current.setRight(insert(value,x,y,z,num, current.getRight() ) );
			}
			//ubico por izquierda
                        else if (value.compareTo(current.getValue() ) < 0){
				current.setLeft(insert(value,x,y,z,num, current.getLeft()));
			}
			//no ubico, elemento existente.
                        else if ( value.compareTo(current.getValue() )==0 ) {
//				throw new ExceptionTree ("ExceptionTree : insert : Elemento Existente ");
			}
		}
		return current;
	}
	public void insertTree (Comparable value,int x,int y , int z,int num){
		TreeNode current = root;
		current=insert(value,x,y,z,num,current);
		root=current;
	}
	public TreeNode remove (Comparable value, TreeNode r) {
		if (r == null) {
        return null;
    	}    
    	if (value.equals(r.getValue())) {
        // r es el nodo que hay que remover.
        	if (r.getLeft() == null && r.getRight() == null) {
            	return null;
        	}
        	if (r.getLeft() == null) {
            	return r.getRight();
        	}
        	if (r.getRight() == null) {
            	return r.getLeft();
        	}
       	// si llega aca, r tiene dos hijos.
        	Comparable smallVal = smallest(r.getRight());
        	r.setValue(smallVal);
        	r.setRight(remove(smallVal,r.getRight()) );
        	return r; 
    	}
       	else if (value.compareTo(r.getValue()) < 0) {
        	r.setLeft( remove(value,r.getLeft()) );
        	return r;
    	}
        else {
        	r.setRight( remove(value,r.getRight()) );
        	return r;
    	}	
	}
	public void removeTree(Comparable value){
		try{ 
		root=(remove(value,root));
		}catch (Exception e){}
	}









	//EL mas chico del arbol.
	public Comparable smallest(TreeNode r){
		if (r.getLeft()==null){
			return	r.getValue();
		}else{
			return smallest(r.getLeft());
		}
	}









	//CONTINUAR OTRA METODOLOGIA POR ACA!!!







	//Eliminar un elemento del arbol
	/*public void removeTree(Object x)throws ExceptionTree{
		TreeNode current=root;
		current = searchRemove(x, current);
		if (current!= null){ 
			if (isLeaf(current)){ //Si es hoja, solamente borro.
				current=null;
			}
			else{//Si no es hoja
				if ( current.getLeft()!=null && current.getLeft()!=null ){
					//buscar el minimo o maximo y setearlo con el.
					//En este caso el nodo a reemplazar es un root.
					Object valueMax= maxTree(current);
					current.setValue(valueMax);
				}
				if ( current.getLeft()==null && current.getLeft()!=null ){
					//hi = null pero el hd!= null,
					//reemplazo por el maximo de la derecha.
					Object valueMax= maxTree(current);
					current.setValue(valueMax);
				} 
				if ( current.getLeft()!=null && current.getLeft()==null ){
					//hi!= null y hd==null,
					//reemplazo por el minimo de la derecha.
					Object valueMin= minTree(current);
					current.setValue(valueMin);
				}
			}
		}else{
			throw new ExceptionTree("ExceptionTree : remove : Elemento No existente ");
		}		
	} 
	//Si un nodo es Hoja
	public boolean isLeaf (TreeNode current){
		return (current.getRight()==null && current.getLeft()==null);
	}
    //ACAAAAAAAAAAAA---------------------------------
	//Devuelve el elemento a borrar
	public TreeNode searchRemove(Comparable x, TreeNode current){
		TreeNode found = null;
		if ( ( current.getValue() ).equals(x) ){
			found=current;
		}
		if ( ( current.getValue() ).compareTo(x) > 0) {
			current.setRight(searchRemove( x,current.getRight() ) );
		}
		if (( current.getValue() ).compareTo( x) < 0){
			current.setLeft(searchRemove( x,current.getLeft() ) );
		}
		return found;
	}
	//Obtiene el minimo del arbol y lo destruye.
	//antes retornando su dato
	public Comparable minTree (TreeNode current){
		TreeNode min = current;
		while (min.getLeft()!=null){
			min=min.getLeft(); //solo avanzo
		}
		Comparable value= min.getValue();
		min=null;
		return value;
	}
	//Obtiene el maximo del arbol y lo destruye.
	//antes retornando su dato
	public Comparable maxTree(TreeNode current){
		TreeNode max= current;
		while (max.getRight()!=null){
			max=max.getRight();
		}
		Comparable value= max.getValue();
		max=null;
		return value;
	}*/

}