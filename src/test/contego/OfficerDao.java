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

public class OfficerDao extends AppointmentsDao {
   public List<Officer> getAllOfficers(){
      List<Officer> officerList = null;
      try {
         File file = new File("Officers.dat");
         if (!file.exists()) {
        	 
        	 officerList = new ArrayList<Officer>();
        	 Officer officer = new Officer(1, "Mark",1);
        	 officerList.add(officer);
        	 officer = new Officer(2, "John",1);
        	 officerList.add(officer);
        	 officer = new Officer(3, "Rudi",2);
        	 officerList.add(officer);
        	 officer = new Officer(4, "Matt",3);
        	 officerList.add(officer);
        	 officer = new Officer(5, "Anna",4);
        	 officerList.add(officer);

             saveOfficerList(officerList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            officerList = (List<Officer>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return officerList;
   }
   
   public List<Appointments> getAppointmentsByOffID(int id){
	      List<Appointments> appointments = getAllAppointments();
	      List<Appointments> returnAppointments = new ArrayList<Appointments>();

	      
	      for(Appointments app: appointments){
	    	  
	         if(app.getOfficerID()==id){
	        	 returnAppointments.add(app);
	         }
	         
	      }
	      return returnAppointments;
   }
   
   

   private void saveOfficerList(List<Officer> officerList){
      try {
         File file = new File("Officers.dat");
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);		
         oos.writeObject(officerList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
