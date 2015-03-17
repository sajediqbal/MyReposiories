/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprogram;

/**
 *
 * @author Sajid
 */
public class Station {
    private static int stationCount;
    
    private String stationName;
    private ZoneName stationZone;
    private int regionCode;
    private int stationID;
    private int distance;
    private boolean isSpecial;
    
    static {
        setStationCount(0);
    }
    
    /**
	 * @return the stationCount
	 */
	public static int getStationCount() {
		return stationCount;
	}

	/**
	 * @param stationCount the stationCount to set
	 */
	public static void setStationCount(int stationCount) {
		Station.stationCount = stationCount;
	}

	Station(int stationID, String name, ZoneName stationZoneName, int regionCode, int distance, boolean isSpecial){
        this.stationName = name;
        this.stationZone = stationZoneName;
        this.regionCode=regionCode;
        this.distance = distance;
        this.stationID=stationID;
        this.isSpecial=isSpecial;
        setStationCount(getStationCount() + 1);
    }

    String getStationName(){
        return this.stationName;
    }
    
    ZoneName getStationZone(){
        return this.stationZone;
        
    }
    
    int getDistance(){
        return this.distance;
    }
    
    int getStationID(){
        return this.stationID;
    }
    
    int getRegionCode(){
        return this.regionCode;
    }
    
    boolean isSpecial(){
        return this.isSpecial;
    }
    
    void setStationName(String newStationName){
        this.stationName=newStationName;
    }
    
    void setStationZone(ZoneName newZoneName){
        this.stationZone=newZoneName;
        
    }
    
    void setDistance(int newDistance){
        this.distance=newDistance;
    }
    
    void setStationID(int newStationID){
        this.stationID=newStationID;
    }
    
    void setRegionCode(int newRegionCode){
        this.regionCode=newRegionCode;
    }
    
    void setSpecial(boolean newValue){
        this.isSpecial=newValue;
    }
       
}
