import java.time.LocalDateTime;

public interface ISkiPassChecker {
    boolean useRide(LocalDateTime time);
    LocalDateTime getLastVisit();
    int getRideAmount();

}
