/* 
* Project 2
 * CS231 Section B & Lab C 
 * File: Cell.java
 * Author: Zehra Gundogdu
 * Date: 2/17/22
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Cell {

    private boolean Living; //attribute of the Cell class, true if its alive, false if its dead
    private boolean Disease; //extension: attribute of the Cell class, true if it has virus, false if it hasn't
    

    public Cell(){ //by default the cell is dead and doesnt have virus
        Living = false;
        Disease = false;
    }

    public Cell(boolean alive){ //constructor that specifies Cell's state 
        if (alive){
            Living = true;
        } else {
            Living = false;
        }
    }

    public boolean getAlive(){ //getter method for the Cell's state 
        return Living;
    }
    public boolean getDisease(){ //getter method for the Cell's virus
        return Disease;
    }

    public void reset(){ //sets the cell to default state (dead)
        Living = false;
        Disease = false;
    }

    public void setAlive(boolean alive){ //setter method for the Cell's state
        Living = alive;
    }

    
    public void setDisease(boolean virus){ //extension: setter method for the Cell's state of virus
        Disease = virus;
    }

    public String toString(){ //overriding the string method so that it returns "0" if the Cell is alive, " " if its dead 
        if (Living == true){
            return "0";
        }else{
            return " ";
        }
    }

    public void draw(Graphics g, int x, int y, int scale){ //draws the Cell on the Graphics object at location x, y with the size scaled by scale.
        g.drawOval(x, y, 1, 1);
        if (Living && Disease){ //Extension: sets the color to red if the cell is both alive and infected
            g.setColor(Color.RED);
        } else { 
            if (Living){
                g.setColor(Color.green);
            }else{
                g.setColor(Color.DARK_GRAY);
            }
        }
        g.fillOval(x, y, scale, scale);

    }  
    
    public void updateState(ArrayList<Cell> neigbors){ //updates whether or not the cell is alive in the next time step, given its neighbors in the current step.
        int aliveNum = 0;

        for (Cell i : neigbors){
            if (i.getAlive()){
                aliveNum ++;
            } 
        }

        if (Living){
            if (aliveNum == 2 || aliveNum==3){
                Living = true;
            } else {
                Living = false;
            }
        } else {
            if (aliveNum ==3){
                Living = true;
            } else {
                Living = false;
            }
        }

    }

    //This is an extension. This method implements new conditions for updating the state of the Cell.
    //This method also accounts for the virus
    public void updateStateNewRules(ArrayList<Cell> neigbors){
        int aliveNum = 0;
        int diseaseNum = 0;

        for (Cell i : neigbors){
            if (i.getAlive()){
                aliveNum ++;
            } 
        }

        for (Cell i : neigbors){
            if (i.getDisease()){
                diseaseNum ++;
            } 
        }

        if (Living){
            if (aliveNum == 2 || aliveNum==3 || aliveNum ==4 ){
                Living = true;
            } else {
                Living = false;
            }
        } else {
            if (aliveNum ==3){
                Living = true;
            } else {
                Living = false;
            }
        }

        if (Disease){
            if (diseaseNum <= 1){
                Disease = false;
            } else if (diseaseNum > 5){
                Living = false;
            }else {
                Disease = true;
            }
        } else {
            if (diseaseNum > 2 && diseaseNum <= 5){
                Disease = true;
            } else if (diseaseNum > 5){
                Living = false;
            }else {
                Disease = false;
            }
        }

    }
    public static void main(String[] args){
        // Some tests that I ran to make sure the methods are running okay.

        Cell myCell = new Cell(true);
        System.out.println(myCell);
        System.out.println(myCell.getAlive());
        myCell.setAlive(false);
        System.out.println(myCell.getAlive());
        System.out.println(myCell);
    }

}
