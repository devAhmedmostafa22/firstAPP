package es.hr.services.src.com.oracle.xmlns;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.googlecode.gwt.crypto.util.Sys;
import com.sun.jndi.toolkit.chars.BASE64Encoder;

import es.hr.services.src.com.oracle.xmlns.EmployeeService.DepartmentServiceProcess.DepartmentServiceProcess.DepartmentServiceProcessBindingStub;
import es.hr.services.src.com.oracle.xmlns.EmployeeService.DepartmentServiceProcess.DepartmentServiceProcess.Departmentserviceprocess_client_epLocator;
import es.hr.services.src.com.oracle.xmlns.pcbpel.adapter.db.DepartmentService.DepartmentServiceInput;
import es.hr.services.src.com.oracle.xmlns.pcbpel.adapter.db.DepartmentService.DepartmentServiceOutput;
import es.ux.scheduler.FollowupReminderScheduler;
import sun.security.x509.X509CertImpl;

public class Test {
 // 12333
	public static void main(String[] args) throws Exception {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		String atimeStamp =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)));
		DateFormat format = new SimpleDateFormat(pattern);
		Date currentDate = new Date();
		Date transferDateTmp = format.parse(new Date().toGMTString());
		String xxx=transferDateTmp.toGMTString();
		String xxxx=transferDateTmp.toString();
		
		 final SimpleDateFormat FORMATTER_DATETIME_NO_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        DateFormat dfETC = FORMATTER_DATETIME_NO_MS;
	        dfETC.setTimeZone(TimeZone.getTimeZone("GMT"));
	        String xx= dfETC.toString();
		
		
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    Date today = new Date();
		cal.setTime(today);
		cal.add(Calendar.DATE, 32);
		today = cal.getTime();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		Date currentDatePlus = cal.getTime();
		System.out.println("7"+3+3);
		System.out.println(7+3+"3");
		float x= (float) 10.5 ;
		int y= 5;
		y=(int) x;
		char g='A';
		System.out.println(g+111);
		Calendar c = Calendar.getInstance();
	    // Set the calendar to monday of the current week
	    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

	    DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
	        System.out.println(df.format(c.getTime()));
	        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	        if (dayOfWeek == Calendar.SUNDAY) { 
	        }
		FollowupReminderScheduler s=new FollowupReminderScheduler();
	//	s.callFromScheduler(null);
		// build input stream using certificate file
		InputStream inputStream = new FileInputStream("C:/Users/user/Desktop/Certificates_Old/certnew1.cer");
		 
		// build X509Certificate object
		X509Certificate certificate = new X509CertImpl(inputStream);
		 
		// get byte value of certificate
		byte[] value = certificate.getEncoded();
		 
		// encode the value
		BASE64Encoder encoder=new BASE64Encoder();
		String encodedValue = encoder.encode(value);
				
		 dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		dateFormat.parse("Tue Jul 13 00:00:00 CEST 2011");
		System.out.println(dateFormat.format(new Date()));
		
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.US);
		System.out.println(dateFormat1.format(new Date()));
		/*Employeeserviceprocess_client_epLocator locator = new Employeeserviceprocess_client_epLocator();
		EmployeeServiceProcessBindingStub stub = (EmployeeServiceProcessBindingStub)locator.getEmployeeServiceProcess_pt();
		
		EmployeeServiceInput input = new EmployeeServiceInput();
		EmployeeServiceOutput[] employees = stub.process(input);
		
		for(EmployeeServiceOutput employee : employees)
		{
			System.out.println("username = " + employee.getERP_USERNAME());
			System.out.println("status = " + employee.getEMP_STATUS());
			System.out.println("Firstname arabic = " + employee.getAR_NAME());
			System.out.println("Fullname arabic = " + employee.getAR_FULL_NAME());
			System.out.println("Firstname english = " + employee.getEN_FIRST_NAME());
			System.out.println("Full name english = " + employee.getEN_FULL_NAME());
			System.out.println("Employee number = " + employee.getEMPLOYEE_NUMBER());
			System.out.println("Employee email = " + employee.getEMP_EMAIL());
			System.out.println("Mobile number = " + employee.getMOBILE_NUMBER());
			System.out.println("National Id = " + employee.getNATIONAL_IDENTIFIER());
			System.out.println("Organization name = " + employee.getORGANIZATION_NAME());
			System.out.println("Department name = " + employee.getP_DEPARTEMENT_NAME());
			System.out.println("status = " + employee.getEMPLOYEE_TYPE());
			System.out.println("Position name = " + employee.getIS_MANAGER());
			System.out.println("Org Id = " + employee.getORGANIZATION_ID());
			System.out.println("--------------------------------");
			System.out.println();
		}*/
		
		Departmentserviceprocess_client_epLocator locator = new Departmentserviceprocess_client_epLocator();
		DepartmentServiceProcessBindingStub stub = (DepartmentServiceProcessBindingStub)locator.getDepartmentServiceProcess_pt();
		
		DepartmentServiceInput input = new DepartmentServiceInput();
		DepartmentServiceOutput[] departments = stub.process(input);
		
		for(DepartmentServiceOutput department : departments)
		{
			// try it
			System.out.println("organization arabic name = " + department.getARABIC_ORG_NAME());
			System.out.println("Child name = " + department.getD_CHILD_NAME());
			System.out.println("organization type = " + department.getORGANIZATION_TYPE());
			System.out.println("organization id child = " + department.getORGANIZATION_ID_CHILD());
			System.out.println("status = " + department.getStatus());
			System.out.println("--------------------------------");
			System.out.println();
		}
	}
}
