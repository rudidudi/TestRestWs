package test.contego;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.tutorialspoint.User;

public class WSTester  {

   private Client client;
   private String REST_SERVICE_URL = "http://localhost:8080/testWSRest/rest/CompanyService";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   WSTester tester = new WSTester();

      tester.init();
      tester.testGetCompanies();
      tester.testGetCompanieyByName();
      tester.testGetCompaniesByID();
      tester.testGetAllOfficers();
      tester.testGetAllOfficersApp();

   }
   private void testGetCompanies(){
      GenericType<List<Company>> list = new GenericType<List<Company>>() {};
      List<Company> companies = client
         .target(REST_SERVICE_URL)
         .path("/companies")
         .request(MediaType.APPLICATION_XML)
         .get(list);
      String result = PASS;
      if(companies.isEmpty()){
         result = FAIL;
      }
      System.out.println("Test case name: testGetAllUsers, Result: " + result );
   }
   
   private void testGetCompanieyByName(){
	   
	      GenericType<List<Company>> list = new GenericType<List<Company>>() {};
	      
	      List<Company> companies = client
	         .target(REST_SERVICE_URL)
	         .path("/companies/name/{companyname}")
	         .resolveTemplate("companyname", "QWE")
	         .request(MediaType.APPLICATION_XML)
	         .get(list);
	      String result = PASS;
	      if(companies.isEmpty()){
	         result = FAIL;
	      }
	      System.out.println("Test case name: testGetAllUsers, Result: " + result );
   }

   private void testGetCompaniesByID(){}
   private void testGetAllOfficers(){}
   private void testGetAllOfficersApp(){}
}