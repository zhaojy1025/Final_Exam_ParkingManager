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
    private  List parkingAssistants ;
    public ParkingManager(List parkinglots,Parkinglotchooser parkingLotChooser ,List ParkingAssistants) {
        super(parkinglots,parkingLotChooser);
        this.parkingAssistants =ParkingAssistants;
    }

    public Ticket  StoringCarByParkingAssistant(Car car,int ParkingAssistantNumber) throws NoPositionException   {
        ParkingAssistant Parkingboy=(ParkingAssistant) parkingAssistants .get(ParkingAssistantNumber )   ;
          return Parkingboy.StoringCar(car,ParkingAssistantNumber );
    }

    public Car  GetCarByParkingAssistant(Ticket ticket ) throws NoCarException {

        ParkingAssistant Parkingboy= (ParkingAssistant)parkingAssistants .get(ticket .getParkinglotnumber());
        return Parkingboy .GetCar(ticket );
    }


}
