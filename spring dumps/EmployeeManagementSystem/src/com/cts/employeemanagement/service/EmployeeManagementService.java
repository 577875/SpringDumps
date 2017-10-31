package com.cts.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employeemanagement.bo.EmployeeManagementBO;
import com.cts.employeemanagement.exception.EmployeeManagementException;


@Service
public class EmployeeManagementService {

	@Autowired
	private EmployeeManagementBO employeeManagementBO;

	/**
	 * @param employeeId
	 * @param transferLocation
	 * @throws EmployeeManagementException
	 */
	public void updateEmployeeLocation(int employeeId, String transferLocation) throws EmployeeManagementException
	{
		employeeManagementBO.updateEmployeeLocation(employeeId, transferLocation);
	}
}
