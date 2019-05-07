package com.gangbin.crud.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gangbin.crud.bean.Employee;
import com.gangbin.crud.dao.DepartmentMapper;
import com.gangbin.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDAO {
	
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DepartmentMapper departmentMapper;
	
	//如果想要增加多个SQLsession，需要在applicationContext中设置MapperScanner的bean中，配置SqlSessionTemplateName
	//同时在autowired下面增加qualifier()
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test1(){
		List<Employee> list=employeeMapper.selectByExampleWithDep(null);
	//	List<Employee> list=employeeMapper.selectByExample(null);
		System.out.println(list);
		
	}
	//批量插入数据
	@Test
	public void test2(){
		DepartmentMapper  deMapper=sqlSession.getMapper(DepartmentMapper.class);
		System.out.println(deMapper);
 //		Department department=new Department(null,"nogi");
//		Department department1=new Department(null,"zaka");
//		Department department2=new Department(null,"keyaki");
//		Department department3=new Department(null,"hinata");
 //       deMapper.insertSelective(department);
//	    deMapper.insertSelective(department1);
//	    deMapper.insertSelective(department2);
//	    deMapper.insertSelective(department3);
	    System.out.println("完成");
		
	}
	//批量插入数据
	@Test
	public void test3(){
		EmployeeMapper  deMapper=sqlSession.getMapper(EmployeeMapper.class);
	    deMapper.insertSelective(new Employee("hori", "F", "hori@nogi.com", 1));
	    deMapper.insertSelective(new Employee("yoda", "F", "yoda@nogi.com", 1));
	    deMapper.insertSelective(new Employee("momoko", "F", "momo@nogi.com", 1));
	    deMapper.insertSelective(new Employee("erika", "F", "erika@nogi.com", 1));
	    deMapper.insertSelective(new Employee("mayan", "F", "mayan@nogi.com", 2));
	    deMapper.insertSelective(new Employee("macun", "F", "macun@nogi.com", 2));
	    deMapper.insertSelective(new Employee("manatu", "F", "manatu@nogi.com", 2));
	    deMapper.insertSelective(new Employee("minami", "F", "minami@nogi.com", 2));
	    deMapper.insertSelective(new Employee("neru", "F", "neru@nogi.com", 3));
	    deMapper.insertSelective(new Employee("yuka", "F", "yuka@nogi.com", 3));
	    deMapper.insertSelective(new Employee("hina", "F", "hina@nogi.com", 4));
	    deMapper.insertSelective(new Employee("mao", "F", "mao@nogi.com", 4));
	    System.out.println("完成");
		
	}

}
