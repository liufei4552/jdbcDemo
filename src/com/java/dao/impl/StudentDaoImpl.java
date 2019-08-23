package com.java.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.util.DBUtils;

public class StudentDaoImpl implements StudentDao {

	/*
	 * java 如何跟数据进行连接 1.导入数据库驱动jar包 2.加载数据库驱动 Class.forName(); 3.创建数据连接对象 4.准备sql语句
	 * 5.执行sql语句 6.关闭数据库 (non-Javadoc)
	 * 
	 * @see org.lq.jdbc.dao.StudentDao#selectAll()
	 */
	// 数据连接对象
	Connection con = null;
	// 准备执行sql语句
	PreparedStatement ps = null;
	// 返回执行的结果集
	ResultSet rs = null;

	@Override
	public List<Student> selectAll() {
		// 声明学生对象
		Student stu = null;
		List<Student> list = new ArrayList<Student>();
		// 加载数据库驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8",
					"root", "root");
			String sql = "select * from student order by id";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt(1)); // 可以使用数字下标访问，也可以使用字段名来访问
				stu.setName(rs.getString(2).trim());
				stu.setPwd(rs.getString(3));
				stu.setCid(rs.getInt(4));
				list.add(stu);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 创建数据连接
		return list;
	}

	@Override
	public int deleteStudentById(int id) {
		int result = 0;
		try {
			// 打开连接数据库
			con = DBUtils.getConnection();
			// 准备执行sql语句 ?代表占位符
			String sql = "delete from student where id = ?";
			// 准备执行sql语句
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			// 返回一个受影响的行数
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
		return result;
	}

	@Override
	public int updateStudent(Student stu) {
		int res = 0;
		try {
			// 连接数据库
			con = DBUtils.getConnection();
			String sql = "update student set name=? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getId());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
		return res;
	}

	@Override
	public int insertStudent(Student stu) {
		int res = 0;
		try {
			// 连接数据库
			con = DBUtils.getConnection();
			String sql = "insert into student values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, stu.getId());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getPwd());
			ps.setInt(4, stu.getCid());
			ps.addBatch();
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
		return res;
	}

	@Override
	public void insertStu(Student[] stu) {
		try {
			con = DBUtils.getConnection();
			String sql = "insert into student values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			for (Student student : stu) {
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getPwd());
				ps.setInt(4, student.getCid());
				ps.addBatch();
			}
			System.out.println("批量插入成功");
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
	}

	@Override
	public void deleteStu(int... id) {
		try {
			con = DBUtils.getConnection();
			String sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			for (int i : id) {
				ps.setInt(1, i);
				ps.addBatch();
			}
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
	}

	@Override
	public void insertStudent() {
		con = DBUtils.getConnection();
		try {
			// 创建存储过程对象
			CallableStatement c = con.prepareCall("{call p_proc(?,?,?,?,?)}");
			c.setInt(1, 1008);
			c.setString(2, "好累哟");
			c.setInt(3, 100);
			c.setInt(4, 1);
			c.setString(5, "123");
			c.execute();
			System.out.println("ִ执行完毕！");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(con, ps, rs);
		}
	}

}
