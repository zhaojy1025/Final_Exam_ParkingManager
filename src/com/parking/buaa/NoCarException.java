package com.parking.buaa;

/**
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 12-11-18
 * Time: 下午9:22
 * To change this template use File | Settings | File Templates.
 */
public class NoCarException extends RuntimeException  {
    public NoCarException(String s) {
        super(s);
    }
}
