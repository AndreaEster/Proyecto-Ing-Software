/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author Marco Tulio Work
 */
public class Node {
    
    /*
        Cada Nodo tendrá un atributo “proceso” el cual si está nulo dicho nodo es un hueco 
        y si está contenido por un objeto de tipo “Proceso” quiere decir que dicho nodo 
        se encuentra cubierto.
    */
    private int nodeSize;
    private Process item;
    private Node next;
    
    public Node(Process item, Node next, int nodeSize){
        this.item = item;
        this.next = next;
        this.nodeSize = nodeSize;
    }
    
    public Process getItem(){
        return this.item;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public void setItem( Process item ){
        this.item = item;
    }
    
    public void setNext( Node next ){
        this.next = next;
    }
}
