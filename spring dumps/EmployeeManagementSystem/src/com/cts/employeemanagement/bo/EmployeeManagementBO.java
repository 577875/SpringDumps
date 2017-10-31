/**
 *
 */
package com.cts.employeemanagement.bo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.employeemanagement.dao.EmployeeManagementDAO;
import com.cts.employeemanagement.exception.EmployeeManagementException;


@Component
public class EmployeeManagementBO {

	@Autowired
	private EmployeeManagementDAO employeeManagementDAO;

	@Autowired
	MessageSource messageSource;

	/**
	 * @param employeeId
	 * @param transferLocation
	 * @throws EmployeeManagementException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateEmployeeLocation(int employeeId, String transferLocation) throws EmployeeManagementException
	{
        String eligible=null;

       eligible=getTransferEligiblityStatus(transferLocation);

       if(eligible.equalsIgnoreCase("Y"))
       {
           employeeManagementDAO.updateEmployeeLocation(employeeId, transferLocation);
       }

       else
       {
    	   throw new EmployeeManagementException("Tranfer is not Eligible for this location");
       }

	}

	/**
	 * @param transferLocation
	 * @return String
	 * @throws EmployeeManagementException
	 */
	public String getTransferEligiblityStatus(String transferLocation) throws EmployeeManagementException
	{
       String eligibilityStatus=null;

try
{
     eligibilityStatus=messageSource.getMessage(transferLocation, null, Locale.US);
}
catch(NoSuchMessageException e)
{
	throw new EmployeeManagementException("Invalid location");
}

		return eligibilityStatus;

	}

}
