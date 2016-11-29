package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Course;

public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

		Course course = new Course();
		course.setCourseID(rs.getString("CourseID"));
		course.setYear(rs.getInt("Year"));
		course.setSemester(rs.getInt("Semester"));
		course.setCourseName(rs.getString("CourseName"));
		course.setClassify(rs.getString("Classify"));
		course.setCourseGrade(rs.getInt("CourseGrade"));

		return course;
	}
}