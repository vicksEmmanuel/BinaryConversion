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
public class FromABaseToAnotherBase{
    
   private int desiredBase,currentBase;
   private String num;
   public FromABaseToAnotherBase(int desiredBase,int currentBase,String num){
       this.desiredBase=desiredBase;
       this.currentBase=currentBase;
       restriction(num);
   }
   public FromABaseToAnotherBase(){
         Scanner input=new Scanner(System.in);
         System.out.print("Enter Current Base: ");
         currentBase=input.nextInt();
         System.out.print("Enter Desired Base: ");
         desiredBase=input.nextInt();
         System.out.print("Enter A Number: ");
         String x=new Scanner(System.in).nextLine();
         restriction(x);
         
    }
   private void restriction(String num){
       String check=num;
       int i=0;
           while(i<check.length()){
               String x=changeAlphabetToDesiredNumber(String.valueOf(check.charAt(i)));
               if(!x.equals(".")){
                   if(Integer.parseInt(x)>currentBase){
                       throw new RuntimeException("No input should be greater than its base");
                   }
               }
                i++;
           }
           this.num=num;
   }
   
   private String convertedToBaseTen(){
       //Incomplete Method
       return wholeNumberConversion(num);
   }
   
   private String changeAlphabetToDesiredNumber(String alpha){
       String temp="";
       if(alpha.equalsIgnoreCase("F")){
            temp="15";
        }else if(alpha.equalsIgnoreCase("E")){
            temp="14";
        }else if(alpha.equalsIgnoreCase("D")){
            temp="13";
        }else if(alpha.equalsIgnoreCase("C")){
            temp="12";
        }else if(alpha.equalsIgnoreCase("B")){
            temp="11";
        }else if(alpha.equalsIgnoreCase("A")){
            temp="10";
        }else{
            temp=alpha;
        }
       return temp;
   }
   
   private String wholeNumberConversion(String num){
       int sum=0;
       String[] temp=new String[num.length()];
       for(int i=0;i<temp.length;i++){
            temp[i]=changeAlphabetToDesiredNumber(Character.toString(num.charAt(i)));
        }
       
       for(int i=0,j=temp.length-1;i<temp.length;i++,j--){
            sum+=Integer.parseInt(temp[i])*Math.pow(currentBase, j);
        }
       return Integer.toString(sum);
   }
   
   public String convert(){
       String result="";
       if(desiredBase==10){
           result=convertedToBaseTen();
       }else{
           FromDecimalToAny fromDecimalToAny=new FromDecimalToAny(desiredBase,convertedToBaseTen());
           result=fromDecimalToAny.convert();
       }
       return result;
   }
   
}
