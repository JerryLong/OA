package com.oa.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import com.oa.entity.Depertment;

public class DepertmentUtils {

	/**
	 * 格式化部门列表。
	 * 
	 * @param queryAll
	 * @return
	 */
	public static List<Depertment> getAllDepertment(List<Depertment> queryTop) {
		
		List<Depertment> lists = new ArrayList<Depertment>();
		getName(lists, "|-",queryTop);
		System.out.println((lists==queryTop));
		return lists;
	}

	private static void getName(List<Depertment> lists, String str,Collection<Depertment> top) {
		
		for (Depertment d : top) {
			//使用另外对象，源对象在session中，修改的名字会跟新到数据库中
			Depertment temp  = new Depertment();
			temp.setDeptId(d.getDeptId());
			temp.setDeptName(str + d.getDeptName());
			lists.add(temp);
			getName(lists, "　" + str,d.getDeptDown());
		}
	}
	@Test
	public void md5() throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] buf = "1234".getBytes();
//		md5.update(buf);
		System.out.println(new BigInteger(md5.digest(buf)).toString(16));
		System.out.println(new BigInteger(DigestUtils.md5Digest(buf)).toString(16));
//		String str = DigestUtils.md5DigestAsHex(buf);
//		System.out.println(str);
	}
}
