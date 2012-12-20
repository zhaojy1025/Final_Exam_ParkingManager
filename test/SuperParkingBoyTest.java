import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test  ;

import java.util.ArrayList ;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class SuperParkingBoyTest {
    ParkingAssistant superparkingassistant;
    List<Parking>  parkinglots;
    @Before
    public void setup() {
        parkinglots= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(30-i*10,i+1);
            parkinglots .add(parkinglot);
        }
        superparkingassistant = new ParkingAssistant(parkinglots,new LeastUsedAvailableParkingLotChooser(),1);
    }

    @Test
    public void storing_car_in_less_usingrate_parkingplace(){
        Car car=new Car();
        int parkinglotnumber =1;
        parkinglots.get(0).StoringCar(car);
        parkinglots.get(0).StoringCar(car);
        parkinglots.get(1).StoringCar(car);
        superparkingassistant.StoringCar(car);
        Assert.assertEquals(18 ,parkinglots.get(parkinglotnumber).ShowRemainVolume());
    }
}
