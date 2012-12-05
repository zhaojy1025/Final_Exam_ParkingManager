import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test  ;
import com.parking.buaa.*;
import java.util.ArrayList ;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 上午6:49
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTest {
    ParkingAssistant parkingassistant;
    ParkingAssistant smartparkingassistant;
    List<Parking>  parkinglots;
    @Before
    public void setup() {
        parkinglots= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(20);
            parkinglots .add(parkinglot);
        }
        parkingassistant = new ParkingAssistant(parkinglots,new FirstAvailableParkingLotChooser() );
        smartparkingassistant = new ParkingAssistant(parkinglots,new MaxAvailableParkingLotChooser());
    }

    @Test
    public void storing_car_success(){
        Car car=new Car();
        Ticket ticket = parkingassistant.StoringCar(car);
        Assert.assertNotNull (ticket)  ;
    }

    @Test
    public void getting_car_success(){
        Car car=new Car();
        Ticket  ticket =parkingassistant .StoringCar(car);
        Assert.assertSame(car, parkingassistant .GetCar(ticket));
    }

    @Test ( expected = NoPositionException.class)
    public void storing_car_fail_no_parking_place(){
        List<Parking>  parkinglots1= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(1);
            parkinglots1 .add(parkinglot);
        }
        ParkingAssistant parkingAssistant1= new ParkingAssistant(parkinglots1,new FirstAvailableParkingLotChooser() );
        Car car=new Car();
        for(int i=0;i<3;i++)
            parkingAssistant1 .StoringCar(car);
        Assert.assertFalse(true);
    }

    @Test  (expected = NoCarException .class )
    public void getting_car_fail_no_car(){
        Ticket ticket= new Ticket() ;
        Car car=parkingassistant .GetCar(ticket );
        Assert.assertFalse(true);
    }

    @Test  (expected = NoCarException .class )
    public void getting_car_fail_not_correct_car(){
        Car car1=new Car();
        Car car2=new Car();
        parkingassistant .StoringCar(car1);
        Ticket ticket= parkingassistant .StoringCar(car2);
        parkingassistant.GetCar(ticket) ;
        parkingassistant.GetCar(ticket) ;
        Assert.assertFalse(true);
    }

    @Test
    public void storing_car_in_less_volume_parkingplace(){
        Car car=new Car();
        parkingassistant .StoringCar(car);
        parkingassistant .StoringCar(car);
        smartparkingassistant  .StoringCar(car);
        Assert.assertEquals(19 ,parkinglots.get(1).ShowRemainVolume());
    }

    @Test
    public void storing_car_in_same_volume_parkingplace(){
        Car car=new Car();
        smartparkingassistant .StoringCar(car);
        smartparkingassistant .StoringCar(car);
        smartparkingassistant .StoringCar(car);
        Assert.assertEquals(18 ,parkinglots.get(0).ShowRemainVolume());
    }

}
