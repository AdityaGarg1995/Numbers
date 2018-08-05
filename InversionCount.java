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

// inversion count of array = how far is array from being sorted
// inversion count = 0 for sorted array

public class InversionCount {
   
   public static int naive(int array[]){
       int inversionCount = 0;
       
       for(int i = 0; i < array.length; i++){
           for(int j = (i + 1); j < array.length; j++){
               if(array[i] > array[j])
                   inversionCount++;
           }
       }
       
       return inversionCount;
   }
   
    // TC = O(n^3)
    public static int inversionCountSizeThreeNaive(int array[]){
        int inversionCount = 0;
        
        for(int i = 0; i < array.length; i++){
           
            for(int j = (i + 1); j < array.length; j++){
            
                if(array[i] > array[j]){
                
                    for(int k = (j + 1); k < array.length; k++)
                        if(array[j] > array[k])
                           inversionCount++;
                    
                }
           
            }
        
        }
        
        return inversionCount;
    }
       
    // TC = O(n^2)
    public static int inversionCountSizeThreeOptimised(int array[]){
       
        int inversionCount = 0, small = 0, great = 0;
        
        // Multiply no of elemnets smaller than a[i] & greater than a[i]
        // add the no to inversionCount
        
        for(int i = 1; i < array.length - 1; i++){
            
            for(int j = i + 1; j < array.length; j++)
                if (array[i] > array[j])  small++;
            
            for(int j = i - 1; j >= 0; j--)
                if (array[i] < array[j])  great++;
            
            inversionCount += great*small;    
        
        }
        
        return inversionCount;
    }
    
    public static void main(String[] args) {
        
        int array[] = {8,4,2,1};
        
        System.out.println(inversionCountSizeThreeOptimised(array));
        System.out.println(inversionCountSizeThreeNaive(array));
    
    }
}