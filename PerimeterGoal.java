package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal {

    public PerimeterGoal(Color c) {
        super(c);
    }

    @Override
    public int score(Block board) {
        Color[][] flattenedBoard = board.flatten();
        int rowCount = flattenedBoard.length;
        int colCount = flattenedBoard[0].length;
        int score = 0;


        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (flattenedBoard[i][j] == targetGoal) {
                    if (i == 0 || i == rowCount - 1 || j == 0 || j == colCount - 1) {
                        score += (i == 0 || i == rowCount - 1) && (j == 0 || j == colCount - 1) ? 2 : 1;
                    }
                }
            }
        }

        if(rowCount == 2 && colCount ==2 ){
            score*=2;
        }

        return score;
    }

    @Override
    public String description() {
        return "Place the highest number of " + GameColors.colorToString(targetGoal)
                + " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
    }

}