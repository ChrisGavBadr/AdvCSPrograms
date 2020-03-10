package pathfinder;

public class Navigator {

    private Maze maze;
    private int x;
    private int y;

    public Navigator(int x, int y, Maze maze) {
        this.maze = maze;
        this.x = x;
        this.y = y;
    }
}
