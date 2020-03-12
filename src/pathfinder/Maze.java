package pathfinder;

import java.util.Arrays;

public class Maze {
    private char[][] maze;
    private int xDimension;
    private int yDimension;

    public Maze(char[][] maze) {
        xDimension = maze[0].length;
        yDimension = maze.length;

        this.maze = new char[yDimension][];
        for (int i = 0; i < yDimension; i++) {
            this.maze[i] = maze[i].clone();
        }
    }

    public Position findStartPosition() {
        for (int y = 0; y < yDimension; y++) {
            for (int x = 0; x < xDimension; x++) {
                if (maze[y][x] == Constants.S) {
                    return new Position(x, y);
                }
            }
        }

        return null;
    }

    public char[][] getMaze() {
        return maze;
    }

    public int getXDimension() {
        return xDimension;
    }

    public int getYDimension() {
        return yDimension;
    }

    public char getPositionState(int x, int y) {
        return maze[y][x];
    }

    public char getPositionState(Position position) {
        return getPositionState(position.x(), position.y());
    }

    public void setPositionState(int x, int y, char c) {
        maze[y][x] = c;
    }

    public void setPositionState(Position position, char c) {
        setPositionState(position.x(), position.y(), c);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                s.append(maze[y][x]).append(' ');
            }
            s.append("\n");
        }

        return s.toString();
    }

    public Maze copy() {
        char[][] mazeCopy = new char[yDimension][];

        for (int i = 0; i < maze.length; i++) {
            mazeCopy[i] = maze[i].clone();
        }

        return new Maze(mazeCopy);
    }
}
