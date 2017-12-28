import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WeekdaySkiPass extends SkiPass {


    public WeekdaySkiPass(ISkiPassChecker skiPassChecker){
        super(skiPassChecker);
    }

    @Override
    public boolean useRide(LocalDateTime now) {
        if(blocked){
            System.out.println("Your SkiPass blocked");
            return false;
        }
        if(now.getDayOfWeek() != DayOfWeek.SATURDAY && now.getDayOfWeek() != DayOfWeek.SUNDAY){
            return skiPassChecker.useRide(now);
        } else{
            System.out.println("Today is not weekday");
            return false;
        }
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
