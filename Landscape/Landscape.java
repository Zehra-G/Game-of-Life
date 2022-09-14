/* 
* Project 2
 * CS231 Section B & Lab C 
 * File: Landscape.java
 * Author: Zehra Gundogdu
 * Date: 2/17/22
 */


import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
    private Cell[][] Landscape; //field to hold the array of Cell object references
    private int Rows; //field to hold the number of rows
    private int Columns; //field to hold the number of columns

    public Landscape(int rows, int cols){ /* sets the number of rows and columns to row, col 
        and allocates the grid of Cell references, allocates a cell for each grid location */
        Rows = rows;
        Columns = cols;
        Landscape = new Cell[Rows][Columns];
        
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                Cell newCell = new Cell();
                Landscape[i][a] = newCell;
            }
        }
    }

    public void reset(){ //calls the reset method of every cell in th grid, which sets them to dead
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                Landscape[i][a].reset();
            }
        }
    }

    public int getRows(){ //getter method for the number of rows in the grid
        return Rows;
    }

    public int getCols(){ //getter method for the number of columns in the grid
        return Columns;
    }

    public Cell getCell(int row, int col){ //getter method for the cell at posiyion (row, col)
        return Landscape[row][col];
    }

    public String toString(){ //toString method returning a String representation of the landscape
        String land = "";
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                land += Landscape[i][a].toString();
            }
            land += "\n";
        }
        return land;
    }

    public ArrayList<Cell> getNeighbors(int row, int col){ //this method creates an arraylist and adds the neigbors of the cell at position(row, col) to the list

        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        for (int i = row - 1; i < row + 2; i++){
            for (int a = col - 1; a < col + 2; a++){
                if (i >= 0 && i <= Rows - 1 && a >= 0 && a <= Columns - 1){
                    if (getCell(i,a) != getCell(row,col)){
                        neighbors.add(getCell(i, a));
                    }
                }
            }
        }
        return neighbors;
    }

    public void draw(Graphics g, int gridScale){ //draw method for the landscape -loops through all the cells in grid, calls their draw method
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                Landscape[i][a].draw(g, i*gridScale, a*gridScale, gridScale);
            }
        }
    }


    public void advance(){ //updates whether or not the cell is alive in the next time step, given its neighbors in the current time step.
        Cell[][] newLs = new Cell[Rows][Columns];
    
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                Cell newCell = new Cell(Landscape[i][a].getAlive());
                newLs[i][a] = newCell;
            }
        }

        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
  
                newLs[i][a].updateState(getNeighbors(i, a));
                
            }
        }

        Landscape = newLs;
    }

    public void advanceNewRules(){ //advance method working according to the new rules defined in Cell
        Cell[][] newLs = new Cell[Rows][Columns];
    
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
                Cell newCell = new Cell(Landscape[i][a].getAlive());
                newLs[i][a] = newCell;
            }
        }

        //This method calls updateStateNewRules() instead of updateState()
        for (int i=0; i < Rows; i++){
            for (int a = 0; a< Columns; a++){
            
                newLs[i][a].updateStateNewRules(getNeighbors(i, a));
                 
            }
        }

        Landscape = newLs;
    }

    public static void main(String[] args){
        // Some tests that I ran to make sure the methods are running okay.
        
        Landscape land = new Landscape(20, 20);
        System.out.println(land);
        System.out.println(land.getNeighbors(19,19));

    }


}
