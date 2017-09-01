package javaclasses;

import java.util.HashMap;
import java.util.Map;

public class Coord {
    public int xcord;
    public int ycord;
    public Map<Coord,Coord> segment=new HashMap<Coord,Coord>();
    public Coord(int xcoordinate,int ycoordinate){
        this.xcord=xcoordinate;
        this.ycord=ycoordinate;
    }
    public void generatesegment(Coord x,Coord y){
     this.segment.put(x,y);
    }
    public int getXcord(){
        return xcord;
    }
    public int getYcord(){
        return ycord;
    }
}
