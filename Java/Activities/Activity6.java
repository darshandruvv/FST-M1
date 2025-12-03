package activity1;

public class Activity6 {

    public static void main(String[] args) {

        Plane plane = new Plane(10);

        plane.onboard("Sanju");
        plane.onboard("Darshan");
        plane.onboard("Saran");

        System.out.println("Takeoff Time: " + plane.takeOff());
        System.out.println("Passengers: " + plane.getPassengers());

        try {
            Thread.sleep(5000);  // 5 seconds
        } catch (Exception e) {
            e.printStackTrace();
        }

        plane.land();
        System.out.println("Landing Time: " + plane.getLastLandingTime());
    }
}
