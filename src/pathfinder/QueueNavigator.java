package pathfinder;

import java.util.LinkedList;
import java.util.Queue;

public class QueueNavigator extends Navigator {

    private Queue<Position> unexploredPositions = new LinkedList<>();

    public QueueNavigator(Maze maze, int x, int y) {
        super(maze, x, y);
        findPossiblePositions();
    }

    public QueueNavigator(Maze maze, Position start) {
        this(maze, start.x(), start.y());
    }

    public QueueNavigator(Maze maze) {
        super(maze);
        findPossiblePositions();
    }

    private void findPossiblePositions() {
        for (int y = 0; y < maze.getYDimension(); y++) {
            for (int x = 0; x < maze.getXDimension(); x++) {
                if (maze.getMaze()[y][x] == Constants.C || maze.getMaze()[y][x] == Constants.S) {
                    unexploredPositions.add(new Position(x, y));
                }
            }
        }
    }

    /*public boolean solveMaze() {

    }*/
}
