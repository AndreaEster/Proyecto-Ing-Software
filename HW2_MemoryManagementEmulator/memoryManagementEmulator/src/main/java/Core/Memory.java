/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author Marco Tulio Work
 */
public class Memory{
    
    Node first;
    private Node last;
    private int numElements;
    float memorySize;
    
    public Memory(int memorySize){
        this.memorySize = memorySize;
        this.first = new Node(null,null, this.memorySize);
        this.last = null;
        this.numElements = 1;
    }
    
    //Este metodo sera el encargado de decidir que algoritmo de colocacion usar y luego lo ejecutara.
    public boolean locateProcess(float size){
        Node partition = getFirstCanBeLocated(
                size,
                this.getFirst()
        );      
        if(partition != null){
            Node nextPartition = partition.getNext();
            Node newPartition = new Node(
                null,
                nextPartition,
                partition.getNodeSize()-size
            );          
            partition.setItem(new Process());
            partition.setNext(newPartition);
            partition.setNodeSize(size);
            this.setNumElements(numElements+1);
            return true;
        }else{
            return false;
        }       
    }
    
    /*
         Este metodo sera llamado unicamente si el algoritmo de colocacion seleccionado es el First-Fit.
        El metodo getFirstCanBeLocated recibe el primer nodo o particion que se encuentra en la MemoriaPrincipal
        junto al tamano del nuevo proceso que se quiere agregar. La finalidad de este metodo es la de retornar un nodo
        o particion apto en el cual se puede agregar el nuevo proceso.
    */
    public Node getFirstCanBeLocated(float size, Node partition){
        if(partition.getNodeSize()> size && partition.getItem() == null){
            return partition;
        }else{
            if(partition.getNext() != null){
                return getFirstCanBeLocated(size, partition.getNext());
            }else{
                return null;
            }
        }           
    }
    
    

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public float getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
    
    
}
