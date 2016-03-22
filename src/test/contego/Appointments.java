package test.contego;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tutorialspoint.User;
@XmlRootElement(name = "company")
public class Appointments implements Serializable {

   private static final long serialVersionUID = 1L;
   private int id;
   private String dateHour;
   private int officerID;

   public Appointments(){}

   public Appointments(int id, String dateHour, int officerID){
      this.id = id;
      this.dateHour =dateHour;
      this.officerID=officerID;
   }
   
   	   public int getId() {
	      return id;
	   }
	   @XmlElement
	   public void setId(int id) {
	      this.id = id;
	   }
	   
   	   public String getDateHour() {
	      return dateHour;
	   }
	   @XmlElement
	   public void setDateHour(String dateHour) {
	      this.dateHour = dateHour;
	   }
	   
   	   public int getOfficerID() {
	      return officerID;
	   }
	   @XmlElement
	   public void setOfficerID(int officerID) {
	      this.officerID = officerID;
	   }
}
