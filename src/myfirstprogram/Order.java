/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sajid
 */
package myfirstprogram;

import java.util.GregorianCalendar;

public class Order {
	private static int orderCount=0;
	public static Station []stations;

	private int orderID,
	orderTonnage,
	numberOfBags,
	orderDistance,
	stationID,
	regoinCode,
	indexOfStation,
	biltyNo,
	voucherNo,
	advancePayment,
	balancePayment;

	private double orderValue,
	orderCost;

	private float rate;


	private GregorianCalendar dateOrdered,
	dateBooked,
	dateDispatched,
	dateReturned,
	dateDelivered;

	private String orderStation,
	truckRegNo,
	driverName,
	driverCNIC,
	driverAgent,
	driverContact;

	private ZoneName zoneName;
	private OrderStatus orderStatus;

	//Constructor
	Order (int orderID, int orderTonnage, int numberOfBags, int stationID, GregorianCalendar dateOrdered) {
		this.setOrderID(orderID);
		this.setOrderTonnage(orderTonnage);
		this.setNumberOfBags(numberOfBags);
		this.setStationID(stationID);
		this.setOrderCost(0);
		this.rate=0.0f;
		this.setOrderValue(0);
		this.setDateOrdered(dateOrdered);
		this.setDateDispatched(null);
		this.setDateDelivered(null);
		this.setDateReturned(null);
		this.setTruckRegNo(null);
		this.setOrderStatus(OrderStatus.Pending);
		this.indexOfStation=Utilities.getIndexOfStation(stationID);
		this.setOrderDistance(Utilities.stations[this.indexOfStation].getDistance());
		this.setRegoinCode(Utilities.stations[this.indexOfStation].getRegionCode());
		this.setOrderStation(Utilities.stations[this.indexOfStation].getStationName());
		this.setZoneName(Utilities.stations[this.indexOfStation].getStationZone());
		orderCount++;
	}

