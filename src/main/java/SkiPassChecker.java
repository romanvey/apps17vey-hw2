import java.time.LocalDateTime;

abstract public class SkiPassChecker implements ISkiPassChecker {
    int rides;
    LocalDateTime lastVisit = null;

    public SkiPassChecker(int rides) {
        this.rides = rides;
    }

    @Override
    public LocalDateTime getLastVisit() {
        return lastVisit;
    }


    @Override
    public int getRideAmount() {
        return rides;
    }
}
