/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprogram;
import java.util.GregorianCalendar;
//import java.text.DateFormatSymbols;
//import static java.util.Calendar.*;

/**
 *
 * @author Sajid
 */
public class Slab {
    private static int slabCount;
    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;
    private Zone []zones = new Zone[5];
    
static{
    slabCount=0;
}
    
Slab(GregorianCalendar dateStart, GregorianCalendar dateEnd, Zone[]zones){
    this.dateStart=dateStart;
    this.dateEnd=dateEnd;
    this.zones=zones;
    slabCount++;
    
}   

static int getSlabCount(){
    return slabCount;
    
}

GregorianCalendar getStartDate(){
    return this.dateStart;
}

GregorianCalendar getEndDate(){
    return this.dateEnd;
}

Zone getZone(ZoneName zoneName){
	switch(zoneName){
	case South:
		return this.zones[0];

	case Center:
		return this.zones[1];

	case North:
		return this.zones[2];

	case Peshawar:
		return this.zones[3];

	case Quetta:
		return this.zones[4];
	default:
		return this.zones[0];
	}

}





}
