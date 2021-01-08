/*
* The Main program is a recreation of the magic square program.
*
* @author  Ben Whitten
* @version 1.0
* @since   2021-1-8
*/

///////////////////////////////////////////////////////////////////////////////
class magicSquareScalable {
  public static int size = 9;
  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function initialises the variables for the magic square program.
   */
  public static int magicSquareCalculate(int [] magicSquare, int position) {
    
    if (position != size - 1) {
      if (position == 0 && magicSquare[position] == size) {
        return 1;
      }

      if (magicSquare[position] == size) {
        magicSquare[position] = 0;
        magicSquareCalculate(magicSquare, position - 1);
        return 1;
        
      } else {
        magicSquare[position] += 1;
        magicSquareCalculate(magicSquare, size - 1);
        return 1;
      }
    }
    
    if (magicSquare[position] < size) {
      magicSquare[position] += 1;
      if (mSSolve(magicSquare)) {
        for (int temp = 0; temp < size; temp++) {
          System.out.print(magicSquare[temp] + " ");
          if ((temp + 1) % Math.sqrt(size) == 0) {
            System.out.print("\n");
          }
        }
        System.out.println("");
      }
      magicSquareCalculate(magicSquare, position);
      return 1;
    } else {
      magicSquare[position] = 0;
      magicSquareCalculate(magicSquare, position - 1);
      return 1;
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function initialises the variables for the magic square program.
   */
  public static boolean mSSolve(int [] magicSquare) {
    int check = 0;
    int location;
    int row;
    int sum = size * (size * size + 1) / 2;
    int sqrt = 3;

    //Checking horizontal
    for (row = 1; row < sqrt; row++) {
      for (location = 0; location < sqrt; location++) {
        check = magicSquare[location + (row * sqrt)];
      }
      if (check != sum) {
        return false;
      }
    }


    //Checking Vertical
    for (location = 0; location < sqrt; location++) {
      for (row = 1; row < sqrt; row++) {
        check = magicSquare[location + (row * sqrt)];
      }
      if (check != sum) {
      return false;
      }
    }

    //Checking Diagonal 1
    row = -1;
    for (location = 0; location < sqrt; location++) {
      row += 1;
      check = magicSquare[location + (row * sqrt + row)];
    }
    if (check != sum) {
      return false;
    }
    
    //Checking Diagonal 2
    row = 1;
    for (location = 0; location < sqrt; location++) {
      row -= 1;
      check = magicSquare[location + ((row * -1) * sqrt + row)];
    }
    if (check != sum) {
      return false;
    }
    
    for (location = 0; location < size; location++) {
      for (row = 0; row < size; row++) {
        if (magicSquare[location] == magicSquare[row]) {
          return false;
        }
      }
    }

    return true;
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * This function handles the input and output of the program.
   */
  public static void main(String[] args) {
    int [] magicSquare = new int [size];
    int end = magicSquareCalculate(magicSquare, size - 1);
  }
}
