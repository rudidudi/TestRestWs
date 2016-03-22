package test.contego;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.tutorialspoint.User;

@Path("/CompanyService")
public class CompanyService {
	
   CompanyDao companyDao = new CompanyDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";


   @GET
   @Path("/companies")
   @Produces(MediaType.APPLICATION_XML)
   public List<Company> getCompanies(){
      return companyDao.getAllCompanies();
   }
   
   @GET
   @Path("/companies/id/{companyid}")
   @Produces(MediaType.APPLICATION_XML)
   public Company getCompany(@PathParam("companyid") int companyid){
      return companyDao.getCompany(companyid);
   }
   
   @GET
   @Path("/companies/name/{companyname}")
   @Produces(MediaType.APPLICATION_XML)
   public List<Company> getCompanyByName(@PathParam("companyname") String companyname){
      return companyDao.getCompanyByName(companyname);
   }
   
   @GET
   @Path("/companies/officers/{companyid}")
   @Produces(MediaType.APPLICATION_XML)
   public List<Officer> getOfficers(@PathParam("companyid") int companyid){
      return companyDao.getOfficers(companyid);
   }
   
   @GET
   @Path("/officers")
   @Produces(MediaType.APPLICATION_XML)
   public List<Officer> getOfficers(){
      return companyDao.getAllOfficers();
   }
   
   @GET
   @Path("/officers/appointments/{officerID}")
   @Produces(MediaType.APPLICATION_XML)
   public List<Appointments> getAppointmentsByOff(@PathParam("officerID") int officerID){
      return companyDao.getAppointmentsByOffID(officerID);
   }
}