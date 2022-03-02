/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core.FixedPartitionClasses;

/**
 *
 * @author Marco Tulio Work
 */
public class Partition {
    
    private int identifier;
    private float nodeSize;
    private Process item;

    public Partition(int identifier, float nodeSize, Process item) {
        this.identifier = identifier;
        this.nodeSize = nodeSize;
        this.item = item;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public float getNodeSize() {
        return nodeSize;
    }

    public void setNodeSize(float nodeSize) {
        this.nodeSize = nodeSize;
    }

    public Process getItem() {
        return item;
    }

    public void setItem(Process item) {
        this.item = item;
    }
    
    
}
