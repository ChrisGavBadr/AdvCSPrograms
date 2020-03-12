package pathfinder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class Navigator {

    protected Maze maze;
    protected Position position;

    protected Navigator(Maze maze, int x, int y) {
        this.maze = maze.copy();
        position = new Position(x, y);
    }

    protected Navigator(Maze maze, Position start) {
        this(maze, start.x(), start.y());
    }

    protected Navigator(Maze maze) {
        this.maze = maze.copy();
        position = maze.findStartPosition();
    }

    protected void setExplored() {
        if (maze.getPositionState(position) == Constants.C) {
            maze.setPositionState(position, Constants.V);
        }
    }

    protected void up() {
        position.setY(position.y() - 1);
        setExplored();
    }

    protected void down() {
        position.setY(position.y() + 1);
        setExplored();
    }

    protected void left() {
        position.setX(position.x() - 1);
        setExplored();
    }

    protected void right() {
        position.setX(position.x() + 1);
        setExplored();
    }

    protected Position getPosition() {
        return position;
    }

    protected void setX(int x) {
        position.setX(x);
    }

    protected void setY(int y) {
        position.setY(y);
    }
}
