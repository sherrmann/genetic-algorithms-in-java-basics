package chapter3;

import java.util.ArrayList;

public class Maze {
    // array of row, columns or y, x
    private final int maze[][];
    private int startPosition[] = { -1, -1 };

    public Maze(int maze[][]) {
        this.maze = maze;
    }

    // returns column, row if start found which is a 2
    public int[] getStartPosition() {
        // check if we've already found start position
        if(this.startPosition[0] != -1 && this.startPosition[1] != -1) {
            return this.startPosition;
        }

        // default return value
        int startPosition[] = { 0, 0 };

        // Loop over rows to find start position
        for (int rowIndex = 0; rowIndex < this.maze.length; rowIndex++){
            // Loop over columns
            for (int colIndex = 0; colIndex < this.maze.length; colIndex++) {
                // 2 ist the type for start position
                if (this.maze[rowIndex][colIndex] == 2) {
                    this.startPosition = new int[] { colIndex, rowIndex };
                    return new int[] { colIndex, rowIndex };
                }
            }
        }
        // return default value
        return startPosition;
    }

    // return position value or 1 if out of bounds
    public int getPositionValue(int x, int y) {
        if (x < 0 || y < 0 || x >= this.maze.length || y >= this.maze[0].length) {
            return 1;
        }
        return this.maze[y][x];
    }

    // return true if it's a wall which is a 1
    public boolean isWall(int x, int y) {
        return (this.getPositionValue(x, y) == 1);
    }

    public int getMaxX() {
        return this.maze[0].length -1;
    }

    public int getMaxY() {
        return this.maze.length -1;
    }

    // I think the argument is an Arraylist of arrays, each containing a column, row
    public int scoreRoute(ArrayList<int[]> route) {
        int score = 0;
        // holds all the visited locations
        boolean visited[][] = new boolean[this.getMaxY() + 1][this.getMaxX() + 1];

        // Loop over route and score each move
        for (int[] step : route) {
            if (this.maze[step[1]][step[0]] == 3 && visited[step[1]][step[0]] == false) {
                // increase score for correct move
                score++;
                // remove reward
                visited[step[1]][step[0]] = true;
            }
        }
        return score;
    }
}

