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
    List<Parking>  parkinglots3;
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

        parkinglots3= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(10-i*5);
            parkinglots3 .add(parkinglot);
        }

        List<ParkingAssistant >  parkingassistants;
        parkingassistants = new ArrayList<ParkingAssistant>() ;
        parkingassistants .add( new ParkingAssistant(parkinglots1,new LeastUsedAvailableParkingLotChooser()));
        parkingassistants .add( new ParkingAssistant(parkinglots2,new FirstAvailableParkingLotChooser()));

        parkingmanager=new ParkingManager(parkinglots3, new MaxAvailableParkingLotChooser(), parkingassistants) ;
    }

    @Test
    public void storing_car_by_parkingassistant_success(){
        Car car=new Car();
        int parkingboynumber=1;
        parkingmanager .StoringCarByParkingAssistant(car,parkingboynumber);
        Assert.assertEquals(49 ,parkinglots2.get(0).ShowRemainVolume());
    }

    @Test
    public void getting_car_by_parkingassistant_success(){
        Car car=new Car();
        int parkinglotnumber=1;
        Ticket ticket =parkingmanager .StoringCarByParkingAssistant(car,parkinglotnumber);
        Assert.assertSame(car, parkingmanager .GetCarByParkingAssistant(ticket));
    }

    @Test    (expected = NoParkingAssistantException .class )
    public void storing_car_by_parkingassistant_fail(){
        Car car=new Car();
        int parkingboynumber=2;
        parkingmanager .StoringCarByParkingAssistant(car,parkingboynumber);
        Assert.assertFalse(true);
    }
}
