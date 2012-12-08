import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test  ;
import com.parking.buaa.*;
import java.util.ArrayList ;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-12-5
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest {
    ParkingManager  parkingmanager;
    List<Parking>  parkinglots1;
    List<Parking>  parkinglots2;
    @Before
    public void setup() {
        parkinglots1= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(30-i*10);
            parkinglots1 .add(parkinglot);
        }
        parkinglots2= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(50-i*10);
            parkinglots2 .add(parkinglot);
        }

        List<ParkingAssistant >  parkingassistants;
        parkingassistants = new ArrayList<ParkingAssistant>() ;
        parkingassistants .add( new ParkingAssistant(parkinglots1,new LeastUsedAvailableParkingLotChooser()));
        parkingassistants .add( new ParkingAssistant(parkinglots2,new FirstAvailableParkingLotChooser()));

        parkingmanager=new ParkingManager(parkinglots1, new MaxAvailableParkingLotChooser(), parkingassistants) ;
    }

    @Test
    public void storing_car_by_parkingassistant(){
        Car car=new Car();
        parkingmanager .StoringCarByParkingAssistant(car,1);
        Assert.assertEquals(49 ,parkinglots2.get(0).ShowRemainVolume());
    }
}
