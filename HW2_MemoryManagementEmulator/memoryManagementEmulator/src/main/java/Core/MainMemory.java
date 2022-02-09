/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author Marco Tulio Work
 */

// La Memoria Principal será representada como una Lista Enlazada de Nodos.
//El tamaño de la Memoria Principal será definido al principio del programa por el usuario, sin embargo por defecto tendrá un tamaño de 1024 (MB).
public class MainMemory extends Memory{
    
     public MainMemory(int memorySize){
         super(memorySize);
     }
}
