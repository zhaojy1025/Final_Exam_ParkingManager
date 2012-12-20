import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public class FirstAvailableParkingLotChooser implements Parkinglotchooser {
    @Override
    public Parking getParkinglot(List<Parking> parkinglots){
        for(Parking parkinglot:parkinglots){
            if(parkinglot.ShowRemainVolume()>0) return parkinglot;
        }
        throw new NoPositionException("车库已满！");
    }
}
