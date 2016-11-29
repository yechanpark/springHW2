package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.SemesterList;

public class SemesterListMapper implements RowMapper<SemesterList> {
	public SemesterList mapRow(ResultSet rs, int rowNum) throws SQLException {

		SemesterList list = new SemesterList();
		list.setYear(rs.getInt("Year"));
		list.setSemester(rs.getInt("Semester"));
		return list;
	}
}