	public static int getOrderCount(){
		return orderCount;
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID(){
		return this.orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int newOrderID){
		this.orderID=newOrderID;
	}

	/**
	 * @return the orderTonnage
	 */
	public int getOrderTonnage() {
		return orderTonnage;
	}

	/**
	 * @param orderTonnage the orderTonnage to set
	 */
	public void setOrderTonnage(int orderTonnage) {
		this.orderTonnage = orderTonnage;
	}

	/**
	 * @return the numberOfBags
	 */
	public int getNumberOfBags() {
		return numberOfBags;
	}

	/**
	 * @param numberOfBags the numberOfBags to set
	 */
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	/**
	 * @return the orderDistance
	 */
	public int getOrderDistance(){
		return this.orderDistance;
	}

	/**
	 * @param orderDistance the orderDistance to set
	 */
	public void setOrderDistance(int orderDistance) {
		this.orderDistance = orderDistance;
	}

	/**
	 * @return the stationID
	 */
	public int getStationID(){
		return this.stationID;
	}

	/**
	 * @param stationID the stationID to set
	 */
	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	/**
	 * @return the regoinCode
	 */
	public int getRegoinCode() {
		return regoinCode;
	}

	/**
	 * @param regoinCode the regoinCode to set
	 */
	public void setRegoinCode(int regoinCode) {
		this.regoinCode = regoinCode;
	}    

	public int getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(int voucherNo) {
		this.voucherNo = voucherNo;
	}

	public int getBiltyNo() {
		return biltyNo;
	}

	public void setBiltyNo(int biltyNo) {
		this.biltyNo = biltyNo;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getAdvancePayment() {
		return advancePayment;
	}

	public void setAdvancePayment(int advancePayment) {
		this.advancePayment = advancePayment;
	}

	public int getBalancePayment() {
		return balancePayment;
	}

	public void setBalancePayment(int balancePayment) {
		this.balancePayment = balancePayment;
	}

	/**
	 * @return the orderValue
	 */
	public double getOrderValue() {
		return orderValue;
	}

	/**
	 * @param orderValue the orderValue to set
	 */
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	/**
	 * @return the orderCost
	 */
	public double getOrderCost() {
		return orderCost;
	}

	/**
	 * @param orderCost the orderCost to set
	 */
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}    

	/**
	 * @return the orderRate
	 */
	public float getRate(){
		return this.rate;
	}

	/**
	 * @param orderRate the orderRate to set
	 */    
	private void setRate(){

		for(int i=0;i<Utilities.slabs.length;i++){

			if (
					(Utilities.slabs[i].getStartDate().before(this.dateDispatched)|Utilities.slabs[i].getStartDate().equals(this.dateDispatched))
					&&
					(Utilities.slabs[i].getEndDate().after(this.dateDispatched)|Utilities.slabs[i].getEndDate().equals(this.dateDispatched))

					){
				this.rate=Utilities.slabs[i].getZone(this.zoneName).getRate(this.orderDistance);

				break;
			}

		}


	}

	/**
	 * @return the dateOrdered
	 */        
	public GregorianCalendar getDateOrdered(){
		return this.dateOrdered;
	}

	/**
	 * @param dateOrdered the dateOrdered to set
	 */
	public void setDateOrdered(GregorianCalendar dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	/**
	 * @return the dateBooked
	 */
	public GregorianCalendar getDateBooked() {
		return dateBooked;
	}

	/**
	 * @param dateBooked the dateBooked to set
	 */
	public void setDateBooked(GregorianCalendar dateBooked) {
		this.dateBooked = dateBooked;
	}

	/**
	 * @return the dateDispatched
	 */
	public GregorianCalendar getDateDispatched() {
		return dateDispatched;
	}

	/**
	 * @param dateDispatched the dateDispatchedto set
	 */
	public void setDateDispatched(GregorianCalendar dateDispatched) {
		this.dateDispatched = dateDispatched;
	}

	/**
	 * @return the dateDelivered
	 */
	public GregorianCalendar getDateDelivered() {
		return dateDelivered;
	}

	/**
	 * @param dateDelivered the dateDelivered to set
	 */
	public void setDateDelivered(GregorianCalendar dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	/**
	 * @return the dateReturned
	 */
	public GregorianCalendar getDateReturned() {
		return dateReturned;
	}

	/**
	 * @param dateReturned the dateReturned to set
	 */
	public void setDateReturned(GregorianCalendar dateReturned) {
		this.dateReturned = dateReturned;
	}

	/**
	 * @return the orderStation
	 */
	public String getOrderStation() {
		return this.orderStation;
	}

	/**
	 * @param orderStation the orderStation to set
	 */
	public void setOrderStation(String orderStation) {
		this.orderStation = orderStation;
	}


	/**
	 * @return the truckRegNo
	 */
	public String getTruckRegNo() {
		return truckRegNo;
	}

	/**
	 * @param truckRegNo the truckRegNo to set
	 */
	public void setTruckRegNo(String truckRegNo) {
		this.truckRegNo = truckRegNo;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @return the driverCNIC
	 */
	public String getDriverCNIC() {
		return driverCNIC;
	}

	/**
	 * @param driverCNIC the driverCNIC to set
	 */
	public void setDriverCNIC(String driverCNIC) {
		this.driverCNIC = driverCNIC;
	}

	/**
	 * @return the driverAgent
	 */
	public String getDriverAgent() {
		return driverAgent;
	}

	/**
	 * @param driverAgent the driverAgent to set
	 */
	public void setDriverAgent(String driverAgent) {
		this.driverAgent = driverAgent;
	}

	/**
	 * @return the driverContact
	 */
	public String getDriverContact() {
		return driverContact;
	}

	/**
	 * @param driverContact the driverContact to set
	 */
	public void setDriverContact(String driverContact) {
		this.driverContact = driverContact;
	}


	public ZoneName getZoneName() {
		return zoneName;
	}

	public void setZoneName(ZoneName zoneName) {
		this.zoneName = zoneName;
	}


	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus(){
		return this.orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus newStatus){
		this.orderStatus = newStatus;
	}

	/**
	 * @void Book Order
	 */
	public void bookOrder(GregorianCalendar dateBooked){
		this.setDateBooked(dateBooked);
		this.setOrderStatus(OrderStatus.Booked);
	}

	/**
	 * @void Create Bilty
	 */
	public void createBilty(int biltyNo, String driverName, String driverCNIC, String driverAgent, String driverContact, String truckRegNo){
		this.setBiltyNo(biltyNo);
		this.setDriverName(driverName);
		this.setDriverCNIC(driverCNIC);
		this.setDriverAgent(driverAgent);
		this.setDriverContact(driverContact);
		this.setTruckRegNo(truckRegNo);
	}

	/**
	 * @void Create Payment Voucher
	 */
	public void createPaymentVoucher(int voucherNo, int advancePayment, double orderCost){
		this.setAdvancePayment(advancePayment);
		this.setVoucherNo(voucherNo);
		this.setOrderCost(orderCost);
	}	
	
	/**
	 * @void Dispatch Order
	 */
	public void dispatchOrder(GregorianCalendar dateDispatched){
		this.setDateDispatched(dateDispatched);
		this.setOrderStatus(OrderStatus.Dispatched);
		this.calculateRevenue();
	}
	
	/**
	 * @void Make Balance Payment
	 */
	public void makeBalancePayment(GregorianCalendar dateDelivered, GregorianCalendar dateReturned, int balancePayment){
		this.setDateDelivered(dateDelivered);
		this.setDateReturned(dateReturned);
		this.setBalancePayment(balancePayment);
		this.setOrderStatus(OrderStatus.Completed);
	}
	
	/**
	 * @void Calculate Revenue
	 */
	public void calculateRevenue(){
		this.setRate();
		this.setOrderValue(this.rate*this.orderDistance*this.orderTonnage);

		if(Utilities.stations[this.indexOfStation].isSpecial())
		{
			this.setOrderValue((double)this.orderValue+(this.orderValue*6/100));
		}

	}

	/**
	 * @void Finalize Order
	 */
	public void finalizeOrder(){
			this.setOrderStatus(OrderStatus.Billed);
	}

	public double getOrderProfit(){
		return this.getOrderValue()-this.getOrderCost();
	}




}
