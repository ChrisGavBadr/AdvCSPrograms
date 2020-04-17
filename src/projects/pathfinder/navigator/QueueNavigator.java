package projects.pathfinder.navigator;

import projects.pathfinder.Constants;
import projects.pathfinder.Maze;
import projects.pathfinder.Position;

import java.util.LinkedList;
import java.util.Queue;

public class QueueNavigator extends Navigator {

    private Queue<Position> validUnexploredPositions = new LinkedList<>();

    public QueueNavigator(Maze maze, int x, int y) {
        super(maze, x, y);
    }

    public QueueNavigator(Maze maze, Position start) {
        this(maze, start.x(), start.y());
    }

    public QueueNavigator(Maze maze) {
        super(maze);
    }

    // Solves maze using a queue
    public boolean solveMaze() {
        validUnexploredPositions.add(currentPosition);

        do {
            setCurrentPosition(validUnexploredPositions.remove());
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

    // Adds valid positions adjacent to current position to queue
    private void determineNextValidMoves() {
        // Check above current position
        if (currentPosition.y() > 0
                && mazePath.getPositionState(currentPosition.x(), currentPosition.y() - 1) == Constants.C) {
            validUnexploredPositions.add(new Position(currentPosition.x(), currentPosition.y() - 1));
        }
        // Check below current position
        if (currentPosition.y() + 1 < mazePath.getYDimension()
                && mazePath.getPositionState(currentPosition.x(), currentPosition.y() + 1) == Constants.C) {
            validUnexploredPositions.add(new Position(currentPosition.x(), currentPosition.y() + 1));
        }
        // Check left of current position
        if (currentPosition.x() > 0
                && mazePath.getPositionState(currentPosition.x() - 1, currentPosition.y()) == Constants.C) {
            validUnexploredPositions.add(new Position(currentPosition.x() - 1, currentPosition.y()));
        }
        // Check right of current position
        if (currentPosition.x() + 1 < mazePath.getXDimension()
                && mazePath.getPositionState(currentPosition.x() + 1, currentPosition.y()) == Constants.C) {
            validUnexploredPositions.add(new Position(currentPosition.x() + 1, currentPosition.y()));
        }
    }
}
