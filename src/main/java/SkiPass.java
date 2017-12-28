import java.time.DayOfWeek;
import java.time.LocalDateTime;

public abstract class SkiPass implements ISkiPass {
    boolean blocked;
    ISkiPassChecker skiPassChecker;
    int id;

    public SkiPass(ISkiPassChecker skiPassChecker){
        id = Utils.setNewSkiPassId();
        this.skiPassChecker = skiPassChecker;
    }

    @Override
    public void block() {
        blocked = true;
    }

    @Override
    public void unblock() {
        blocked = false;
    }

    @Override
    public int getId() {
        return id;
    }


    @Override
    public LocalDateTime getLastVisit() {
        return skiPassChecker.getLastVisit();
    }

    @Override
    public int getRideAmount() {
        return skiPassChecker.getRideAmount();
    }

    @Override
    public String toString() {
        return "SkiPass{" +
                "blocked=" + blocked +
                ", lastVisit=" + skiPassChecker.getLastVisit() +
                ", rides=" + skiPassChecker.getRideAmount() +
                ", id=" + id +
                '}';
    }
}
