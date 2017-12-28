import java.time.LocalDateTime;

public class RideChecker extends SkiPassChecker {

    public RideChecker(SkiPassRidesAmount skiPassRidesAmount){
        super(skiPassRidesAmount);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(rides > 0){
            rides--;
            lastVisit = now;
            System.out.println("PASSED");
            return true;
        }
        System.out.println("No rides");
        return false;
    }
}
