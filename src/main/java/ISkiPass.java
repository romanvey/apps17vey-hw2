import java.time.LocalDateTime;

public interface ISkiPass {
    boolean useRide(LocalDateTime time);
    void block();
    void unblock();
    int getId();
    SkiPassType getType();
    LocalDateTime getLastVisit();
    int getRideAmount();
}
