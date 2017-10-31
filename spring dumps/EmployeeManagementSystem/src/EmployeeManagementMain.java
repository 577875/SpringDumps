import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.employeemanagement.config.EmployeeManagementConfig;
import com.cts.employeemanagement.exception.EmployeeManagementException;
import com.cts.employeemanagement.service.EmployeeManagementService;


/**
 *
 */

public class EmployeeManagementMain {

	/**
	 * @param args
	 * @throws EmployeeManagementException
	 */
	public static void main(String[] args) throws EmployeeManagementException {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				EmployeeManagementConfig.class);

		EmployeeManagementService employeeManagementService=
				applicationContext.getBean(EmployeeManagementService.class);

employeeManagementService.updateEmployeeLocation(1001, "XX");

	}

}
