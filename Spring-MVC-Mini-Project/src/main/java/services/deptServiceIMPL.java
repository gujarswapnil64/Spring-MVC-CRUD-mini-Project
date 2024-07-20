package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.deptmodel;
import models.employee;
import repository.deptRepo;
import repository.deptRepoIMPL;

@Service("deptservices")
public class deptServiceIMPL implements  deptService{

	@Autowired
	deptRepo deptrepository;
	@Override
	public boolean isadddept(deptmodel model) {
		
		return deptrepository.isadddept(model);
	}
	@Override
	public List<deptmodel> getallDept() {
		
		return deptrepository.getallDept();
	}
	@Override
	public boolean isDeptDeletebyID(int did) {
		
		return deptrepository.isDeptDeletebyID(did);
	}
	@Override
	public boolean isDeptUpdate(deptmodel model) {
		
		return deptrepository.isDeptUpdate(model);
	}
	@Override
	public List<deptmodel> getDeptbyID(int did) {
		return deptrepository.getDeptbyID(did);
	}
	@Override
	public boolean isaddemployee(employee model) {
		
		return deptrepository.isaddemployee(model);
	}
	@Override
	public List<employee> getallemp() {
	
		return deptrepository.getallemp();
	}
	@Override
	public boolean isdeleteEmployee(int eid) {
		
		return deptrepository.isdeleteEmployee(eid);
	}
	@Override
	public boolean isUpdateSemployee(employee model) {
	
		return deptrepository.isUpdateSemployee(model);
	}
	@Override
	public List<employee> getSearchdata( String str) {
		
		return deptrepository.getSearchdata(str);
	}
	@Override
	public List<Object[]> getallempusingOBJ() {
		
		return deptrepository.getallempusingOBJ();
	}
	@Override
	public List<Object[]> getdeptwiseEmp(int id) {
		
		return deptrepository.getdeptwiseEmp(id);
	}

}
