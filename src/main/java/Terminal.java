import java.util.ArrayList;

public class Terminal {
    private ArrayList<ISkiPass> skiPasses;
    private SkiPassFactory skiPassFactory;
    public Terminal(SkiPassFactory skiPassFactory){
        skiPasses = new ArrayList<>();
        this.skiPassFactory = skiPassFactory;
    }
    boolean block(int id){
        for(ISkiPass skiPass: skiPasses){
            if(skiPass.getId() == id){
                skiPass.block();
                return true;
            }
        }
        return false;
    }

    public ArrayList<ISkiPass> getSkiPasses() {
        return skiPasses;
    }

    boolean unblock(int id){
        for(ISkiPass skiPass: skiPasses){
            if(skiPass.getId() == id){
                skiPass.unblock();
                return true;
            }
        }
        return false;
    }

    ISkiPass createSkiPass(SkiPassType skiPassType, ISkiPassChecker checker){
        ISkiPass skiPass = skiPassFactory.createSkiPass(skiPassType, checker);
        skiPasses.add(skiPass);
        return skiPass;
    }

}
