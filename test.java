
import java.util.ArrayList;

public class test
{
    public static void main(String[] args){
        String[][] sudoku = createPuzzle();
        printSudoku(sudoku);
    }
    
    public static boolean checkRow(String[][] sudoku, int row, int num){
        boolean good = true;
        ArrayList<String> used = new ArrayList<String>();
        for(int r = 0; r < sudoku.length; r++){
            for(int c = 0; c < sudoku[r].length; c++){
                if(used.contains(sudoku[r][c])){
                    good = false;
                }
                if(sudoku[r][c] != null && used.contains(sudoku[r][c]) == false){
                    used.add(sudoku[r][c]);
                }
            } 
            used.clear();
        }
        return good;
        
        /*
        boolean good = false;
        ArrayList<String> used = new ArrayList<String>();
        for(int r = row; r < row+1; r++){
            for(int c = 0; c < sudoku[r].length; c++){
                if(sudoku[r][c] != null){
                    used.add(sudoku[r][c]);
                }
            }            
        }
        if(used.contains(String.valueOf(num)) == false){
            good = true;
        }
        return good;
        */
    }
    
    public static boolean checkCol(String[][] sudoku, int col, int num){
        boolean good = false;        
        ArrayList<String> used = new ArrayList<String>();
        for(int c = col; c < col+1; c++){
            for(int r = 0; r < sudoku.length; r++){
                if(sudoku[r][c] != null){
                    used.add(sudoku[r][c]);
                }
            }            
        }
        if(used.contains(String.valueOf(num)) == false){
            good = true;
        }
        return good;     
    }
    
    public static boolean checkSquare(){
        boolean good = false;
        return good;
    }
    
    public static void printSudoku(String[][] sudoku){
        for(int r = 0; r < sudoku.length; r++){
            for(int c = 0; c < sudoku[r].length; c++){
                if(sudoku[r][c] == null){
                    System.out.print("X ");
                }
                else{
                    System.out.print(sudoku[r][c] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static String[][] createPuzzle(){
        String[][] sudoku = new String[9][9];
        int randPos = 0;
        int randNum = 0;
        int randCount = 0;
        int spot = 0;        
        ArrayList<Integer> usedPos = new ArrayList<Integer>();
        for(int r = 0; r < sudoku.length; r++){
            randCount = (int)(Math.random()*5)+3;
            while(spot < randCount){
                randPos = (int)(Math.random()*9);
                if(usedPos.contains(randPos) == false){
                    usedPos.add(randPos);
                    spot++;
                }                
            }
            System.out.println(randCount + " and " + usedPos);
            for(int c = 0; c < sudoku[r].length; c++){
                if(usedPos.contains(c)){
                    randNum = (int)(Math.random()*9)+1;
                    while(checkRow(sudoku,r,randNum) == false && checkCol(sudoku,c,randNum) == false){
                        randNum = (int)(Math.random()*9)+1;
                    }
                    sudoku[r][c] = String.valueOf(randNum);
                }
            }
            usedPos.clear();
            spot = 0;
        }
        return sudoku;
    }
}
