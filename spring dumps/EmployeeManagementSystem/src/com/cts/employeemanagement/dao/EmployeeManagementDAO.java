package com.cts.employeemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.employeemanagement.constants.SQLConstants;
import com.cts.employeemanagement.exception.EmployeeManagementException;


@Repository
public class EmployeeManagementDAO {


	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param employeeId
	 * @param transferLocation
	 * @throws EmployeeManagementException
	 */
	public void updateEmployeeLocation(int employeeId, String transferLocation) throws EmployeeManagementException
	{

		int numberOfSeats=0;
		jdbcTemplate.update(SQLConstants.UPDATE_EMPLOYEE_DETAILS,
				transferLocation,
				employeeId

				);

		numberOfSeats=jdbcTemplate.queryForObject(SQLConstants.RETRIEVE_NUMBER_OF_SEATS,Integer.class,transferLocation);

		if(numberOfSeats==0)
		{
			throw new EmployeeManagementException("No seats available. Raise for a new request");
		}

		else
		{
		jdbcTemplate.update(SQLConstants.UPDATE_SEAT_DETAILS,
				numberOfSeats-1,transferLocation
				);
		}
	}

}
