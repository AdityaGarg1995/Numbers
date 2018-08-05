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
public class SortedArrayPair {

    // Check if sorted array can be divided into pairs each with sum k
    
    public static boolean pairChecker(int array[], int n, int k){
        
        if (n%2 != 0)  return false;
        
        int l = 0,
            r = (n-1);
        
        while(l < r){
            
            if((array[l] + array[r]) != k)  
                return false;
            
            l++;
            r--;
            
        }
        return true;
    }
    
    
    public static void main(String[] args) {
    
        int array[] = {1,3,3,5};
        System.out.println(pairChecker(array, array.length, 6));
        
    }
    
}