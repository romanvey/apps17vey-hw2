import java.time.LocalDateTime;

public class MonthRideChecker extends SkiPassChecker {
    public MonthRideChecker(SkiPassRidesAmount skiPassRidesAmount){
        super(skiPassRidesAmount);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(lastVisit == null || lastVisit.getMonthValue()  != now.getMonthValue() ||
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