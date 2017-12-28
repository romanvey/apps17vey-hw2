import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WeekendSkiPass extends SkiPass {


    public WeekendSkiPass(ISkiPassChecker skiPassChecker){
        super(skiPassChecker);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(blocked){
            System.out.println("Your SkiPass blocked");
            return false;
        }
        if(now.getDayOfWeek() == DayOfWeek.SATURDAY || now.getDayOfWeek() == DayOfWeek.SUNDAY){
            return skiPassChecker.useRide(now);
        } else{
            System.out.println("Today is not weekend");
            return false;
        }
    }

    @Override
    public SkiPassType getType() {
        return SkiPassType.WEEKEND;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + getType().toString() + "\n-----------------------";
    }
}
