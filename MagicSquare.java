/*
* The Main program is a recreation of the magic square program.
*
* @author  Ben Whitten
* @version 1.0
* @since   2021-1-8
*/

public class MagicSquare {
  public static final int size = 9;

  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function prints the magic squares.
   */
  public static void printSquare(int [] printList) {
    for (int printCounter = 0; printCounter < printList.length; printCounter++) {
      System.out.print(printList[printCounter] + " ");
      if ((printCounter + 1) % 3 == 0) {
        System.out.println("");
      } else {
        continue;
      }
    }
    System.out.println("=====");
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function finds the magic squares.
   */
  public static void solveSquares(int[] magicSquare, int[] indexList, int index) {
    for (int counter = 0; counter < magicSquare.length; counter++) {
      if (indexList[counter] == 0) {
        magicSquare[counter] = index;
        indexList[counter] = 1;

        if (index < 9) {
          solveSquares(magicSquare, indexList, index + 1);
        } else {
          if (msSolve(magicSquare) == true) {
            printSquare(magicSquare);
          }
        }

        indexList[counter] = 0;
      }
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function solves the square.
   */
  public static boolean msSolve(int[] magicSquare) {
    //Horizontal
    int check = magicSquare[0] + magicSquare[1] + magicSquare[2];
    if (check != 15) {
      return false;
    }
    check = magicSquare[3] + magicSquare[4] + magicSquare[5];
    if (check != 15) {
      return false;
    }
    check = magicSquare[6] + magicSquare[7] + magicSquare[8];
    if (check != 15) {
      return false;
    }
    
    //Vertical
    check = magicSquare[0] + magicSquare[3] + magicSquare[6];
    if (check != 15) {
      return false;
    }
    check = magicSquare[1] + magicSquare[4] + magicSquare[7];
    if (check != 15) {
      return false;
    }
    check = magicSquare[2] + magicSquare[5] + magicSquare[8];
    if (check != 15) {
      return false;
    }
    
    //Diagonal
    check = magicSquare[0] + magicSquare[4] + magicSquare[8];
    if (check != 15) {
      return false;
    }
    check = magicSquare[2] + magicSquare[4] + magicSquare[6];
    if (check != 15) {
      return false;
    }
    
    return true;
  }

  /////////////////////////////////////////////////////////////////////////////

  /**
   * This function calls the other functions.
   */
  public static void main(String[] args) {

    int[] firstList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] secondList = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Printing the inital dividing line
    System.out.println("=====");

    solveSquares(firstList, secondList, 1);
  }
}
