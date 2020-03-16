package pathfinder;

import java.util.Queue;

class Main {
    final static char C = Constants.C, X = Constants.X, S = Constants.S, E = Constants.E, V = Constants.V;

    // Unsolvable Maze
    private static char[][] charMaze1 = {
            {X, X, X, X, X, X, X, X, X, X},
            {X, S, C, C, C, C, C, C, C, X},
            {X, C, C, C, X, C, X, X, C, X},
            {X, C, X, X, X, C, X, X, X, E},
            {X, C, C, C, C, X, X, X, C, X},
            {X, X, X, X, C, X, X, X, C, X},
            {X, X, X, X, C, X, C, C, C, X},
            {X, X, C, X, C, X, X, C, C, X},
            {X, X, C, C, C, C, C, C, C, X},
            {X, X, X, X, X, X, C, X, X, X}
    };


    // Solveable Maze
    private static char[][] charMaze2 = {
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X},
            {X, C, C, C, C, C, C, X, C, C, C, C, C, C, X},
            {X, X, X, C, X, X, X, X, X, X, X, C, X, C, X},
            {X, C, X, C, C, C, C, C, C, C, C, C, X, C, X},
            {X, C, X, C, X, X, C, C, X, X, X, C, X, C, X},
            {X, C, C, C, X, C, C, C, C, C, X, C, X, C, X},
            {X, C, X, X, X, X, X, C, X, C, X, C, X, C, X},
            {X, C, C, C, C, S, C, C, X, C, C, X, E, C, X},
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X}
    };

    // Initializes mazes and appropriate navigators
    private static Maze maze1 = new Maze(charMaze1);
    private static Maze maze2 = new Maze(charMaze2);
    private static StackNavigator sNavigator1 = new StackNavigator(maze1);
    private static QueueNavigator qNavigator1 = new QueueNavigator(maze1);
    private static StackNavigator sNavigator2 = new StackNavigator(maze2);
    private static QueueNavigator qNavigator2 = new QueueNavigator(maze2);

    public static void main(String[] args) {
        System.out.println("----");
        System.out.println("Maze 1");
        System.out.println("----");
        solveMaze(maze1, sNavigator1);
        System.out.println("----");
        solveMaze(maze1, qNavigator1);
        System.out.println("----");
        System.out.println("Maze 2");
        System.out.println("----");
        solveMaze(maze2, sNavigator2);
        System.out.println("----");
        solveMaze(maze2, qNavigator2);
        System.out.println("----");
    }

    // Solves maze using stacks
    public static void solveMaze(Maze maze, StackNavigator navigator) {
        boolean mazeIsSolveable;
        System.out.println("Stack Navigator");
        System.out.println(maze.toString());
        mazeIsSolveable = navigator.solveMaze();
        System.out.println("\n" + navigator.toString());
        System.out.println("Solveable (Stack): " + mazeIsSolveable);
    }

    // Solves maze using queues
    public static void solveMaze(Maze maze, QueueNavigator navigator) {
        boolean mazeIsSolveable;
        System.out.println("Queue Navigator");
        System.out.println(maze.toString());
        mazeIsSolveable = navigator.solveMaze();
        System.out.println("\n" + navigator.toString());
        System.out.println("Solveable (Queue): " + mazeIsSolveable);
    }
}