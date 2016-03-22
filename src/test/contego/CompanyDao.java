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

public class CompanyDao extends OfficerDao {
   public List<Company> getAllCompanies(){
      List<Company> companyList = null;
      try {
         File file = new File("Companies.dat");
         if (!file.exists()) {
        	 
        	 companyList = new ArrayList<Company>();
        	 Company company = new Company(1, "XYZ", "Informatic",1980);
             companyList.add(company);
        	 company = new Company(2, "ABC", "Informatic",1990);
             companyList.add(company);
        	 company = new Company(3, "QWE", "Pharmaceutical",1980);
             companyList.add(company);
             company = new Company(4, "XYZ", "Pharmaceutical",1980);
             companyList.add(company);

             saveCompanyList(companyList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            companyList = (List<Company>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return companyList;
   }

   public Company getCompany(int id){
      List<Company> company = getAllCompanies();

      for(Company comp: company){
         if(comp.getId() == id){
            return comp;
         }
      }
      return null;
   }
   
   public List<Company> getCompanyByName(String name){
      List<Company> company = getAllCompanies();
      List<Company> returnCompany = new ArrayList<Company>();
      for(Company comp: company){
         if(comp.getName().toLowerCase().contains(name.toLowerCase())){
        	 returnCompany.add(comp);
         }
      }
      return returnCompany;
   }
   
   public List<Officer> getOfficers(int id){
	      List<Officer> officer = getAllOfficers();
	      List<Officer> returnOfficer = new ArrayList<Officer>();

	      for(Officer off: officer){
	         if(off.getCompanyID()==id){
	        	 returnOfficer.add(off);
	         }
	      }
	      return returnOfficer;
   }

   public int addCompany(Company pCompany){
      List<Company> companyList = getAllCompanies();
      boolean companyExists = false;
      for(Company comp: companyList){
         if(comp.getId() == pCompany.getId()){
        	companyExists = true;
            break;
         }
      }		
      if(!companyExists){
    	 companyList.add(pCompany);
         saveCompanyList(companyList);
         return 1;
      }
      return 0;
   }

   public int updateUser(Company pCompany){
      List<Company> companyList = getAllCompanies();

      for(Company company: companyList){
         if(company.getId() == pCompany.getId()){
            int index = companyList.indexOf(company);			
            companyList.set(index, pCompany);
            saveCompanyList(companyList);
            return 1;
         }
      }		
      return 0;
   }

   public int deleteUser(int id){
      List<Company> companyList = getAllCompanies();

      for(Company user: companyList){
         if(user.getId() == id){
            int index = companyList.indexOf(user);			
            companyList.remove(index);
            saveCompanyList(companyList);
            return 1;   
         }
      }		
      return 0;
   }

   private void saveCompanyList(List<Company> companyList){
      try {
         File file = new File("Companies.dat");
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);		
         oos.writeObject(companyList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
