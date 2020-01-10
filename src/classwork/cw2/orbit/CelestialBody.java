package classwork.cw2.orbit;

public class CelestialBody {

    public static void getPosition(double radius, double velocity, int frames) {
        double tau = 0.0027;
        double gm = 4*Math.pow(Math.PI, 2);

        double rx = radius;
        double ry = 0;
        double vx = 0;
        double vy = velocity;

        for (double t = 0; t < tau*frames; t += tau) {
            double pow = Math.pow(Math.hypot(rx, ry), 3);
            double ax = -gm*rx / pow;
            double ay = -gm*ry / pow;
            rx += tau*vx;
            ry += tau*vy;
            vx += tau*ax;
            vy += tau*ay;
        }

        System.out.printf("\nPosition: (%.2f, %.2f)\n", rx, ry);
        System.out.printf("Velocity: (%.2f, %.2f)", vx, vy);
    }
}
