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
public class Zone {
    private ZoneName zoneName;
    private float [] rates = new float [18];
    
    Zone(ZoneName zoneName, float[] rates){
        this.zoneName=zoneName;
        this.rates=rates;
        
    }
    
    ZoneName getZoneName(){
        return this.zoneName;
    }
    float getRate(int distance){
    	int i=0;
    	distance = distance>720 ? 720 : distance;
    	i = (int)Math.ceil((float)distance/40)-1;
        return rates[i];
    }

	
}
