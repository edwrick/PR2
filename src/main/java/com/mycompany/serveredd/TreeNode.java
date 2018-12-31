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
public class TreeNode{
	private Comparable value;
	private TreeNode left;
	private TreeNode right;
        public int vida;
        public int ataque;
        public int mov;
        public int alcA;
        public int alcMov;
        public int x;
        public int y;
        public int z;
        public int id;
        public int tipo;
	public TreeNode(){
		value=null;
		left=null;
		right=null;
	}
	public TreeNode(int x, int y,int z, int id, int num){
                this.x=x;
                this.y=y;
                this.z=z;
                this.id=id;
                value=id;
		left=null;
		right=null;
                this.tipo=num;
                switch(num){
                    case 0:
                        this.mov=3;
                        this.vida=50;
                        this.ataque=30;
                        this.alcA=1;
                        break;
                    case 1:
                        this.mov=2;
                        this.vida=50;
                        this.ataque=50;
                        this.alcA=3;
                        break;
                    case 2:
                        this.mov=6;
                        this.vida=100;
                        this.ataque=50;
                        this.alcA=2;
                        break;
                    case 3:
                        this.mov=4;
                        this.vida=150;
                        this.ataque=80;
                        this.alcA=2;
                        break;
                    case 4:
                        this.mov=3;
                        this.vida=200;
                        this.ataque=100;
                        this.alcA=2;
                        break;
                    case 5:
                        this.mov=3;
                        this.vida=50;
                        this.ataque=150;
                        this.alcA=6;
                        break;
                }
	}
	
	//Sets de la clase
	public void setValue(Comparable x){
		value=x;
	}
	public void setLeft(TreeNode l){
		left=l;
	}
	public void setRight(TreeNode r){
		right=r;
	}

	//gets de la clase
	public Comparable getValue(){
		return value;
	}

	public TreeNode getLeft(){
		return left;
	}

	public TreeNode getRight(){
		return right;
	}
	
	//RECORRIDO PREORDER:
	//Recorre primero la raiz, luego hi y luego hd.
	public void preOrder(){
		//Se imprime la raiz
		System.out.println(" Elemento "+value);
		//se recorre el hi
		if (left != null){
			left.preOrder();
		}
		//se recorre el hd
		if (right!=null){
			right.preOrder();
		}
	}
	//RECORRIDO INORDER
	//Recorre primero el hi, luego raiz, y finalmente hd.
	public void inOrder(){
		//se recorre el hi
		if (left!=null){
			left.inOrder();
		}
		System.out.println("Elemento "+value);
		//se recorre hd
		if (right!=null){
			right.inOrder();
		}
	}
	//RECORRIDO POSORDER:
	//Recorre el hi, hd y luego raiz
	public void posOrder(){
		//se recorre el hi
		if (left != null){
			left.posOrder();
		}
		//se recorre el hd
		if (right!=null){
			right.posOrder();
		}
		System.out.println("Elemento "+value);
	}

}