package pathfinder;

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
        validUnexploredPositions.add(getCurrentPosition());

        do {
            setCurrentPosition(validUnexploredPositions.remove());
            getMazePath().setPositionState(getCurrentPosition(), Constants.V);
            if (foundEscapePoint()) {
                getMazePath().setPositionState(getStartPosition(), Constants.S);
                return true;
            }
            determineNextValidMoves();
        } while (!validUnexploredPositions.isEmpty());

        getMazePath().setPositionState(getStartPosition(), Constants.S);
        return false;
    }

    // Adds valid positions adjacent to current position to queue
    private void determineNextValidMoves() {
        // Check above current position
        if (getCurrentPosition().y() > 0
                && getMazePath().getPositionState(getCurrentPosition().x(), getCurrentPosition().y() - 1) == Constants.C) {
            validUnexploredPositions.add(new Position(getCurrentPosition().x(), getCurrentPosition().y() - 1));
        }
        // Check below current position
        if (getCurrentPosition().y() + 1 < getMazePath().getYDimension()
                && getMazePath().getPositionState(getCurrentPosition().x(), getCurrentPosition().y() + 1) == Constants.C) {
            validUnexploredPositions.add(new Position(getCurrentPosition().x(), getCurrentPosition().y() + 1));
        }
        // Check left of current position
        if (getCurrentPosition().x() > 0
                && getMazePath().getPositionState(getCurrentPosition().x() - 1, getCurrentPosition().y()) == Constants.C) {
            validUnexploredPositions.add(new Position(getCurrentPosition().x() - 1, getCurrentPosition().y()));
        }
        // Check right of current position
        if (getCurrentPosition().x() + 1 < getMazePath().getXDimension()
                && getMazePath().getPositionState(getCurrentPosition().x() + 1, getCurrentPosition().y()) == Constants.C) {
            validUnexploredPositions.add(new Position(getCurrentPosition().x() + 1, getCurrentPosition().y()));
        }
    }
}
