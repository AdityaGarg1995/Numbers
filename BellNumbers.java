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

public class BellNumbers {
    
    // Bell Numbers can be used to find number of possible subsets of given set
    public static int BellNumber(int n){

        int bell[][] = new int[n+1][n+1];
        bell[0][0] = 1;
      
        for(int i = 1; i <= n; i++){
          
            bell[i][0] = bell[i-1][i-1];
         
            for(int j = 1; j <= i; j++)
                bell[i][j] = (bell[i-1][j-1] + bell[i][j-1]); 
          
        }
      
        return bell[n][0];
      
    }
    
    public static int subsetNumber(int set[]){
        return BellNumber(set.length);
    }
    
    public static void main(String[] args) {
        
        for(int i = 0; i <= 7; i++ )
            System.out.println("Bell Number " + i + " is " + BellNumber(i));
               
        int set[] = {1,2,3,4};
        System.out.println("Number of posssible partitions is: " +  subsetNumber(set));         
        
    }
}