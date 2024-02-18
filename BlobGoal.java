package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal {

    public BlobGoal(Color c) {
        super(c);
    }

    @Override
    public int score(Block board) {
        Color[][] flattenedBoard = board.flatten();
        int rowCount = flattenedBoard.length;
        int colCount = flattenedBoard[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int maxBlobSize = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int currentBlobSize = undiscoveredBlobSize(i, j, flattenedBoard, visited);
                if (currentBlobSize > maxBlobSize) {
                    maxBlobSize = currentBlobSize;
                }
            }
        }

        return maxBlobSize;
    }

    @Override
    public String description() {
        return "Create the largest connected blob of " + GameColors.colorToString(targetGoal)
                + " blocks, anywhere within the block";
    }

    public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
        if (i < 0 || i >= unitCells.length || j < 0 || j >= unitCells[0].length || visited[i][j]
                || unitCells[i][j] != targetGoal) {
            return 0;
        }

        visited[i][j] = true;
        int blobSize = 1;

        blobSize += undiscoveredBlobSize(i - 1, j, unitCells, visited);
        blobSize += undiscoveredBlobSize(i + 1, j, unitCells, visited);
        blobSize += undiscoveredBlobSize(i, j - 1, unitCells, visited);
        blobSize += undiscoveredBlobSize(i, j + 1, unitCells, visited);

        return blobSize;
    }
}