package repository;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.google.protobuf.Empty;
import com.mysql.cj.exceptions.RSAException;

import models.deptmodel;
import models.employee;
            //Aay interface no referance a bcos interface no object nai bnto ref bnj
@Repository("deptrepository")       // aay interface a deptRepo
public class deptRepoIMPL implements deptRepo {

	List<deptmodel> deptlist;
	List<Object[]> ListOBJ;
	List<employee> emplist;
	@Autowired // autowired aay automatically internally object create krj......
	JdbcTemplate template;
	
	@Override
	public boolean isadddept(deptmodel model) {
		  int value=template.update("insert into dept values('0',?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,model.getName());
			}
			  
		  });
		return value>0?true:false;
	}

	@Override
	public List<deptmodel> getallDept() {
		deptlist=template.query(" select * from dept",new RowMapper<deptmodel>(){

			@Override
			public deptmodel mapRow(ResultSet rs, int rowNum) throws SQLException {
				deptmodel dm=new deptmodel();
				  dm.setDeptid(rs.getInt(1));
				  dm.setName(rs.getString(2));
				return dm;
			}

			
		});
		return deptlist.size()>0?deptlist:null;
	}

	@Override
	public boolean isDeptDeletebyID(int did) {
		int value= template.update("delete from dept where deptid=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, did);
				
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public boolean isDeptUpdate(deptmodel model) {
		int value=template.update("update dept set name=? where deptid=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, model.getName());
				ps.setInt(2,model.getDeptid());
				
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public List<deptmodel> getDeptbyID(int did) {
		 deptlist=template.query("select * from dept where deptid="+did, new RowMapper<deptmodel>(){

			@Override
			public deptmodel mapRow(ResultSet rs, int rowNum) throws SQLException {
				deptmodel d=new deptmodel();
				d.setDeptid(rs.getInt(1));
				d.setName(rs.getString(2));
				return d;
			}		 
		 });
		return deptlist.size()>0?deptlist:null;
	}

	@Override
	public boolean isaddemployee(employee model) {
		int value=template.update("insert into employee values('0',?,?,?,?)",new  PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
			   ps.setString(1,model.getEmpname());	
			   ps.setString(2, model.getEmpemail());
			   ps.setString(3, model.getEmpcontact());
			   ps.setInt(4, model.getDeptid());
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public List<employee> getallemp() {
		 emplist=template.query("select * from employee", new RowMapper<employee>(){

			@Override
			public employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				employee e= new employee();
				 e.setEmpid(rs.getInt(1));
				 e.setEmpname(rs.getString(2));
				 e.setEmpemail(rs.getString(3));
				 e.setEmpcontact(rs.getString(4));
				 e.setDeptid(rs.getInt(5));
				return e;
			}
			 
		 });
		return emplist.size()>0?emplist:null;
	}

	@Override
	public boolean isdeleteEmployee(int eid) {
		int value=template.update("delete from employee where eid=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, eid);
				
			}
			
			
		});
		return value>0?true:false;
	}

	@Override
	public boolean isUpdateSemployee(employee model) {
		int value=template.update("update employee set name=?,email=?,contact=?,deptid=? where eid=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
		          ps.setString(1, model.getEmpname());
				ps.setString(2, model.getEmpemail());
				ps.setString(3,model.getEmpcontact());
				ps.setInt(4,model.getDeptid());
				ps.setInt(5, model.getEmpid());
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public List<employee> getSearchdata(String str) {
		 emplist=template.query("select * from employee where name like '%"+str+"%'", new RowMapper<employee>(){

				@Override
				public employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					employee e= new employee();
					 e.setEmpid(rs.getInt(1));
					 e.setEmpname(rs.getString(2));
					 e.setEmpemail(rs.getString(3));
					 e.setEmpcontact(rs.getString(4));
					 e.setDeptid(rs.getInt(5));
					return e;
				}
				 
			 });
			return emplist.size()>0?emplist:null;
		
	}

	@Override
	public List<Object[]> getallempusingOBJ() {
              ListOBJ=template.query("select e.name,e.email,e.contact,d.name,e.eid,d.deptid  from employee e inner join dept d on d.deptid=e.deptid",new RowMapper<Object[]>() {
            Object [] obj;
				@Override
				public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					 obj=new Object[] 
							{							
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getInt(6)
					        };	
					return obj;
				}   	  
              });
		return ListOBJ.size()>0?ListOBJ:null;
	}

	@Override
	public List<Object[]> getdeptwiseEmp(int id) {
		String sql="select e.name,e.email,e.contact,d.name from employee e inner join dept d on d.deptid=e.deptid where d.deptid="+id+"";
		ListOBJ=template.query(sql, new RowMapper<Object[]>() {
       Object[] obj;
			@Override
			public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				obj=new Object[] {
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					
				};
				return obj;
			}
			
		});
		return ListOBJ.size()>0?ListOBJ:null;
	}
	
}
	
