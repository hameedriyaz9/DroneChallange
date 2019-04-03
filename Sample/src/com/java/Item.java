package com.java;

import java.time.LocalTime;

/**
 * @author 728332
 *
 */
public class Item {

	/**
	 * orderId
	 */
	private String orderId;
	
	/**
	 * direction
	 */
	private String[] direction;
	
	/**
	 * orderTime
	 */
	private LocalTime orderTime;
	
	/**
	 * timeTakenInMinutes
	 */
	private int timeTakenInMinutes;
	
	/**
	 * deliveredTime
	 */
	private LocalTime deliveredTime;
	
	/**
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return
	 */
	public String[] getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 */
	public void setDirection(String[] direction) {
		this.direction = direction;
	}

	/**
	 * @return
	 */
	public LocalTime getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime
	 */
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return
	 */
	public int getTimeTakenInMinutes() {
		return timeTakenInMinutes;
	}

	/**
	 * @param timeTakenInMinutes
	 */
	public void setTimeTakenInMinutes(int timeTakenInMinutes) {
		this.timeTakenInMinutes = timeTakenInMinutes;
	}

	/**
	 * @return
	 */
	public LocalTime getDeliveredTime() {
		return deliveredTime;
	}

	/**
	 * @param deliveredTime
	 */
	public void setDeliveredTime(LocalTime deliveredTime) {
		this.deliveredTime = deliveredTime;
	}
	
	
}
