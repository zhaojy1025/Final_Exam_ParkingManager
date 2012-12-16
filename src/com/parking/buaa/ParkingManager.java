package com.parking.buaa;

import java.util.ArrayList ;
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

    public void PrintParkingAssistantsInfo(){

    }


}
