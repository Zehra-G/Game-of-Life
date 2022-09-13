/* 
* Project 2
 * CS231 Section B & Lab C 
 * File: LifeSimulation.java
 * Author: Zehra Gundogdu
 * Date: 2/20/22
 */

/* To run this simulation pass the following as command line arguments:
-Number of rows of the landscape
-Number of columns of the landscape
-Density of the initial board
-Number of iterations in the simulation

-Example: java LifeSimulation 100 100 0.3 100
*/

import java.util.Random;
import java.util.Scanner;

public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {

        //If there are not enough command line arguments, prints out a statement
        if (args.length < 4){
            System.out.println("Please enter the number of rows, columns, initial board density and the number of iterations.");
        
        } else {

            //asks the user which simulation they want to see, takes input and sets newRules to false if they prefer the original simulation
            boolean newRules;
            Scanner in = new Scanner(System.in);
            System.out.println("Do you want to see the disease simulation with new rules (Yes or No)?");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Yes")){
                newRules = true;
            } else {
                newRules = false;
            }

            //setting the variables to command line parameters
            int LandscapeSizeRow = Integer.parseInt(args[0]);
            int LandscapeSizecolumn = Integer.parseInt(args[1]);
            double density = Double.parseDouble(args[2]);
            int numIteration = Integer.parseInt(args[3]);

            Landscape scape = new Landscape(LandscapeSizeRow, LandscapeSizecolumn);
            Random gen = new Random();
    
            // initialize the grid to be full with living cells according to density
            for (int i = 0; i < scape.getRows(); i++) {
                for (int j = 0; j < scape.getCols(); j++ ) { 
                    scape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
                }
            }
        
            //sets some of the cells to virus infected randomly if newRules are chosen to be executed
            if (newRules){
                for (int i = 0; i < scape.getRows(); i++) {
                    for (int j = 0; j < scape.getCols(); j++ ) { 
                        Cell c = scape.getCell(i, j);
                    if (c.getAlive() && gen.nextBoolean()){
                        c.setDisease(true);
                    }
                    }
                }
            }

            LandscapeDisplay display = new LandscapeDisplay(scape, 10);
           
            //Using variable newRules that was set to true or false according to the user's answer to the question, runs the simulation with appropriate methods
            for (int i = 0; i < numIteration; i++){
                if (newRules){
                    scape.advanceNewRules();
                } else {
                    scape.advance();
                }
                
                display.repaint();
                Thread.sleep(250);
            }
    
        }
       
    }
}
