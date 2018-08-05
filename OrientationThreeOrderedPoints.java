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

//Finds orientation of three ordered points: Clockwise, Anticlockwise, collinear

class Point{
    
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}

public class OrientationThreeOrderedPoints {
    
    // 0 for collinear, 1 for clockwise, 2 for anticlockwise
    public static int pointOrientation(Point p1, Point p2, Point p3){
        
        int value = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);
        
        if(value == 0)
            return 0;
        
        else
            return (value > 0)? 1 : 2;
        
    }
    
    public static void main(String[] args) {
        
        Point p1 = new Point(0,0), p2 = new Point(1,1), p3 = new Point(4,5);
              
        switch (pointOrientation(p1, p2, p3)) {
           
            case 0: System.out.println("Collinear Points");
                    break;
            
            case 1: System.out.println("Clockwise Orientation");
                    break;
            
            case 2: System.out.println("Anticlockwise Orientation");
                    break;
            
            default: System.out.println("Invlaid Points");
        
        }
        
    }
    
}