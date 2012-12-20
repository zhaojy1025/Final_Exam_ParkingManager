import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-12-5
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager extends ParkingAssistant  {
    protected   List parkingAssistants ;
    public ParkingManager(List parkinglots,Parkinglotchooser parkingLotChooser ,List ParkingAssistants,int id) {
        super(parkinglots,parkingLotChooser,id);
        this.parkingAssistants =ParkingAssistants;
    }

    public Ticket  StoringCarByParkingAssistant(Car car,int ParkingAssistantNumber) throws NoParkingAssistantException    {
        if(ParkingAssistantNumber>=parkingAssistants .size() )
           throw new NoParkingAssistantException("没有找到相应停车仔！") ;
        ParkingAssistant Parkingboy=(ParkingAssistant) parkingAssistants .get(ParkingAssistantNumber )   ;
          return Parkingboy.StoringCar(car );
    }

    public Car  GetCarByParkingAssistant(Ticket ticket ) throws NoParkingAssistantException {
        ParkingAssistant Parkingboy= (ParkingAssistant)parkingAssistants .get(ticket .getParkinglotnumber());
        return Parkingboy .GetCar(ticket );
    }

    public void PrintParkinglotsInfo(){
        int totalavailable=0;
        int totalinused=0;
        for(int i=0;i<parkinglots.size() ;i++){
            Parking parkingplace= (Parking) parkinglots.get(i);
            System.out.printf("\t停车场编号：");
            System.out.println(parkingplace.getId());
            System.out.printf("\t\t车位数：");
            System.out.println(parkingplace.getParkedCarlist() .size() );
            totalinused+=parkingplace.getParkedCarlist() .size();
            System.out.printf("\t\t空位数：");
            System.out.println(parkingplace.ShowRemainVolume() );
            totalavailable+=parkingplace.ShowRemainVolume();
        }
    }

    public void PrintParkingAssistantsInfo(){
        for(int i=0;i<parkingAssistants.size() ;i++){
            ParkingAssistant  parkingassistants= (ParkingAssistant )parkingAssistants.get(i);
            System.out.printf("停车仔编号：");
            System.out.println(parkingassistants .getId());
            parkingassistants.PrintParkinglotsInfo() ;
            System.out.printf("\t总车位数：");
            System.out.println(parkingassistants .GetTotoalnumber_unavailable() );
            System.out.printf("\t总空位数：");
            System.out.println(parkingassistants.GetTotoalnumber_available() );
        }

    }

    public int GetTotoalnumber_available(){
        int totalavailable=0;
        for(int i=0;i<parkinglots.size() ;i++){
            Parking parkingplace= (Parking) parkinglots.get(i);
            totalavailable+=parkingplace.ShowRemainVolume();
        }
        for(int i=0;i<parkingAssistants .size() ;i++){
            ParkingAssistant  parkingAssistant = (ParkingAssistant ) parkingAssistants.get(i);
            totalavailable+=parkingAssistant.GetTotoalnumber_available();
        }
        return totalavailable ;
    }

    public int GetTotoalnumber_unavailable(){
        int totalunavailable=0;
        for(int i=0;i<parkinglots.size() ;i++){
            Parking parkingplace= (Parking) parkinglots.get(i);
            totalunavailable+=parkingplace.getParkedCarlist() .size();
        }
        for(int i=0;i<parkingAssistants .size() ;i++){
            ParkingAssistant  parkingAssistant = (ParkingAssistant ) parkingAssistants.get(i);
            totalunavailable+=parkingAssistant.GetTotoalnumber_unavailable();
        }
        return totalunavailable ;
    }


}
