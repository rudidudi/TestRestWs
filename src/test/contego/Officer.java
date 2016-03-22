package test.contego;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tutorialspoint.User;
@XmlRootElement(name = "officer")
public class Officer implements Serializable {

   private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private int companyID;

   public Officer(){}

   public Officer(int id, String name, int companyID){
      this.id = id;
      this.name = name;
      this.companyID=companyID;
   }
   
   public int getId() {
	      return id;
	   }
	   @XmlElement
	   public void setId(int id) {
	      this.id = id;
	   }
	   public String getName() {
	      return name;
	   }
	   @XmlElement
	      public void setName(String name) {
	      this.name = name;
	   }
	   public int getCompanyID() {
		      return companyID;
	   }
	   @XmlElement
	   public void setCompanyID(int companyID) {
	      this.companyID = companyID;
	   }


	   @Override
	   public boolean equals(Object object){
	      if(object == null){
	         return false;
	      }else if(!(object instanceof User)){
	         return false;
	      }else {
	         Officer officer = (Officer)object;
	         if(id == officer.getId()
	            && name.equals(officer.getName())
	            && companyID==officer.getCompanyID()
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }
}