package com.parking.buaa;
import com.sun.xml.internal.bind.v2.model.core.ID;

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
    private int id;
    private final Parkinglotchooser  parkingLotChooser;

    public int getId() {
        return id;
    }

    public ParkingAssistant(List parkinglots,Parkinglotchooser parkingLotChooser,int id ) {
        this.parkinglots =parkinglots ;
        this.parkingLotChooser =parkingLotChooser ;
        this.id=id;
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
        System.out.printf("\t总车位数：");
        System.out.println( totalinused);
        System.out.printf("\t总空位数：");
        System.out.println(totalavailable );
    }

    public Ticket  StoringCar(Car car )  {
        return parkingLotChooser.getParkinglot(parkinglots ).StoringCar(car) ;
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
