package com.parking.buaa;
import java.util.ArrayList ;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-11-23
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class ParkingAssistant {

    protected  List parkinglots ;
    private final Parkinglotchooser  parkingLotChooser;

    public ParkingAssistant(List parkinglots,Parkinglotchooser parkingLotChooser ) {
        this.parkinglots =parkinglots ;
        this.parkingLotChooser =parkingLotChooser ;
    }


    public Ticket  StoringCar(Car car,int parkinglotnumber )  {
        return parkingLotChooser.getParkinglot(parkinglots ).StoringCar(car,parkinglotnumber) ;
    }

    public Car  GetCar(Ticket ticket ) throws NoCarException {
        Car car=new Car();
        for(int i=0;i<parkinglots.size() ;i++){
            Parking parkingplace= (Parking) parkinglots.get(i);
            car= parkingplace.GetCar(ticket);
            if(car!=null)
                return car;
        }
        throw new NoCarException("车库无此车！");
    }

}
