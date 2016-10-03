import java.util.ArrayList;
import java.util.Arrays;

//Thomas den Boer, Thomas Willems
//30-9-2016
//This program solves a Sudoku
class Sudoku {
    private static final int SIZE = 9;     // size of the grid e.g. 9 -> 9x9
    private static final int DMAX = 9;     // max digit to be filled in e.g. 9
    private static final int BOXSIZE = 3;  // size of the boxes e.g. 3 -> 3x3
    //Comment to the assignment maker: Why isn't SIZE defined as grid.length and DMAX as size?
    int[][] grid = new int[][] {
            { 0, 6, 0,  0, 0, 1,  0, 9, 4 },
            { 3, 0, 0,  0, 0, 7,  1, 0, 0 },
            { 0, 0, 0,  0, 9, 0,  0, 0, 0 },
            { 7, 0, 6,  5, 0, 0,  2, 0, 9 },
            { 0, 3, 0,  0, 2, 0,  0, 6, 0 },
            { 9, 0, 2,  0, 0, 6,  3, 0, 1 },
            { 0, 0, 0,  0, 5, 0,  0, 0, 0 },
            { 0, 0, 7,  3, 0, 0,  0, 0, 2 },
            { 4, 1, 0,  7, 0, 0,  0, 8, 0 },
    };

    int solutionnr = 0; //solution counter
    int[] nextEmpty;
    int[][] solution = new int[SIZE][SIZE];
    
    void run() {
        //TODO starts the solving process.
        solve();
        printSltn();
        //END TODO
    }

    boolean givesConflict(int r, int  c, int d) {
        //TODO is there a conflict when we fill in d at position r,c?
        //Checking if any of the given conditions are true
        if(rowConflict(r,d)||colConflict(c,d)||boxConflict(r,c,d)){
            return true;
        }
        //END TODO
        return false;
    }

    boolean rowConflict(int r, int d) {
        //TODO is there a conflict in row r when we fill in d?
        //Iterating over the grid with a given row r
        for(int i = 0; i < grid[r].length; i++){
            if(grid[r][i] == d){
                return true;
            }
        }
        //END TODO
        return false;
    }

    boolean colConflict(int c, int d) {
        //TODO is there a conflict in column c when we fill in d?
        //Iterating over the grid with a given column c
        for(int i = 0; i < grid.length; i++){
            if(grid[i][c] == d){
                return true;
            }
        }
        //END TODO
        return false;
    }

    boolean boxConflict(int rr, int cc, int d) {
        //TODO is there a conflict when we fill in d at position in the box of rr,cc?
        //We will use integer division to find out the starting points of boxes
        int startBoxRow = (rr/BOXSIZE)*BOXSIZE;
        int startBoxCol = (cc/BOXSIZE)*BOXSIZE;
        for(int i = startBoxRow; i < startBoxRow + BOXSIZE; i++){
            for(int j = startBoxCol; j < startBoxCol + BOXSIZE; j++){
                if(d == grid[i][j]){
                    return true;
                }
            }
        }
        //END TODO
        return false;
    }


    int[] findEmptySquare() {
        //TODO return the next empty square (See assignment).
        //Setup nextEmpty for returning output
        nextEmpty = new int[2];
        //for loop to iterate over grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    nextEmpty[0] = i;
                    nextEmpty[1] = j;
                    return nextEmpty;
                }
            }
        }
        //END TODO
        return null;
     }

    void solve() {
        //TODO see (4)
        
        
        
        if (findEmptySquare() == null) {
            solutionnr++;
            for (int i = 0; i<grid.length; i++) {
                for (int j = 0; j<grid[i].length; j++) {
                    solution[i][j] = grid[i][j];
                }
            }
        } else {
            int r = nextEmpty[0];
            int c = nextEmpty[1];
            
            for (int d = 1; d <= 9; d++) {
                if (!givesConflict(r, c, d)) {
                    grid[r][c] = d;
                    solve();
                    grid[r][c] = 0;
                }
            }
        }
        



        //END TODO
    }

    // print the grid, 0s are printed as spaces
    void print() {
        //TODO print the grid, printing spaces instead of 0s
            for(int i  = 0; i < grid.length; i++){
                //Top bar
                if(i == 0){
                    System.out.println("+-----------------+");
                }
                //Horizontal dividers
                else if(i==3 || i==6){
                    System.out.println("-------------------");
                }
                //Iterating over grid
                for(int j = 0; j < grid[i].length; j++){
                    //Vertical dividers
                    if (j == 0 || j==3 || j==6 || j==9|| j ==12 || j == 15){
                        System.out.print("|");
                    }
                    else if(j==1||j==2||j==4||j==5||j==7||j==8){
                        System.out.print(" ");
                    }
                    //Printing zeroes as spaces
                    if(grid[i][j] == 0){
                        System.out.print(" ");
                    }
                    //Formatting all other numbers
                    else {
                        System.out.print(grid[i][j]);
                    }
                }
                //Newline because of the last number
                System.out.print("|\n");
            }
            //Grid bottom
            System.out.println("+-----------------+");
        //END TODO
    }

    //TODO extra methods
    
    void printSltn() {
        // This method checks whether the program should print the solution or the solutionnr and prints it
        if (solutionnr == 1) {
            grid = solution;
            print();
        } else {
            System.out.println(solutionnr);
        }
    }



    //END TODO


    public static void main(String[] args) {
        new Sudoku().run();
    }
}
