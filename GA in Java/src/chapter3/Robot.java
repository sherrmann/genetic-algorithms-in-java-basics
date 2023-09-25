package chapter3;

import java.util.ArrayList;

public class Robot {
    private enum Direction {NORT, EAST, SOUTH, WEST};
    private int xPosition;
    private int yPosition;
    private Direction heading;
    int maxMoves;
    int moves;
    private int sensorVal;
    private final int sensorActions[];
    private Maze maze;
    private ArrayList<int[]> route;

    /*
     * Initialize a robot with controller
     * @param sensorActions The string to map the sensor value to actions
     * @param maze The maze the robot will use
     * @param maxMoves The maximum number of moves the robot can make
     */
    public Robot(int[] sensorActions, Maze maze, int maxMoves) {
        this.sensorActions = this.calcSensorActions(sensorActions);
        this.maze = maze;
        int startPos[] = this.maze.getStartPosition();
        this.xPosition = startPos[0];
        this.yPosition = startPos[1];
        this.sensorVal = -1;
        this.heading = Direction.EAST;
        this.maxMoves = 0;
        this.route = new ArrayList<int[]>();
        this.route.add(startPos);
    }

    /**
     * Map robot's sensor data to actions from binary string
     * @param sensorActionsStr Binary GA chromosome
     * @return int[] An array to map sensor values to actions
     */
    private int[] calcSensorActions(int[] sensorActionsStr) {
        // How many actions are there?
        int numActions = (int) sensorActionsStr.length / 2;
        int sensorActions[] = new int[numActions];

        // loop through actions
        for (int sensorValue = 0; sensorValue < numActions; sensorValue++) {
            // Get sensor action
            int sensorAction = 0;
            if (sensorActionsStr[sensorValue*2] == 1) {
                sensorAction += 2;
            }

            if (sensorActionsStr[sensorValue * 2 + 1] == 1) {
                sensorAction += 1;
            }
        }
        return sensorActions;
    }

    /**
     * Runs the robot's actions based on sensor inputs
     */
    public void run() {
        while(true){
            this.moves++;

            // break if the robot stops moving
            if (this.getNextAction() == 0) {
                return;
            }

            // break if we reach the goal
            if (this.maze.getPositionValue(this.xPosition, this.yPosition) == 4) {
                return;
            }

            // break if we reach the maximum numbers of moves
            if (this.moves > this.maxMoves) {
                return;
            }

            // run action
            this.makeNextAction();
        }
    }

    private void makeNextAction() {
        // TODO: implement makeNextAction
    }

    private int getNextAction() {
        return 0;
    }
}
