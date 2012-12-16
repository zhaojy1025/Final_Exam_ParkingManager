package com.parking.buaa;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-12-15
 * Time: 下午9:18
 * To change this template use File | Settings | File Templates.
 */
public class ParkingDirector  extends ParkingAssistant  {
    private ParkingManager parkingManager ;
    public ParkingDirector(List parkinglots,Parkinglotchooser parkingLotChooser ,ParkingManager  ParkingManager,int id) {
        super(parkinglots,parkingLotChooser,id);
        this.parkingManager =ParkingManager;
    }

    public void PrintParkingManagerInfo(){
        System.out.printf("经理编号：");
        System.out.println(parkingManager  .getId());
        parkingManager .PrintParkinglotsInfo() ;
        parkingManager .PrintParkingAssistantsInfo() ;
        System.out.printf("总车位数：");
        System.out.println(parkingManager .GetTotoalnumber_unavailable() );
        System.out.printf("总空位数：");
        System.out.println(parkingManager .GetTotoalnumber_available() );
    }



}
