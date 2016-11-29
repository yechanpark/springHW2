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

	@Autowired // OfferDAO Ÿ���� Bean ����
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	// �г⵵, �б⺰ ��ȸ
	public List<SemesterList> getCoursesBySemester() {
		// xx�⵵, x�б� ����Ʈ
		List<SemesterList> semesterLists = getSemestersLists();

		for (SemesterList sl : semesterLists) {
			int totalGrade = courseDao.getSumBySemester(sl.getYear(), sl.getSemester());
			sl.setTotalGrade(totalGrade);
		}

		return semesterLists;
	}

	// ������ xxxx�г⵵ x�б� ����Ʈ
	private List<SemesterList> getSemestersLists() {
		List<SemesterList> semesterList = courseDao.getSemesterList();
		return semesterList;
	}

	// �г⵵, �б⺰ ��ȸ �󼼺��� Ŭ��
	public List<Course> getCoursesBySemesterDetail(int year, int semester) {
		List<Course> courses = courseDao.getCourses(year, semester);
		return courses;
	}

	// ���к� ��ȸ
	public int[] getTotalGradeByClassify(List<String> classifies) {
		int[] totalGrade = new int[classifies.size()];
		for (int i = 0; i < classifies.size(); i++) {
			totalGrade[i] = courseDao.getTotalGradeByClassify(classifies.get(i));
		}
		return totalGrade;
	}

	// ���� ����Ʈ
	public List<String> getClassifiesLists() {
		List<String> classifyList = courseDao.getClassifiesLists();
		return classifyList;
	}

	// ������û ���
	public List<Course> getRequestableCourses() {
		List<Course> courses = courseDao.getRequestableCourses();
		return courses;
	}

	// �ش� ������ ������� �ȵ������
	public boolean isListenedCourse(String courseID) {
		Course course = courseDao.getCourse(courseID);
		if (course == null)
			return false;
		else
			return true;
	}

	// ������û ����
	public void doRequestCourse(String courseID) {
		Course course = courseDao.doRequestCourse(courseID);
		courseDao.doRequestCourse(course);
	}

	// ������û�� ���
	public List<Course> getRequestedCourses() {
		List<Course> courses = courseDao.getRequestedCourses();
		return courses;
	}

	// ������û�� ���� ���
	public boolean doDeleteRequestedCourse(String CourseID) {
		boolean isDeleted = courseDao.doDeleteRequestedCourse(CourseID);
		return isDeleted;
	}

}