package com.java.test;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.dao.impl.StudentDaoImpl;

public class Test {
	public static void main(String[] args) {
		StudentDao sd = new StudentDaoImpl();
		Student stu = new Student();
		/*
		 * ------------------------------------删除数据-------------------------------------
		 */
//		int res = sd.deleteStudentById(6);
//		if (res > 0) {
//			System.out.println("删除成功！");
//		} else {
//			System.out.println("删除失败！");
//		}
		/*
		 * ------------------------------------删除数据-------------------------------------
		 */

		/*
		 * ------------------------------------修改数据-------------------------------------
		 */
//		stu.setName("王宝强");
//		stu.setId(7);
//		if (sd.updateStudent(stu) > 0) {
//			System.out.println("修改成功！");
//		} else {
//			System.out.println("修改失败！");
//		}
		/*
		 * ------------------------------------修改数据-------------------------------------
		 */

		/*
		 * ------------------------------------插入数据-------------------------------------
		 */
//		stu.setId(7);
//		stu.setName("刘德华");
//		stu.setPwd("123");
//		stu.setCid(1);
//		if (sd.insertStudent(stu) > 0) {
//			System.out.println("插入成功！");
//		} else {
//			System.out.println("插入失败！");
//		}

		/*
		 * ------------------------------------插入数据-------------------------------------
		 */

		/*
		 * ------------------------------------批量插入-------------------------------------
		 */
//		Student[] s = new Student[4];
//		Student s1 = new Student(1, "八戒", "234", 1);
//		Student s2 = new Student(2, "悟空", "234", 1);
//		Student s3 = new Student(3, "沙僧", "234", 1);
//		Student s4 = new Student(4, "唐僧", "234", 1);
//		s[0] = s1;
//		s[1] = s2;
//		s[2] = s3;
//		s[3] = s4;
//		sd.insertStu(s);
		/*
		 * ------------------------------------批量插入-------------------------------------
		 */

		/*
		 * ------------------------------------批量删除-------------------------------------
		 */
		// sd.deleteStu(43, 44, 45, 46);
		// 调用存储过程！
		// sd.insertStudent();
		// 查询
		// List<Student> list = sd.selectAll();
		// for (Student student : list) {
		// System.out.println(student);
		// }

	}
}
