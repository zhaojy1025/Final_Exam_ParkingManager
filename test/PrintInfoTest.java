import org.junit.Before;
import org.junit.Test  ;

import java.util.ArrayList ;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-12-15
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public class PrintInfoTest {
    ParkingDirector parkingdirector;
    ParkingManager  parkingmanager;
    List<Parking>  parkinglots1;
    List<Parking>  parkinglots2;
    List<Parking>  parkinglots3;
    @Before
    public void setup() {
        parkinglots1= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(30-i*10,i+1);
            parkinglots1 .add(parkinglot);
        }
        parkinglots2= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(50-i*10,i+1);
            parkinglots2 .add(parkinglot);
        }

        parkinglots3= new ArrayList<Parking>();
        for(int i=0;i<2;i++){
            Parking parkinglot= new Parking(10-i*5,i+1);
            parkinglots3 .add(parkinglot);
        }

        List<ParkingAssistant >  parkingassistants;
        parkingassistants = new ArrayList<ParkingAssistant>() ;
        parkingassistants .add( new ParkingAssistant(parkinglots1,new LeastUsedAvailableParkingLotChooser(),1));
        parkingassistants .add( new ParkingAssistant(parkinglots2,new FirstAvailableParkingLotChooser(),2));

        parkingmanager=new ParkingManager(parkinglots3, new MaxAvailableParkingLotChooser(), parkingassistants,1) ;
        parkingdirector=new ParkingDirector(parkinglots3,new MaxAvailableParkingLotChooser(),parkingmanager ,1);

    }

    @Test
    public void Print_Parkinglots_info(){

        System.out.println("————————————————————————————————————");
        System.out.println("\t\t\t\t\t\t打印停车场消息");
        new ParkingAssistant(parkinglots1,new LeastUsedAvailableParkingLotChooser(),1).PrintParkinglotsInfo() ;
        System.out.println("————————————————————————————————————");
    }

    @Test
    public void Print_ParkingAssistants_info(){

        System.out.println("————————————————————————————————————");
        System.out.println("\t\t\t\t\t\t打印停车仔消息");
        parkingmanager.PrintParkingAssistantsInfo() ;
        System.out.println("————————————————————————————————————");
    }

    @Test
    public void Print_ParkingManager_info(){

        System.out.println("————————————————————————————————————");
        System.out.println("\t\t\t\t\t\t打印停车经理消息");
        parkingdirector .PrintParkingManagerInfo() ;
        System.out.println("————————————————————————————————————");
    }
}
