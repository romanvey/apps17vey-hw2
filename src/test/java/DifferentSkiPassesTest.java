import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DifferentSkiPassesTest {
    @Test
    public void DifferentSkiPassTypesTest() {
        System.out.println("Different SkiPassTypes test");
        SkiPassFactory factory = new SkiPassFactory();
        Terminal terminal = new Terminal(factory);
        ISkiPass skiPass1 = terminal.createSkiPass(SkiPassType.WEEKEND, new RideChecker(SkiPassRidesAmount.ONE));
        ISkiPass skiPass2 = terminal.createSkiPass(SkiPassType.WEEKDAY, new RideChecker(SkiPassRidesAmount.ONE));
        System.out.println(skiPass1);
        System.out.println(skiPass2);
        skiPass1.useRide(LocalDateTime.now());
        skiPass2.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        System.out.println(skiPass2);
    }

    @Test
    public void BlockSkiPassesTest() {
        System.out.println("Block test");
        SkiPassFactory factory = new SkiPassFactory();
        Terminal terminal = new Terminal(factory);
        ISkiPass skiPass1 = terminal.createSkiPass(SkiPassType.ALL, new RidePerDayChecker(SkiPassRidesAmount.TEN));
        System.out.println(skiPass1);

        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);


        terminal.block(skiPass1.getId());
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);


        terminal.unblock(skiPass1.getId());
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
    }

    @Test
    public void NoRidesTest() {
        System.out.println("No rides test");
        SkiPassFactory factory = new SkiPassFactory();
        Terminal terminal = new Terminal(factory);
        ISkiPass skiPass1 = terminal.createSkiPass(SkiPassType.ALL, new RideChecker(SkiPassRidesAmount.ONE));
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
    }

    @Test
    public void NoRidesPerDayTest() {
        System.out.println("No rides per day test");
        SkiPassFactory factory = new SkiPassFactory();
        Terminal terminal = new Terminal(factory);
        ISkiPass skiPass1 = terminal.createSkiPass(SkiPassType.ALL, new RidePerDayChecker(SkiPassRidesAmount.ONE));
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now().plusDays(1));
        System.out.println(skiPass1);
    }


    @Test
    public void NoRidesPerMonthTest() {
        System.out.println("No rides per month test");
        SkiPassFactory factory = new SkiPassFactory();
        Terminal terminal = new Terminal(factory);
        ISkiPass skiPass1 = terminal.createSkiPass(SkiPassType.ALL, new MonthRideChecker(SkiPassRidesAmount.ONE));
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now());
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now().plusDays(3));
        System.out.println(skiPass1);
        skiPass1.useRide(LocalDateTime.now().plusMonths(1));
        System.out.println(skiPass1);
    }
}
