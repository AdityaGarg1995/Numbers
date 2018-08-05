/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numbers;

/**
 *
 * @author Aditya Garg
 */

// if (x^2) % p = n(>2) 
// then x is called square root of n under modulo p
// n <= x < p

public class SquareRootUnderModuloP {
    
    
    public static void printRoot(int n, int p, int x){
        System.out.println("Square root of " + n + " under modulo " + p + " = " + x);
    }
    
    public static void naive(int n, int p){
        
        boolean squareRootExists = false;
        n %= p;
        
        for(int x = 2; x < p; x++)
            if(((x*x) % p) == n){
                printRoot(n, p, x);
                squareRootExists = true;
            }
       
        if (!squareRootExists)
            System.out.println("Square doesnt exist");
       
    }
    
    // if p = 3i + 4; i >= 1
    // then square root = n^((p+1)/4)    
    
    public static void squareRootUnderModuloP(int n, int p){
        
        boolean validInput = false;
        
        for(int i = 1; i < p; i++)
            if(p == (3*i + 4))
                validInput = true;
                
        if(validInput){
            
            n %= p;

            int x = (int)Math.pow(n, (p + 1)/4) % p;

            // try ' +n^(p+1)/4 '
            if (((x*x) % p) == n)  
               printRoot(n, p, x);
            
            // try ' -n^(p+1)/4 '
            x = (p - x);
            if (((x*x) % p) == n)  
                printRoot(n, p, x);
            
            else  System.out.println("Square doesnt exist");
        }
        
        else System.err.println("Invalid Input");
        
    }
    
    public static void main(String[] args) {
        //naive(2,7);
        squareRootUnderModuloP(2, 7);
    }
    
}