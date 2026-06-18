public class AngleBetweenHands1344 {

    public static double angleClock(int hour, int minutes) {

        if (hour == 12) {
            hour = 0;
        }

        double hAngle = (hour * 30) + (minutes * 0.5);
        double mAngle = minutes * 6;

        double angle = Math.abs(hAngle - mAngle);

        angle = Math.min(angle, 360 - angle);

        return angle;
    }

    public static void main(String[] args) {

        int hour = 3;
        int minutes = 15;

        double result = angleClock(hour, minutes);

        System.out.println(result);
    }
}