import java.time.LocalDateTime;

public class RideChecker extends SkiPassChecker {

    public RideChecker(int rides){
        super(rides);
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
