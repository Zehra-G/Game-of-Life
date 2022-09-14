# Conway's Game-of-Life & Simulation of Virus Spread

## Project Description
- In this project, I simulated [Conways’s Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) and made a visualization of it using the Java Swing graphical user interface. According to the rules of the game, the alive cells die if they don’t have either two or three living neighbors, and dead cells are set alive if they have exactly three living neighbors. In the simulation, the living cells are represented in green and the dead ones are grey. I used the Cell class to represent the locations on the Landscape -which was an array of arrays to hold the Cell object references (a 2D grid of cells). The visual representations were made using Java Swing. The LifeSimulation class was modeled after the LandscapeDisplay class that was provided to me by Colby College CS Department. I created a Landscape object scape of desired numbers of rows & columns, populated it with a certain density of alive cells, and created a LandscapeDisplay object of display. In the simulation, there is a 250-millisecond pause between every generation so that the change is observable. 

## Second Version of the Simulation: The Spread of Disease
- I also designed a different scenario than Conway’s Game of Life to simulate the spread of disease and extinction of a more enduring cell population. To create this scenario, I added a boolean attribute “Disease” to my Cell class. It is true if the cell is infected with a virus and false if it is not. By default, it was set to false. 
- Dead cells can also carry the virus but will stay hidden (grey) because only alive and infected cells show up as red. The draw method was modified so that it represents the cells red only if they are alive and infected. This didn’t change my original Conway’s simulation, because all of the cells are set to healthy by default.
- In the new rules that I designed, the cells are stronger, meaning that they are more enduring of overpopulation (the number of alive neighboring cells can go up to four for a cell to remain alive). This method also accounts for the disease, an infected cell heals if only 0 or 1 of its neighbors are infected, it dies if over 5 neighboring cells are infected (and the virus stays, so even if it is set alive by the population it is going to be both infected and alive). A healthy cell gets infected if between 2 and 5 of its neighbors are infected, it dies and carries the virus if over 5 of the neighbors are infected, and stay healthy if less than or equal to 2 neighbors are infected.

## How To Run 
- The user can determine the number of rows and columns in the landscape, the cell density of the initial board, and the number of iterations that they want the simulation to continue for using the terminal. These parameters are passed in from the command line. 
- Specify the number of rows, columns, the cell density, and the iteration number when running LifeSimulation.java
- A question asking whether the user wants to incorporate the new rules in the simulation will be printed out on the terminal, answer "No" to see Conway's Game of Life and "Yes" to see the second version of the simulation incoroprating a virus spreading. 

### [Here is a video of the second version of the simulation](https://user-images.githubusercontent.com/113384943/190224101-f243cbb1-ddab-4806-8e63-99706c1658e1.mov)

### Images from both versions of the simulation:
<p align = "center">
<img width="1010" alt="Screen Shot 2022-09-14 at 13 40 19" src="https://user-images.githubusercontent.com/113384943/190251111-177ead96-8b5e-4746-b030-eb187c472653.png">
</p>
<p align = "center">
Screenshot from Conway's Game of Life
</p>
<p align = "center">
<img width="990" alt="Screen Shot 2022-09-14 at 13 39 58" src="https://user-images.githubusercontent.com/113384943/190251130-60fb232b-4c04-4a34-b1b2-e49506f75f34.png">
</p>
<p align = "center">
Screenshot from the second version incorporating the spread of virus
</p>

## Sources & Imported Libraries
- Java Swing
- Java Graphics 
- W3schools.com

## Acknowledgements
- Prof. Allen Harper, Colby College Computer Science Department 
- Prof. Naser Al Madi, Colby College Computer Science Department 
- [Great example for README](https://github.com/nalmadi/EMIP-Toolkit)





