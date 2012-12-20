import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public class LeastUsedAvailableParkingLotChooser implements Parkinglotchooser{
    public Parking  getParkinglot(List<Parking> parkinglots){
        int maxsizeIndex=0;
        for(int i=1;i< parkinglots.size();i++){
            if(parkinglots.get(i).ShowUsingRate() > parkinglots.get(maxsizeIndex).ShowUsingRate())
                maxsizeIndex=i;
        }
        if(parkinglots.get(maxsizeIndex).ShowRemainVolume()==0) throw new NoPositionException("车库已满！");
        return   parkinglots.get(maxsizeIndex);
    }
}
