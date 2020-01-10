package classwork.cw2.orbit;

import java.util.Scanner;

class GravDriver {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Orbit Radius: ");
        double radius = s.nextDouble();
        System.out.print("Tangential Velocity: ");
        double velocity = s.nextDouble();
        System.out.print("Frames: ");
        int frames = s.nextInt();

        CelestialBody.getPosition(radius, velocity, frames);
    }
}
