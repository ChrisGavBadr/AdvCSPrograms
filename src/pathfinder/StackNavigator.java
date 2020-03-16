package pathfinder;

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
        validUnexploredPositions.push(getCurrentPosition());

        do {
            setCurrentPosition(validUnexploredPositions.pop());
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

    // Pushes valid positions adjacent to current position to stack
    private void determineNextValidMoves() {
        // Check above current position
        if (getCurrentPosition().y() > 0
                && getMazePath().getPositionState(getCurrentPosition().x(), getCurrentPosition().y() - 1) == Constants.C) {
            validUnexploredPositions.push(new Position(getCurrentPosition().x(), getCurrentPosition().y() - 1));
        }
        // Check below current position
        if (getCurrentPosition().y() + 1 < getMazePath().getYDimension()
                && getMazePath().getPositionState(getCurrentPosition().x(), getCurrentPosition().y() + 1) == Constants.C) {
            validUnexploredPositions.push(new Position(getCurrentPosition().x(), getCurrentPosition().y() + 1));
        }
        // Check left of current position
        if (getCurrentPosition().x() > 0
                && getMazePath().getPositionState(getCurrentPosition().x() - 1, getCurrentPosition().y()) == Constants.C) {
            validUnexploredPositions.push(new Position(getCurrentPosition().x() - 1, getCurrentPosition().y()));
        }
        // Check right of current position
        if (getCurrentPosition().x() + 1 < getMazePath().getXDimension()
                && getMazePath().getPositionState(getCurrentPosition().x() + 1, getCurrentPosition().y()) == Constants.C) {
            validUnexploredPositions.push(new Position(getCurrentPosition().x() + 1, getCurrentPosition().y()));
        }
    }
}
