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

// Longest span with same sum in 2 Binary Arrays

public class LongestSpanSameSum {
    
    /*
    
    Observation:
    
    1. Total n elements => max sum = n for both arrays

    2. Difference between 2 sums between -n & n => 2n + 1 possible values
    
    3. If difference between prefix sums of 2 arrays becomes same at 2 pints => 
       subarrays between these 2 points have same sum
    
    */
    
        
    public static int spanSum(int array1[], int array2[]){

        int n          = array1.length,
            sumArray[] = new int[2*n + 1],
            maxLen     = 0,
            preSum1    = 0,
            preSum2    = 0;
      
        for(int i = 0; i < 2*n + 1; i++)
            sumArray[i] = -1;
        
        for(int i = 0; i < n; i++){
            
            preSum1 += array1[i];
            preSum2 += array2[i];
            
            int currentDiffference = (preSum1 - preSum2),
                differenceIndex    = (n + currentDiffference);
        
            if (currentDiffference == 0)  
                maxLen = (i + 1);

            else if (sumArray[differenceIndex] == -1)
                sumArray[differenceIndex] = i;
            
            else{
                int len = (i - sumArray[differenceIndex]);
            
                if (len > maxLen)
                    maxLen = len;
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        
        int array1[] = {0,1,0,1,1,1,1},
            array2[] = {1,1,1,1,1,0,1};
        
        System.out.println("" + spanSum(array1, array2));
        
    }
}