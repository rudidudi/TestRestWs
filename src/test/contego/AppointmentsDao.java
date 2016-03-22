package test.contego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsDao {
   public List<Appointments> getAllAppointments(){
      List<Appointments> appointmentsList = null;
      try {
         File file = new File("appointments.dat");
         if (!file.exists()) {
        	 
        	 appointmentsList = new ArrayList<Appointments>();
        	 Appointments appointments = new Appointments(1, "05/01/2016 13:00", 1);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(2, "06/01/2016 13:00", 1);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(3, "05/01/2016 13:00", 2);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(4, "06/01/2016 13:00", 2);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(5, "05/01/2016 13:00", 3);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(6, "06/01/2016 13:00", 3);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(7, "05/01/2016 13:00", 4);
        	 appointmentsList.add(appointments);
        	 appointments = new Appointments(8, "05/01/2016 13:00", 5);
        	 appointmentsList.add(appointments);

             saveAppointmentsList(appointmentsList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            appointmentsList = (List<Appointments>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return appointmentsList;
   }

   public Appointments getAppointments(int id){
      List<Appointments> appointments = getAllAppointments();

      for(Appointments app: appointments){
         if(app.getId() == id){
            return app;
         }
      }
      return null;
   }
   
   private void saveAppointmentsList(List<Appointments> appointmentList){
	      try {
	         File file = new File("appointments.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);		
	         oos.writeObject(appointmentList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

}
