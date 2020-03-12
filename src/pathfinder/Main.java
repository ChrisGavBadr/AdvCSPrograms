package pathfinder;

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

    private static Maze maze1 = new Maze(charMaze1);
    private static StackNavigator navigator1 = new StackNavigator(maze1);

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

    private static Maze maze2 = new Maze(charMaze2);
    private static StackNavigator navigator2 = new StackNavigator(maze2);

    public static void main(String[] args) {
        System.out.println(maze1.toString());
        navigator1.solveMaze();
        System.out.println(maze1.toString());

        /*System.out.println();
        solveQ();
        System.out.println();
        solveS();*/
    }
}