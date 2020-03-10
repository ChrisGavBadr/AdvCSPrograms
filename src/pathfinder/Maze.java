package pathfinder;

public class Maze {
    private char[][] maze;
    private int xDimension;
    private int yDimension;

    public Maze(char[][] maze) {
        this.maze = maze.clone();
        xDimension = maze[0].length;
        yDimension = maze.length;
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
        char[][] mazeCopy = new char[xDimension][];

        for (int i = 0; i < maze.length; i++) {
                mazeCopy[i] = maze[i].clone();
        }

        return new Maze(mazeCopy);
    }
}
