package pathfinder;

public class Maze {
    final static char C = ' ', X = 'X', S = 'S', E = 'E', V = '.';
    private char[][] maze;
    private int xDimension;
    private int yDimension;

    public Maze(char[][] maze) {
        this.maze = maze;
        xDimension = maze[0].length;
        yDimension = maze.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                s.append(maze[i][j]).append(' ');
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
