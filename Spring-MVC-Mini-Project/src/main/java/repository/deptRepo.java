package repository;

import java.util.List;

import models.deptmodel;
import models.employee;

public interface deptRepo {

	public boolean isadddept(deptmodel model);
	public List<deptmodel> getallDept();
	public boolean isDeptDeletebyID(int did);
	public boolean isDeptUpdate(deptmodel model);
	public List<deptmodel> getDeptbyID( int did);
	
	public boolean isaddemployee(employee model);
	 public List<employee> getallemp() ;
	 public boolean isdeleteEmployee(int eid);
	 public boolean isUpdateSemployee(employee model);
	 public List<employee> getSearchdata(String str) ;
	 public List<Object[]> getallempusingOBJ();
	 
	 public List<Object[]> getdeptwiseEmp(int id);
}
