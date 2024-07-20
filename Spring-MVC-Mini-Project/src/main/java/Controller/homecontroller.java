package Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel;

import models.deptmodel;
import models.employee;
import services.deptService;

@Controller
public class homecontroller {

	@Autowired
	deptService deptservices;
	
	@RequestMapping("/")
	public String homePage() {
		return "index";		
	}
	
	@RequestMapping("/adddepartment")
	public String adddeptpage() {
		return "adddept";
	}
	                       // aay internally obj crate krine bathyo setters methods nu kam internally kri lej.............
	@RequestMapping("/deptsave")
	public String savedept(deptmodel model,Map map) {
		
		boolean b=deptservices.isadddept(model);
		 if(b)
		 {
			map.put("msg","Dept Data Save Successfully......"); 
		 }
		 else {
			map.put("msg","Dept Not save for Database.....");
		}
		  return "adddept"; 
	}
	
	@RequestMapping("/viewalldepartment")
	public String viewalldept(Map<String,List<deptmodel>> map) {
		
		  List<deptmodel> deptdata=deptservices.getallDept();
  
		  map.put("dept", deptdata);
		 return "viewDept"; //viewDept.jsp
	}
    
	    // FIRST WAY.........................
	   // ename manually mangadu pdj ane Integer me convert kru pdj mnun
	     //  MVC a second simplest way banayel a 
//	@RequestMapping("/delD")
//	public String deptdelpage(HttpServletRequest request) {
//			int did=Integer.parseInt(request.getParameter("did"));
//			 System.out.println("Dept id:>"+did);
//		return "deldept";
//	}
	// SECOND WAY.........................
	@RequestMapping("/del")
	public String deptdelpage(@RequestParam("did") Integer did,Map<String,List<deptmodel>> map) {
			boolean b=deptservices.isDeptDeletebyID(did);
			if(b)
			{
				 List<deptmodel> deptdata=deptservices.getallDept();
				  
				  map.put("dept", deptdata);
				 
			}
			return "viewDept"; //viewDept.jsp 
	}
	
	@RequestMapping("/DUForm")
	public String updateformPage(@RequestParam("duid") Integer deptid,@RequestParam("dname") String dname,Model model){
		
		model.addAttribute("deptid",deptid);
		model.addAttribute("dname",dname);
		
		return "deptupdateform";
	}
	@RequestMapping("/Dupdate")
	public String deptUPDATEpage(deptmodel model,Map<String,List<deptmodel>> map) {
			boolean b=deptservices.isDeptUpdate(model);
			if(b)
			{
				 List<deptmodel> deptdata=deptservices.getallDept();
				  
				  map.put("dept", deptdata);
				 
			}
			return "viewDept"; //viewDept.jsp 
	}
	
	@RequestMapping("newemp")
	public String addemp(Map<String,List<deptmodel>> map) {
		 List<deptmodel> deptdata=deptservices.getallDept();
		  
		  map.put("dept", deptdata);
		return "addemployee";
	}
	
	@RequestMapping("/saveemp")
	public String newempsave(employee model ,Map<String, String> map) {
		boolean b= deptservices.isaddemployee(model);
		if(b)
		{
			map.put("msg", "Employee Added Successfully..");
		}
		else {
			map.put("msg", "Employee Not Added..");
		}
		return "addemployee";
	}
	
//	@RequestMapping("/viewemp")
//	public String viewemp(Map<String,List<employee>> map) {
//		 List<employee> emplist=deptservices.getallemp();
//		map.put("emplist", emplist);
//		 return "viewallEmployee";
//	}
	@RequestMapping("/viewemp")
	public String viewemp(Map<String,List<Object[]>> map) {
		 List<Object[]> emplist=deptservices.getallempusingOBJ();
		map.put("emplist", emplist);
		 return "viewallEmployee";
	}
	
