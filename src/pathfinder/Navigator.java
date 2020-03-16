package pathfinder;

public abstract class Navigator {

    private Maze mazePath;
    private Position startPosition;
    private Position currentPosition;

    protected Navigator(Maze maze, int x, int y) {
        this.mazePath = maze.copy();
        startPosition = new Position(x, y);
        currentPosition = startPosition.copy();
    }

    protected Navigator(Maze mazePath, Position start) {
        this(mazePath, start.x(), start.y());
    }

    protected Navigator(Maze mazePath) {
        this.mazePath = mazePath.copy();
        startPosition = mazePath.findStartPosition();
        currentPosition = startPosition.copy();
    }

    public abstract boolean solveMaze();

    // Determines if escape point is adjacent to current position
    protected boolean foundEscapePoint() {
        return (currentPosition.y() > 0 && mazePath.getPositionState(currentPosition.x(), currentPosition.y() - 1) == Constants.E)
                || (currentPosition.y() + 1 < mazePath.getYDimension() && mazePath.getPositionState(currentPosition.x(), currentPosition.y() + 1) == Constants.E)
                || (currentPosition.x() > 0 && mazePath.getPositionState(currentPosition.x() - 1, currentPosition.y()) == Constants.E)
                || (currentPosition.x() + 1 < mazePath.getXDimension() && mazePath.getPositionState(currentPosition.x() + 1, currentPosition.y()) == Constants.E);
    }

    protected void setExplored() {
        if (mazePath.getPositionState(currentPosition) == Constants.C) {
            mazePath.setPositionState(currentPosition, Constants.V);
        }
    }

    protected void up() {
        currentPosition.setY(currentPosition.y() - 1);
        setExplored();
    }

    protected void down() {
        currentPosition.setY(currentPosition.y() + 1);
        setExplored();
    }

    protected void left() {
        currentPosition.setX(currentPosition.x() - 1);
        setExplored();
    }

    protected void right() {
        currentPosition.setX(currentPosition.x() + 1);
        setExplored();
    }

    public Maze getMazePath() {
        return mazePath;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int x, int y) {
        currentPosition.setX(x);
        currentPosition.setY(y);
    }

    public void setCurrentPosition(Position position) {
        setCurrentPosition(position.x(), position.y());
    }

    @Override
    public String toString() {
        return "Start Position: " + startPosition.toString()
                + "\nCurrent Position: " + currentPosition.toString()
                + "\n" + mazePath.toString();
    }
}
