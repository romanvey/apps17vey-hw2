import java.time.LocalDateTime;

public class RidePerDayChecker extends SkiPassChecker {

    public RidePerDayChecker(SkiPassRidesAmount skiPassRidesAmount){
        super(skiPassRidesAmount);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(lastVisit == null || lastVisit.getDayOfYear() != now.getDayOfYear() ||
                lastVisit.getYear() != now.getYear()) {
            if (rides > 0) {
                rides--;
                lastVisit = now;
                System.out.println("PASSED");
                return true;
            }
            System.out.println("No rides");
            return false;
        }
        lastVisit = now;
        System.out.println("PASSED");
        return true;
    }
}