import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class AllDaysSkiPass extends SkiPass {


    public AllDaysSkiPass(ISkiPassChecker skiPassChecker){
        super(skiPassChecker);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(blocked){
            System.out.println("Your SkiPass blocked");
            return false;
        }
            return skiPassChecker.useRide(now);
    }

    @Override
    public SkiPassType getType() {
        return SkiPassType.WEEKDAY;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + getType().toString() + "\n-----------------------";
    }
}
