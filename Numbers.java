/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numbers;

import fundamentals.Recursion;
import java.util.Random;

/**
 *
 * @author Aditya Garg
 */

public class Numbers {
   
    public static int reverseNumber(int n){
        boolean isNegative = false;
        if(n < 0){
            isNegative = true;
            n *= -1;
        }
        
        int reverseNum = 0;
        while(n > 0){
            int lastDigit = n%10;
            reverseNum = reverseNum*10 + lastDigit;
            n /= 10;
        }
        
        if(isNegative)
            reverseNum *= -1;
        
//        System.out.println("Original Number: " +  n + "\n Reversed Number: " + reverseNum);
        return reverseNum;
    }

    /* Adam Number:
       A number is an Adam Number if its square and sqaure of its reverse are reverse of each other.
    */
    
    public static void AdamNumber(int start, int end){
        for (int i = start; i < end; i++) {
            
            int n            = i, 
                rn           = reverseNumber(n),
                sqrN         = n*n,
                sqrRN        = rn*rn,
                reverseSqrRN = reverseNumber(sqrRN);
            
            if(n == rn) continue;
            
            if(reverseSqrRN == sqrN) System.out.println(n); 
        }
    }
    
    
    public static int power(int n){ return (int)Math.pow(2, n); }
    public static int power(int m, int n){ return (int)Math.pow(m, n); }
    
    
    public static int ProthNumber(int n, int k){ return (k * power(n) + 1); }
    
    public static int CullenNumber(int n){ return (n * power(n) + 1); }
    
    public static int FermatNumber(int n){ return power(power(n)) + 1; }
    
    public static int WoodallNumber(int n){ return (n * power(n) - 1); }
    
   
    public static void generateRandomNumber(){
        for(int i = 0; i < 5; i++)
            System.out.println("Random Number1: " + (int)(Math.random()*10));
    }
    public static void generateRandomNumber2(){
        Random random = new Random();
        for(int i = 0; i < 5; i++)
            System.out.println("Random Number2: " + random.nextInt(10));
    }
    
    
//    Check if number is a power of 2
    public static boolean isPowerOf2(int n){
        if (n == 0)  
            return true;
        
        while(n != 1){
            if (n%2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }
    
    
    public static boolean CarmichaelNumber(int n){
        for (int i = 2; i < n; i++) {
            if(Recursion.gcdEuclid(i, n) == 1){
                if(power(i, n-1)%n != 1)
                    return false;
            }
        }
        return true;
    }
    
    
/*    Aliquot Sequence/Numbers:  Sequence of Numbers each being sum of divisors of previous,
      excluding the numbers as divisors themselves */

    public static int divisorSum(int n){
        int sumOfDivisors = 0;
        for(int i = 1; i < Math.sqrt(n); i++)
            if(n%i == 0)
                sumOfDivisors += i;
        return sumOfDivisors;
    }
    
    
//    Perefct Number: A number which is sum of its divisors --- Only applicable to +ve integers 
    public static boolean isPerfectNumber(int n){
        if (n <= 0) return false;
        return (divisorSum(n) == n);
    }    
    public static boolean isSuperPerfect(int n){
        if (n <= 0) return false;
        return (divisorSum(divisorSum(n)) == 2*n);
    }
    public static void MultiperfectNumber(int n){
        int k = n / divisorSum(n);
        switch(k){
            case 1:
                System.out.println("The number is Perfect Number");
                break;
            case 2:
                System.out.println("The number is SuperPerfect Number");
                break;
            default: 
                System.out.println("The number is MultiPerfect Number" + "\n" +
                                   "It is " + k + " Fold");
        }
    }
    
//    Amicable Numbers: Pairs which are sum of divisors of each other, excluding the numbers as divisors themselves
    public static boolean AmicableNumbers(int m, int n){
        if(n <= 0 || m <= 0) return false;
        return (divisorSum(m) == n && divisorSum(n) == m);
    }

    
//    Alquot Sequence    
    public static void printAlquotSequence(int n){
        if(n <= 1)  return;
        
        int divisor = divisorSum(n);
        
        System.out.print(divisor + ", ");
        while(divisor > 0){
            System.out.print(divisor + ", ");
            divisor = divisorSum(divisor);
        }
        System.out.println(divisor);
    }
    
    
    
/*    Armstrong number: Number equal to sum of its digits raisd to power number of digits */
    public static int numOfDigits(int n){
        if(n < 0)
           return Integer.toString(n*-1).length();
        else 
            return Integer.toString(n).length();
    }
    public static boolean isArmstrongNumber(int n){
        if (n < 0) return false;  /* As not possible for negative numbers */
        else if(numOfDigits(n) == 1) return true;
        
        int sum       = 0, 
            numDigits = numOfDigits(n),
            temp      = n;
        while(temp > 0){
            int d = temp%10;
            sum += power(d, numDigits);
            temp /= 10;
        }
        return (sum == n);
    }
    
    
//  given a number, find number of numbers greater than that number formed by digits of that number
    public static boolean isSortedReverse(int a[]){
        boolean sorted = false;
        
        for (int i = 1; i < a.length; i++) {
            if(a[i] > a[i-1])
                sorted = true;
            else break;
        }
        return sorted;
    }
    
    public static int numbersGreaterThanGivenNumber(String s){
        int numbers[] = new int[s.length()];
        
        if(s.length() == 0 || s.length() == 1)
            return 0;
        else
            for (int i = 0; i < s.length(); i++) 
                numbers[i] = Integer.parseInt(s.charAt(i) + "");
        
        // if number sorted in reverse order
        if(isSortedReverse(numbers))
            return 0;
        
        int countOfNumbers = 0;
        
        
        
        return countOfNumbers;
    }
    
    public static void main(String[] args) {
        
//        System.out.println(ProthNumber(2, 3) + "\n" + 
//                           CullenNumber(2) + "\n" + 
//                           FermatNumber(2) + "\n" +
//                           WoodallNumber(2));
//        
//        generateRandomNumber();
//        generateRandomNumber2();
        
//        AdamNumber(0, 100);
//        System.out.println(isPerfectNumber(28));
//        System.out.println(AmicableNumbers(220, 284));
//        System.out.println(isArmstrongNumber(153));

    }
}