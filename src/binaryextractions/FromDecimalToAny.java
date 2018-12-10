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
public class FromDecimalToAny {
    protected String num;
    protected int desiredBase;
    
    public FromDecimalToAny(int desiredBase,String num){
        this.num=num;
        this.desiredBase=desiredBase;
    }
    
    public FromDecimalToAny(){
         Scanner input=new Scanner(System.in);
         System.out.print("Enter A Number: ");
         num=Double.toString(input.nextDouble());
         System.out.print("Enter A Desired Base: ");
         desiredBase=input.nextInt();
     }
    
    protected String[] decimalPartProcessing(String num){
            String ex=num;
            int length=ex.length();
            ex="0."+ex;
            int i=0;
            String[] dot_answer=new String[length];
            while(i<length){
                double ans=Double.parseDouble(ex)*this.desiredBase;
                String[] temp=Double.toString(ans).split("\\.");
                dot_answer[i]=changeNumberToDesiredAlphabet(Integer.parseInt(temp[0]));
                ex="0."+temp[1];
                i++;
            }
            
            return dot_answer;
    }
    
    protected static String changeNumberToDesiredAlphabet(double num){
        String alphabet="";
        if(num==10){
            alphabet="A";
        }else if(num==11){
            alphabet="B";
        }else if(num==12){
            alphabet="C";
        }else if(num==13){
            alphabet="D";
        }else if(num==14){
            alphabet="E";
        }else if(num==15){
            alphabet="F";
        }else{
            alphabet=String.valueOf((int)num);
        }
        return alphabet;
    }
    
    protected String[] wholeNumberPartProcessing(String num){
        int divisor=100;
        String p="";
        while(divisor!=0){
            divisor= Integer.parseInt(num)/desiredBase;
            p+=Integer.parseInt(num)%desiredBase+",";
            num=Integer.toString(divisor);
        }
        p=p.substring(0, p.lastIndexOf(","));
        String[] ans=p.split(",");
        String[] result=new String[ans.length];
        for(int i=ans.length-1,j=0;i>=0;i--,j++){
            result[j]=changeNumberToDesiredAlphabet(Integer.parseInt(ans[i]));
        }
        return result;
    }
    
    public String convert(){
        String processor=num;
        String[] number={processor};
        String result;
        if(processor.contains(".")){
           number=processor.split("\\.");
           result=arrayToString(wholeNumberPartProcessing(number[0]))+"."+arrayToString(decimalPartProcessing(number[1]));
        }else{
            result=arrayToString(wholeNumberPartProcessing(number[0]));
        }
        return result;
    }
    
    protected String arrayToString(String[] num){
        String result="";
        for(int i=0; i<num.length;i++){
            result+=num[i];
        }
        return result;
    }
    
    
}
//vicksemmanuel58@gmail.com
//https://kodebottle.com
