/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numbers;

import java.util.Scanner;

/**
 * @author Aditya Garg
 */

public class BinaryDecimalConversion {
    
 
   static String d2b = "Decimal to Binary: ",
                 b2d = "Binary to Decimal:",
                 d2h = "Decimal to Hexadecimal: ",
                 h2d = "Hexadecimal to Decimal",
                 d2o = "Decimal to Octal: ",
                 o2d = "Octal to Decimal",
                 recovery = "Recovery: ";

   
    public static void BinaryToDecimal(int binary){
       
        int decimal = 0, p = 0;
        
        while(binary != 0){
            decimal += ((binary % 10) * Math.pow(2,p));
            binary /= 10;
            p++;
        }
        System.out.println(b2d + decimal + " ");
    }
    
   
    public static void DecimalToBinary(int decimal){
        
        String remainder = (decimal % 2) + "";
        int quotient = decimal/2;
        
        while(quotient > 0){
            remainder = Integer.toString(quotient % 2) + remainder;
            quotient /= 2;
        }
        System.out.println(d2b + remainder + " ");
    }
    
 
    
    public static void main(String[] args) {
                
        BinaryToDecimal(10011100);
        
        // Decimal to Binary
        DecimalToBinary(156);
        System.out.print(d2b + Integer.toString(156, 2) + " ");
        System.out.println(d2b + Integer.toBinaryString(156) + " ");
        
        // Decimal to base 6
        System.out.print("Decimal to base 6: " + Integer.toString(156, 6) + " ");
        // Recovery
        System.out.println(recovery + Integer.parseInt("420", 6) + " ");
        
        // Decimal to Hexadecimal
        System.out.print(d2h + Integer.toString(156, 16) + " ");
        System.out.print(d2h + Integer.toHexString(156) + " ");
        // Recovery
        System.out.println(recovery + h2d + Integer.parseUnsignedInt("9c", 16) + " ");
        
        // Decimal to Octal
        System.out.print(d2o + Integer.toString(15, 8) + " ");
        System.out.println(d2o + Integer.toOctalString(15) + " ");
        // Recovery
        System.out.println(recovery + o2d + Integer.parseInt("17", 8));
    }
}