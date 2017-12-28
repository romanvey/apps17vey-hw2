public class SkiPassFactory {
    ISkiPass createSkiPass(SkiPassType skiPassType, ISkiPassChecker checker){
        switch (skiPassType){
            case WEEKEND:
                return new WeekendSkiPass(checker);
            case WEEKDAY:
                return new WeekdaySkiPass(checker);
            case ALL:
                return new AllDaysSkiPass(checker);
        }
        return null;
    }
}
