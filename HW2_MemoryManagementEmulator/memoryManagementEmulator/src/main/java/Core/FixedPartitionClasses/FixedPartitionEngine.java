/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core.FixedPartitionClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Tulio Work
 */
public class FixedPartitionEngine {
    
    private List<Partition> MainMemory;
    
    public FixedPartitionEngine(){
        this.MainMemory = new ArrayList<>();
        
        this.MainMemory.add(new Partition(1, 2048, null));
        this.MainMemory.add(new Partition(2, 2048, null));
        this.MainMemory.add(new Partition(3, 2048, null));
        this.MainMemory.add(new Partition(4, 2048, null));
        this.MainMemory.add(new Partition(5, 2048, null));
        this.MainMemory.add(new Partition(6, 2048, null));
        this.MainMemory.add(new Partition(7, 2048, null));
        this.MainMemory.add(new Partition(8, 2048, null));
    }
    
    public boolean addProcess(int processSize){
        for (int i = 0; i < this.MainMemory.size(); i++) {
            if(this.MainMemory.get(i).getItem() == null){
                this.MainMemory.get(i).setItem(new Process(processSize));
                return true;
            }
        }
        return false;
    }

    public List<Partition> getMainMemory() {
        return MainMemory;
    }

    public void setMainMemory(List<Partition> MainMemory) {
        this.MainMemory = MainMemory;
    }
    
    
}
