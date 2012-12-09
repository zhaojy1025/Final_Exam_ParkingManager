package com.parking.buaa;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-18
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class Ticket {


    public Ticket(int parkinglotnumber) {
        this.parkinglotnumber = parkinglotnumber;
    }

    private int parkinglotnumber;

    public void setParkinglotnumber(int parkinglotnumber) {
        this.parkinglotnumber = parkinglotnumber;
    }

    public int getParkinglotnumber() {
        return parkinglotnumber;
    }
}