	@RequestMapping("/empdel")
	public String empdelete(@RequestParam("empid") Integer eid,Map<String,List<Object[]>> map) {
		  boolean value=deptservices.isdeleteEmployee(eid);
		  if(value)
		  {
		  List<Object[]> emplist=deptservices.getallempusingOBJ();
			map.put("emplist", emplist);
		     }
		return "viewallEmployee";
	}
	
	@RequestMapping("/empupdateform")
	public String empupdatepage(@RequestParam("empid") Integer empid,@RequestParam("empname") String empname,@RequestParam("empemail") String empemail,@RequestParam("empcontact") String  empcontact,@RequestParam("name") String name,Model model,Map<String,List<deptmodel>> map) {
		
		model.addAttribute("empid",empid);
		model.addAttribute("empname",empname);
		model.addAttribute("empemail",empemail);
		model.addAttribute("empcontact",empcontact);
		model.addAttribute("deptname",name);
		
		List<deptmodel> deptdata=deptservices.getallDept();
		  
		  map.put("dept", deptdata);
		 return "empupdateJSPpage";
	}
	
	@RequestMapping("/empudetails")
	public String empupdationprocess(employee model,Map<String,List<Object[]>> map) {
		boolean b=deptservices.isUpdateSemployee(model);
		if(b)
		{
			 List<Object[]> emplist=deptservices.getallempusingOBJ();
				map.put("emplist", emplist);
		}
		return "viewallEmployee";
	}
	
	@RequestMapping("/VEmpByName")
	public String VEmpBySearch(Map<String,List<Object[]>> map) {
		
		 List<Object[]> emplist=deptservices.getallempusingOBJ();
			map.put("emplist", emplist);
		return "viewEmpbySearching";
	}
	
	@RequestMapping("/searchemp")
	public @ResponseBody String ajaxcallmethod(@RequestParam("str") String str) 
	{
		
		 List<employee> emplist=deptservices.getSearchdata(str);
			
			
			String t="<table style='background-color: white; padding:10px; font-size: 20px;' border='10' align='center' width='80%' >";
			t=t+"<tr><th>Emp Name</th><th>EmpEmail</th><th>Emp Contact</th>"
					+ "</tr>";
			
			if(emplist!=null)
			{
				for(employee e:emplist)
				{
					t=t+"<tr style='padding:8px;' align='center'>";
//					t=t+"<td>"+e.getEmpid()+"</td>";
					t=t+"<td>"+e.getEmpname()+"</td>";
					t=t+"<td>"+e.getEmpemail()+"</td>";
					t=t+"<td>"+e.getEmpcontact()+"</td>";
					
					t=t+"</tr>";
				}
			}
		return t;
	}
	
	@RequestMapping("/deptwiseemp")
	public String viewempdeptwisepage(Map<String,List<deptmodel>> map) {
	     List<deptmodel> dept=deptservices.getallDept();
		map.put("dept",dept);
		return "deptwiseviewemp";
	}
	
	@RequestMapping("deptsearchemp")
	public @ResponseBody String deptwiseempsearchpage(@RequestParam("str") Integer id) {
		     List<Object[]> deptempList=deptservices.getdeptwiseEmp(id); 
		     
		     String t="<table style='background-color: white;margin-top:20px; padding:10px; font-size: 20px;' border='10' align='center' width='80%' >";
				t=t+"<tr><th>Emp Name</th><th>EmpEmail</th><th>Emp Contact</th><th>Employee Department</th>"
						+ "</tr>";
						
					for(Object[] e:deptempList)
					{
						t=t+"<tr style='padding:10px;' align='center'>";

						t=t+"<td>"+e[0]+"</td>";
						t=t+"<td>"+e[1]+"</td>";
						t=t+"<td>"+e[2]+"</td>";
						t=t+"<td>"+e[3]+"</td>";
						
						t=t+"</tr>";
					}
				
		return t;
	}
	
	
	
	
}
