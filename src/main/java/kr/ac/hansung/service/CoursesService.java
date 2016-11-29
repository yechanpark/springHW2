package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.SemesterList;

@Service
public class CoursesService {

	private CourseDAO courseDao;

	@Autowired // OfferDAO 타입의 Bean 주입
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	// 학년도, 학기별 조회
	public List<SemesterList> getCoursesBySemester() {
		// xx년도, x학기 리스트
		List<SemesterList> semesterLists = getSemestersLists();

		for (SemesterList sl : semesterLists) {
			int totalGrade = courseDao.getSumBySemester(sl.getYear(), sl.getSemester());
			sl.setTotalGrade(totalGrade);
		}

		return semesterLists;
	}

	// 수강한 xxxx학년도 x학기 리스트
	private List<SemesterList> getSemestersLists() {
		List<SemesterList> semesterList = courseDao.getSemesterList();
		return semesterList;
	}

	// 학년도, 학기별 조회 상세보기 클릭
	public List<Course> getCoursesBySemesterDetail(int year, int semester) {
		List<Course> courses = courseDao.getCourses(year, semester);
		return courses;
	}

	// 구분별 조회
	public int[] getTotalGradeByClassify(List<String> classifies) {
		int[] totalGrade = new int[classifies.size()];
		for (int i = 0; i < classifies.size(); i++) {
			totalGrade[i] = courseDao.getTotalGradeByClassify(classifies.get(i));
		}
		return totalGrade;
	}

	// 구분 리스트
	public List<String> getClassifiesLists() {
		List<String> classifyList = courseDao.getClassifiesLists();
		return classifyList;
	}

	// 수강신청 목록
	public List<Course> getRequestableCourses() {
		List<Course> courses = courseDao.getRequestableCourses();
		return courses;
	}

	// 해당 과목을 들었는지 안들었는지
	public boolean isListenedCourse(String courseID) {
		Course course = courseDao.getCourse(courseID);
		if (course == null)
			return false;
		else
			return true;
	}

	// 수강신청 수행
	public void doRequestCourse(String courseID) {
		Course course = courseDao.doRequestCourse(courseID);
		courseDao.doRequestCourse(course);
	}

	// 수강신청한 목록
	public List<Course> getRequestedCourses() {
		List<Course> courses = courseDao.getRequestedCourses();
		return courses;
	}

	// 수강신청한 과목 취소
	public boolean doDeleteRequestedCourse(String CourseID) {
		boolean isDeleted = courseDao.doDeleteRequestedCourse(CourseID);
		return isDeleted;
	}

}