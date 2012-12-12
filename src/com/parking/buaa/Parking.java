package com.parking.buaa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 上午6:48
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private Map <Ticket, Car>parkedCarlist=new HashMap<Ticket,Car>();
    private Integer  maxParkingNum;

    public Parking(int maxParkingNum) {
        this.maxParkingNum =maxParkingNum;
    }

    public int ShowRemainVolume(){
        return maxParkingNum-parkedCarlist .size() ;
    }

    public float ShowUsingRate(){
        return (1-(float )parkedCarlist.size()/(float)maxParkingNum);
    }

    public Ticket  StoringCar(Car car,int parkinglotnumber) throws NoPositionException   {
        if(ShowRemainVolume() ==0)
            throw new NoCarException("车库无车位！");
        Ticket ticket = new Ticket(parkinglotnumber );
        parkedCarlist .put(ticket ,car);
        return ticket ;
    }

    public Car  GetCar(Ticket ticket ) {
        if (parkedCarlist.containsKey(ticket)) {
            return parkedCarlist.remove(ticket);
        }
        return null;
    }


}
