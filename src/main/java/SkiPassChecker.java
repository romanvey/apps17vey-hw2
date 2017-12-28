import java.time.LocalDateTime;

abstract public class SkiPassChecker implements ISkiPassChecker {
    int rides;
    LocalDateTime lastVisit = null;

    public SkiPassChecker(SkiPassRidesAmount ridesAmount) {
        switch (ridesAmount){
            case ONE:
                rides = 1; break;
            case TEN:
                rides = 10; break;
            case TWENTY:
                rides = 20; break;
            case HUNDREAD:
                rides = 100; break;
            case ZERO:
                rides = 0; break;
            default:
                rides = 0; break;
        }
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
