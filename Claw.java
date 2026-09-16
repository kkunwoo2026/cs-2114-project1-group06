// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kunwoo Kim (kkunwoo)

// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Creating a claw class that allows users to move claw along the coordinates.
 * @author Kunwoo Kim, Armaan Ali, Jonathan Elliott
 * @version 2026.09.14 
 */
public class Claw extends Main {
    //~ Fields ................................................................
    private int x;
    private int y;
    
    Scanner sc = new Scanner(System.in);
    //~ Constructors ..........................................................
    /**
     * When claw is generated, it starts at the coordinate (0,0).
     */
    public Claw() {
        x = 0;
        y = 0;
    }
    //~Public  Methods ........................................................
    /**
     * A getter method for x.
     * @return returns the current x coordinate
     */
    public int getX() {
        return x;
    }
    /**
     * A setter method for x.
     * @param x = A new value to set for x.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * A getter method for y.
     * @return returns the current y coordinate.
     */
    public int getY() {
        return y;
    }
    /**
     * A setter method for y.
     * @param y = A new value to set for y.
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Every time the user gets the prize, the claw is sent back to (0,0).
     */
    public void reset() {
        x = 0;
        y = 0;
    }
    /**
     * A method that prints the user the current location of claw. 
     */
    public void location() {
        System.out.println("The current location: (" + x + ", "+ y + ")");
    }
    public void trial() {
        //Method Stub
    }
    //public boolean hasPrize(List<Prize> prizes) {
        //boolean result = false;
        //for (Prize prize : prizes) {
            //if (x == prize.getXCoord() && y == prize.getYCoord()) {
                //result = true;
            //}
        //}
        //return result;
    //}
    
    /**
     * A method that moves the claw with the input made by the user.
     * An error will be thrown if the user tries to go out of bound.
     * After each trial, it will print the current location of claw.
     * @param input This will be what the user inputs to move the claw through scanner. 
     */
    public void move(String input) {
        switch (input) {
            case "w":
                if (y >= 4) {
                    System.out.println("You are going out of grid. Invalid input");
                }
                else {
                    y += 1;
                }
                location();
                break;      
            case "a":
                if (x <= 0) {
                    System.out.println("You are going out of grid. Invalid input");
                }
                else {
                    x -= 1;
                }
                location();
                break;
            case "s":
                if (y <= 0) {
                    System.out.println("You are going out of grid. Invalid input");
                }
                else {
                    y -= 1;
                }
                location();
                break;
            case "d":
                if (x >= 4) {
                    System.out.println("You are going out of grid. Invalid input");
                }
                else {
                    x += 1;
                }
                location();
                break;
            case " ":
                //if (!hasPrize()) {
                    //System.out.print("Miss!");
                    reset();
                    location();
                //}
                //else {
                    //System.out.println("Hit in claw");
                    //trial();
                    //reset();
                    //location();
                //}
                break;
            default:
                System.out.println("Invalid input. WASD to move the claw and space bar to give it a try!");
        }
    }
    
}
