package com.parking.buaa;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-12-15
 * Time: 下午9:18
 * To change this template use File | Settings | File Templates.
 */
public class ParkingDirector  extends ParkingManager {
    private ParkingManager parkingManager ;
    public ParkingDirector(List parkinglots,Parkinglotchooser parkingLotChooser , List ParkingAssistants,ParkingManager  ParkingManager,int id) {
        super(parkinglots,parkingLotChooser,ParkingAssistants,id);
        this.parkingManager =ParkingManager;
    }

    public void PrintParkinglotsInfo(){
       System .out .printf("test");
    }

}
