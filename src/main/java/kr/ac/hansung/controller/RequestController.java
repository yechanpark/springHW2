package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CoursesService;

@Controller()
@RequestMapping("/Request")
public class RequestController {

	private CoursesService coursesService;

	@Autowired
	public void setCoursesService(CoursesService coursesService) {
		this.coursesService = coursesService;
	}

	// ������û ���� ��� - ���� �б⿡ ���� �� �ִ� ���� ���
	@RequestMapping(value = "/getRequestableCourses", method = RequestMethod.GET)
	public String getRequestableCourses(Model model) {
		List<Course> nextSemesterCourses = coursesService.getRequestableCourses();
		model.addAttribute("nextSemesterCourses", nextSemesterCourses);
		return "getRequestableCoursesForm";
	}

	// ������û ����
	@RequestMapping(value = "/doRequestCourse")
	public String dorequestCourse(Model model, String courseID) {
		// �̹� ����� �����̸�
		if (coursesService.isListenedCourse(courseID))
			return "alreadyListened";

		// ���� ���� ���� �����̸�
		else {
			coursesService.doRequestCourse(courseID);
			List<Course> nextSemesterCourses = coursesService.getRequestableCourses();
			model.addAttribute("nextSemesterCourses", nextSemesterCourses);
			return "getRequestableCoursesForm";
		}
	}

	// ������û ���� ��ȸ
	@RequestMapping(value = "/getRequestedCourses", method = RequestMethod.GET)
	public String getRequestedCourses(Model model) {
		List<Course> courses = coursesService.getRequestedCourses();
		model.addAttribute("courses", courses);
		return "getRequestedCourses";
	}

	// ������û ����
	@RequestMapping(value = "/doDeleteRequestedCourse", method = RequestMethod.GET)
	public String doDeleteRequestedCourse(Model model, String CourseID) {
		coursesService.doDeleteRequestedCourse(CourseID);

		List<Course> courses = coursesService.getRequestedCourses();
		model.addAttribute("courses", courses);
		return "getRequestedCourses";
	}
}
