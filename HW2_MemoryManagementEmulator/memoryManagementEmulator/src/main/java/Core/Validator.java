/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author Marco Tulio Work
 */
public class Validator {
 
    public static String validateDinamycProcessSize(int size, int memorySize){
        if(size > 0 && size<memorySize){
            return "valid";
        }else{
            return "El tamano especificado es menor a cero o excede el limite de memoria";
        }
    }
}