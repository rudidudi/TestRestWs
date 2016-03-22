package test.contego;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tutorialspoint.User;
@XmlRootElement(name = "company")
public class Company implements Serializable {

   private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private String sector;
   private int fundationYear;

   public Company(){}

   public Company(int id, String name, String sector, int fundationYear){
      this.id = id;
      this.name = name;
      this.sector = sector;
      this.fundationYear=fundationYear;
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
	   public String getSector() {
	      return sector;
	   }
	   @XmlElement
	   public void setSector(String sector) {
	      this.sector = sector;
	   }
	   public int getFundationYear() {
		      return fundationYear;
	   }
	   @XmlElement
	   public void setFundationYear(int fundationYear) {
	      this.fundationYear = fundationYear;
	   }

	   @Override
	   public boolean equals(Object object){
	      if(object == null){
	         return false;
	      }else if(!(object instanceof User)){
	         return false;
	      }else {
	         Company company = (Company)object;
	         if(id == company.getId()
	            && name.equals(company.getName())
	            && sector.equals(company.getSector())
	            && fundationYear==company.getFundationYear()
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }
}