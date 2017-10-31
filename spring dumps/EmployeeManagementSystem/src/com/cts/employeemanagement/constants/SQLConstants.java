/**
 *
 */
package com.cts.employeemanagement.constants;


public class SQLConstants {

	/**
	 *
	 */
	public static final String UPDATE_EMPLOYEE_DETAILS = "update employee_details set location_name=? where employee_id=?";
	public static final String RETRIEVE_NUMBER_OF_SEATS="select number_of_seats from location_details where location_name=?";
	public static final String UPDATE_SEAT_DETAILS = "update location_details set number_of_seats=? where location_name=?";

}
