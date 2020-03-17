package pathfinder;

/* Project Questions: How do the stack and queue algorithms differ?
 * How are they similar? In total, what process does this code
 * remind you of? Leave your response, about a paragraph or two,
 * in a comment on your code.
 *
 * The stack and queue algorithms used to determine if a maze is
 * solvable are exactly alike. However, the way in which valid
 * unexplored positions, or elements in general, are stored and
 * accessed are different. This is fundamental to the existence of
 * stacks and queues. In my algorithm, the work list of valid unexplored
 * positions were searched and added in the following order relative to
 * the current position: above, below, left, and right. In a stack work
 * list, the last valid unexplored position in the list would become the
 * new current position. On the other hand, in a queue work list, the
 * first valid unexplored position in the list would become the new
 * current position.
 *
 * The algorithm this program uses reminds me of the merge sorting
 * algorithm. Similar to merge sorting, this algorithm branches off to
 * different possibilities in order to accomplish a goal.
 */

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
        boolean mazeIsSolvable;
        System.out.println("Stack Navigator");
        System.out.println(maze.toString());
        mazeIsSolvable = navigator.solveMaze();
        if (mazeIsSolvable) {
            System.out.println("\nStack: Escape Successful");
        } else {
            System.out.println("\nStack: Escape Unsuccessful");
        }
        System.out.println(navigator.toString());
    }

    // Solves maze using queues
    public static void solveMaze(Maze maze, QueueNavigator navigator) {
        boolean mazeIsSolvable;
        System.out.println("Queue Navigator");
        System.out.println(maze.toString());
        mazeIsSolvable = navigator.solveMaze();
        if (mazeIsSolvable) {
            System.out.println("\nQueue: Escape Successful");
        } else {
            System.out.println("\nQueue: Escape Unsuccessful");
        }
        System.out.println(navigator.toString());
    }
}