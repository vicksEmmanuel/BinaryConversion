/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryextractions;

import java.util.Scanner;

/**
 *
 * @author vicksemmanuel
 */
public class BinaryExtractions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //FromDecimalToAny fromDecimalToAny=new FromDecimalToAny();
        //System.out.println(fromDecimalToAny.convert());
        FromABaseToAnotherBase fromABaseToAnotherBase=new FromABaseToAnotherBase();
        System.out.println(fromABaseToAnotherBase.convert());
    }
    
}
