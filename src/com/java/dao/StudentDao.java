package com.java.dao;

import java.util.List;

import com.java.bean.Student;

public interface StudentDao {
	/**
	 * 查询所有学生信息
	 * 
	 * @return 返回List<Student>集合
	 */
	public List<Student> selectAll();

	/**
	 * 根据学生ID删除学生对象
	 * 
	 * @param id
	 * @return int 类型 id
	 */
	public int deleteStudentById(int id);

	/**
	 * 根据学生ID修改
	 * 
	 * @param id
	 * @return int 类型
	 */
	public int updateStudent(Student stu);

	/**
	 * 插入学生对象
	 * 
	 * @param stu
	 * @return int 类型
	 */
	public int insertStudent(Student stu);

	/**
	 * 批量插入学生
	 * 
	 * @param stu
	 * @return
	 */
	public void insertStu(Student[] stu);

	/**
	 * 批量删除
	 * 
	 * @param id
	 */
	public void deleteStu(int... id);

	/**
	 * java调用存储过程
	 */
	public void insertStudent();
}
