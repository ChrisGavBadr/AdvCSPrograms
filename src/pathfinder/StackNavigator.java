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

    public boolean solveMaze() {
        boolean validMoveFound;

        do {
            validMoveFound = determineNextValidMove();
            if (!validMoveFound) {
                position = validUnexploredPositions.pop();
            }
        } while (!validUnexploredPositions.isEmpty());
    }

    private boolean determineNextValidMove() {
        boolean validMoveFound = false;

        // Check above position
        if (maze.getPositionState(position.x(), position.y() - 1) == Constants.C) {
            validMoveFound = true;
            up();
        } else {
            validUnexploredPositions.push(new Position(position.x(), position.y() - 1));
        }
        // Check below position
        if (!validMoveFound && maze.getPositionState(position.x(), position.y() + 1) == Constants.C) {
            validMoveFound = true;
            down();
        } else {
            validUnexploredPositions.push(new Position(position.x(), position.y() + 1));
        }
        // Check left position
        if (!validMoveFound && maze.getPositionState(position.x() - 1, position.y()) == Constants.C) {
            validMoveFound = true;
            left();
        } else {
            validUnexploredPositions.push(new Position(position.x(), position.y() + 1));
        }
        // Check right position
        if (!validMoveFound && maze.getPositionState(position.x() + 1, position.y()) == Constants.C) {
            validMoveFound = true;
            right();
        } else {
            validUnexploredPositions.push(new Position(position.x(), position.y() + 1));
        }

        return validMoveFound;
    }
}
