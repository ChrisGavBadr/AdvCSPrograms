package projects.pathfinder.navigator;

import projects.pathfinder.Constants;
import projects.pathfinder.Maze;
import projects.pathfinder.Position;

import java.util.Stack;

public class StackNavigator extends Navigator {

    private Stack<Position> validUnexploredPositions = new Stack<>();

    public StackNavigator(Maze maze, int x, int y) {
        super(maze, x, y);
    }

    public StackNavigator(Maze maze, Position start) {
        this(maze, start.x(), start.y());
    }

    public StackNavigator(Maze maze) {
        super(maze);
    }

    // Solves maze using a stack
    public boolean solveMaze() {
        validUnexploredPositions.push(currentPosition);

        do {
            setCurrentPosition(validUnexploredPositions.pop());
            mazePath.setPositionState(currentPosition, Constants.V);
            if (foundEscapePoint()) {
                mazePath.setPositionState(startPosition, Constants.S);
                return true;
            }
            determineNextValidMoves();
        } while (!validUnexploredPositions.isEmpty());

        mazePath.setPositionState(startPosition, Constants.S);
        return false;
    }

    // Pushes valid positions adjacent to current position to stack
    private void determineNextValidMoves() {
        // Check above current position
        if (currentPosition.y() > 0
                && mazePath.getPositionState(currentPosition.x(), currentPosition.y() - 1) == Constants.C) {
            validUnexploredPositions.push(new Position(currentPosition.x(), currentPosition.y() - 1));
        }
        // Check below current position
        if (currentPosition.y() + 1 < mazePath.getYDimension()
                && mazePath.getPositionState(currentPosition.x(), currentPosition.y() + 1) == Constants.C) {
            validUnexploredPositions.push(new Position(currentPosition.x(), currentPosition.y() + 1));
        }
        // Check left of current position
        if (currentPosition.x() > 0
                && mazePath.getPositionState(currentPosition.x() - 1, currentPosition.y()) == Constants.C) {
            validUnexploredPositions.push(new Position(currentPosition.x() - 1, currentPosition.y()));
        }
        // Check right of current position
        if (currentPosition.x() + 1 < mazePath.getXDimension()
                && mazePath.getPositionState(currentPosition.x() + 1, currentPosition.y()) == Constants.C) {
            validUnexploredPositions.push(new Position(currentPosition.x() + 1, currentPosition.y()));
        }
    }
}
