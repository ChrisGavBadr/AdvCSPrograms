package pathfinder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Navigator {

    private Maze maze;
    private Stack<Position> path = new Stack<>();
    private Position position;

    public Navigator(Maze maze, int x, int y) {
        this.maze = maze.copy();
        position = new Position(maze, x, y);

        for (int i = 0; i < maze.getYDimension(); i++) {
            for (int j = 0; j < maze.getXDimension(); j++) {
                if (maze.getMaze()[i][j] == Constants.C || maze.getMaze()[i][j] == Constants.S) {
                    path.push(new Position(maze, j, i));
                }
            }
        }
    }

    public Navigator(Maze maze, Position start) {
        this(maze, start.x(), start.y());
    }

    public Navigator(Maze maze) {
        this.maze = maze.copy();

        for (int y = 0; y < maze.getYDimension(); y++) {
            for (int x = 0; x < maze.getXDimension(); x++) {
                if (maze.getMaze()[y][x] == Constants.S) {
                    position = new Position(maze, x, y);
                    break;
                }
            }
        }
    }

    public void up() {
        position.setY(position.y() - 1);

    }

    public void down() {
        position.setY(position.y() + 1);
    }

    public void left() {
        position.setX(position.x() - 1);
    }

    public void right() {
        position.setX(position.x() + 1);
    }

    public Stack<Position> getPath() {
        return path;
    }

    public Position getPosition() {
        return position;
    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }
}
