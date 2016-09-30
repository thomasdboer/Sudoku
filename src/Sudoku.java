//Thomas den Boer, Thomas Willems
//30-9-2016
//This program solves a Sudoku
class Sudoku {
    private static final int SIZE = 9;     // size of the grid e.g. 9 -> 9x9
    private static final int DMAX = 9;     // max digit to be filled in e.g. 9
    private static final int BOXSIZE = 3;  // size of the boxes e.g. 3 -> 3x3
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

    void run() {
        //TODO starts the solving process.
        printSudoku();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0) {
                    for (int k = 1; k <= 9; k++)
                        if(givesConflict(i, j, k)){
                         System.out.println("Conflict!");
                    }
                }
            }
        }

        //END TODO
    }

    void printSudoku() {

        for(int i  = 0; i < grid.length; i++){
            if(i == 0){
                System.out.println("+-----------------------------+");
            }
            else if(i==3 || i==6){
                System.out.println("-------------------------------");
            }
            for(int j = 0; j < grid[i].length; j++){
                if (j == 0 || j==3 || j==6 || j==9|| j ==12 || j == 15){
                    System.out.print("|");
                }
                if(grid[i][j] == 0){
                    System.out.print("   ");
                }
                else {
                    System.out.print(" "+grid[i][j] + " ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("+-----------------------------+");
    }

    boolean givesConflict(int r, int  c, int d) {
        //TODO is there a conflict when we fill in d at position r,c?
        if(rowConflict(r,d)||colConflict(c,d)||boxConflict(r,c,d)){
            return true;
        }
        //END TODO
        return false;
    }

    boolean rowConflict(int r, int d) {
        //TODO is there a conflict in row r when we fill in d?
        for(int i = 0; i < grid[r].length;){
            if(grid[r][i] == d){
                return true;
            }
        }


        //END TODO
        return false;
    }

    boolean colConflict(int c, int d) {
        //TODO is there a conflict in column c when we fill in d?



        //END TODO
        return false;
    }

    boolean boxConflict(int rr, int cc, int d) {
        //TODO is there a conflict when we fill in d at position in the box of rr,cc?



        //END TODO
        return false;
    }


    int[] findEmptySquare() {
        //TODO return the next empty square (See assignment).



        //END TODO
        return null;
    }

    void solve() {
        //TODO see (4)



        //END TODO
    }

    // print the grid, 0s are printed as spaces
    void print() {
        //TODO print the grid, printing spaces instead of 0s.



        //END TODO
    }

    //TODO extra methods



    //END TODO


    public static void main(String[] args) {
        new Sudoku().run();
    }
}
