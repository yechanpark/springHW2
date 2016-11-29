package kr.ac.hansung.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.SemesterList;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<SemesterList> getSemesterList() {
		String sqlStatement = "SELECT distinct Year, Semester FROM course order by Year, Semester";
		return jdbcTemplateObject.query(sqlStatement, new SemesterListMapper());
	}

	public int getSumBySemester(int year, int semester) {
		String sqlStatement = "SELECT sum(CourseGrade) from course where Year=? and Semester=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { year, semester }, Integer.class);
	}

	public List<String> getClassifiesLists() {
		String sqlStatement = "SELECT distinct Classify from course";
		return jdbcTemplateObject.queryForList(sqlStatement, String.class);
	}

	public int getTotalGradeByClassify(String classify) {
		String sqlStatement = "SELECT sum(CourseGrade) from course where Classify=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { classify }, Integer.class);
	}

	// xxxx�г⵵ x�б⿡ ������ ���� ����
	public List<Course> getCourses(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new CourseMapper());
	}

	// �ش� ������ course ���̺��� ����
	public Course getCourse(String courseID) {
		String sqlStatement = "select * from course where CourseID=?";
		try {
			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { courseID }, new CourseMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// �����б⿡ ������ �� �ִ� ���� ���
	public List<Course> getRequestableCourses() {
		String sqlStatement = "select * from requestablecourses where CourseID not in (select CourseID from requestedcourses)";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	// ������û
	public boolean doRequestCourse(Course course) {
		String courseID = course.getCourseID();
		int year = course.getYear();
		int semester = course.getSemester();
		String courseName = course.getCourseName();
		String classify = course.getClassify();
		int courseGrade = course.getCourseGrade();

		String sqlStatement = "insert into requestedcourses (CourseID, Year, Semester, CourseName, Classify, CourseGrade) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { courseID, year, semester, courseName, classify, courseGrade }) == 1);
	}

	// ������û���� ��ȸ
	public List<Course> getRequestedCourses() {
		String sqlStatement = "select * from requestedcourses";
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	// ������û���� ��ȸ
	public Course getRequestedCourse(String courseID) {
		String sqlStatement = "select * from requestedcourses where CourseID=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { courseID }, new CourseMapper());
	}

	public boolean doDeleteRequestedCourse(String courseID) {
		String sqlStatement = "delete from requestedcourses where CourseID=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { courseID }) == 1);
	}

	// ���� �б��� �������̺��� �ش� ������ ������
	public Course doRequestCourse(String courseID) {
		String sqlStatement = "select * from requestablecourses where CourseID=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { courseID }, new CourseMapper());
	}
}
