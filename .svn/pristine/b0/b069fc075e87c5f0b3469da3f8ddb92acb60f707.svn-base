package com.oa.text;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.dao.impl.RoleDaoImpl;
import com.oa.entity.Depertment;
import com.oa.service.DepertmentService;
import com.oa.service.impl.DepertmentServiceImpl;
import com.oa.util.DepertmentUtils;

public class Test_ {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void test() {
		DepertmentService ds = app.getBean(DepertmentServiceImpl.class);

		List<Depertment> list = ds.queryTop();
//			children(list,"|-");
			for(Depertment d :DepertmentUtils.getAllDepertment(list)){
				System.out.println(d.getDeptName());
			}

		// List<Depertment> list =ds.queryAll();
		// for(Depertment d :list){
		// System.out.println(d.getDeptName());
		// }
	}
	public void children(Collection<Depertment> list,String str){
		for(Depertment d:list){
			System.out.println(str+d.getDeptName());
			children(d.getDeptDown(),"  "+str);
		}
	}
//	public void  children( Depertment d, DepertmentService ds,String in) {
//		System.out.println(in+d.getDeptName());
//		for(Depertment de :ds.queryChildren(d.getDeptId())){
//			children( de,ds,"  "+in);
//		}
//		
//	}

	@Test
	public void testclass() {
		// new Image();
		new RoleDaoImpl();
	}
	/*
	 * @Test public void pass() throws Exception{ FileReader fr = new
	 * FileReader("E:/Desktop/ss.txt"); char[] cbuf = new char[1024];
	 * fr.read(cbuf); String text = new String(cbuf); String[] strs =
	 * text.split(";"); Class.forName("com.mysql.jdbc.Driver"); Connection conn
	 * =
	 * DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my","root","");
	 * for(int i =0;i<strs.length-1;i++){ String[] st = strs[i].split(",");
	 * System.out.println(Arrays.toString(st)); in(conn,st); } } public void
	 * in(Connection conn ,String[] strs) throws Exception{ Statement stat =
	 * conn.createStatement(); String ss = strs.length>=4?strs[3]:null; int i =
	 * stat.executeUpdate(
	 * "INSERT INTO `password_tab` (`description`, `loginname`, `password`, `password2`) VALUES ( '"
	 * +strs[0]+"', '"+strs[1]+"', '"+strs[2]+"', '"+ss+"')");
	 * System.out.println(i); }
	 */
}
