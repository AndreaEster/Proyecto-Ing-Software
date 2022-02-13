/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Tulio Work
 */
public class Memory{
    
    Node first;
    private Node lastPlacement;
    private int numElements;
    float memorySize;
    
    public Memory(int memorySize){
        this.memorySize = memorySize;
        this.first = new Node(null,null, this.memorySize);
        this.lastPlacement = null;
        this.numElements = 1;
    }
    
    //Este metodo sera el encargado de decidir que algoritmo de colocacion usar y luego lo ejecutara.
    public boolean locateProcess(float size, String algorithm){
        Node partition;
        if(algorithm.equals("First-fit")){
            partition = getFirstCanBeLocated(
                    size,
                    this.getFirst()
            ); 
        }else{
            if(algorithm.equals("Best-fit")){
                partition = getBestCanBeLocated(
                        size,
                        this.getFirst(),
                        null
                ); 
            }else{
                partition = getFirstCanBeLocated(
                    size,
                    this.getLastPlacement()
            );
            }
        }
             
        if(partition != null){
            if(partition.getNodeSize() != size){
                Node nextPartition = partition.getNext();
                Node newPartition = new Node(
                    null,
                    nextPartition,
                    partition.getNodeSize()-size
                );
                newPartition.setPrevious(partition);
                partition.setItem(new Process());
                partition.setNext(newPartition);
                partition.setNodeSize(size);
                this.setLastPlacement(partition);
                this.setNumElements(numElements+1);
                return true;
            }else{
                partition.setItem(new Process());
                partition.setNodeSize(size);
                this.setNumElements(numElements+1);
                this.setLastPlacement(partition);
                return true;
            }
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
        if(partition.getNodeSize() >= size && partition.getItem() == null){
            return partition;
        }else{
            if(partition.getNext() != null){
                return getFirstCanBeLocated(size, partition.getNext());
            }else{
                return null;
            }
        }           
    }
    
    public Node getBestCanBeLocated(float size, Node partition, Node best){
        if(best == null){
            if(partition.getNext() == null){
                if(partition.getNodeSize() >= size && partition.getItem() == null){
                    return partition;
                }else{
                    return null;
                } 
            }else{
                if(partition.getNodeSize() >= size && partition.getItem() == null){
                    best = partition;
                }
                return this.getBestCanBeLocated(size, partition.getNext(), best);
            }
            
            
        }else{
            if(partition.getNext() == null){
                if(partition.getNodeSize() >= size && partition.getItem() == null && partition.getNodeSize() < best.getNodeSize()){
                    best = partition;
                }
                return best;
            }else{
                if(partition.getNodeSize() >= size && partition.getItem() == null && partition.getNodeSize() < best.getNodeSize()){
                    best = partition;
                }
                return this.getBestCanBeLocated(size, partition.getNext(), best);
            }
        }          
    }
    
    public boolean swapProcess(int partitionNumber, Memory destinatedMemory){
        Node partition = this.getPartitionByNumber(partitionNumber, this.first, 0);
        
        if(partition.getItem() == null){
            return false;
        }else{
            float size = partition.getNodeSize();
            destinatedMemory.locateProcess(size, "First-fit");
            partition.setItem(null);
            return true;
        }
    }
    
    public Node getPartitionByNumber(int partitionNumber, Node partition, int location){
        if((partitionNumber-1) == location){
            return partition;
        }else{
            return getPartitionByNumber(partitionNumber, partition.getNext(), location+1);
        }
    }
    
    public boolean compact(){
        List<Node> holes = new ArrayList<>();
        this.innerCompact(this.first, holes);
        return true;
    }
    
    public void innerCompact(Node partition, List<Node> holes){
        
        
        Node previousPartition = partition.getPrevious();
        Node nextPartition = partition.getNext();
        
        
        if(partition.getNext() == null){
            if(partition.getItem() == null){
                holes.add(partition);
                Node hole = this.mergeHoles(holes);
                if(previousPartition == null){
                    this.getLastPartitionWithProcess(this.first).setNext(hole);
                }else{
                    previousPartition.setNext(hole);
                }
            }else{
                Node hole = this.mergeHoles(holes);
                partition.setNext(hole);
            }
        }else{
            if(partition.getItem() == null){  
                if(previousPartition == null){
                    nextPartition.setPrevious(null);
                    this.first = nextPartition;
                }else{
                    previousPartition.setNext(nextPartition);
                    nextPartition.setPrevious(previousPartition);
                }

                holes.add(partition);
            }
            innerCompact(partition.getNext(), holes);
        }
    }
    
    public Node mergeHoles(List<Node> holes){
        float nodeSize = 0;
        for (int i = 0; i < holes.size(); i++) {
            nodeSize = nodeSize + holes.get(i).getNodeSize();
        }
        return new Node(null, null, nodeSize);
    }
    
    public Node getLastPartitionWithProcess(Node partition){
        if(partition.getNext().getItem() == null){
            return partition;
        }else{
            return this.getLastPartitionWithProcess(partition.getNext());
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLastPlacement() {
        return lastPlacement;
    }

    public void setLastPlacement(Node last) {
        this.lastPlacement = last;
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
