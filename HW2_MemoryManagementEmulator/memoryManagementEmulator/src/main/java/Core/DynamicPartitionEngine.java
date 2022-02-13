/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author Marco Tulio Work
 */
/*
    Esta clase representa al Sistema Operativo particularmente para este ejercicio "Gestion de Memoria utilizando Particion dinamica". 
    Es importante mencionar que la clase "OperativeSystem" se utiliza para encapsular todos los algoritmos relacionados al OS para todos
    los ejercicios (Fija, Dinamica, Colega, Fija distinta).
*/

public class DynamicPartitionEngine extends Partition{
    
    private OperativeSystem os;
    private MainMemory mainMemory;
    private LocalStorage localStorage;
    
    public DynamicPartitionEngine(){   
        this.os = new OperativeSystem();
        this.mainMemory = new MainMemory(1024);
        this.localStorage = new LocalStorage(10240);
    }
    
    public boolean addProcess(int processSize, String algorithm){
        return this.mainMemory.locateProcess(processSize, algorithm);
    }
    
    public boolean changeProcessMemory(int partitionNumber, String memoryLocation){
        if(memoryLocation.equals("toLocalStorage")){
            return this.mainMemory.swapProcess(partitionNumber, this.localStorage);
        }else{
            return this.localStorage.swapProcess(partitionNumber, this.mainMemory);
        }
        
    }
    
    public boolean compactMemory(String memory){
        if(memory.equals("MainMemory")){
            return this.mainMemory.compact();
        }else{
            return this.localStorage.compact();
        }
    }
    
    public MainMemory getMainMemory(){
        return this.mainMemory;
    }
    
    public LocalStorage getLocalStorage(){
        return this.localStorage;
    }
    
}
