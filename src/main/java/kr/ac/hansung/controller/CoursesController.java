package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.SemesterList;
import kr.ac.hansung.service.CoursesService;

@Controller()
@RequestMapping("/Course")
public class CoursesController {

	private CoursesService courseService;

	@Autowired
	public void setOffersService(CoursesService courseService) {
		this.courseService = courseService;
	}

	// 학기별 조회
	@RequestMapping(value = "/queryCoursesBySemester")
	public String queryCoursesBySemester(Model model) {
		List<SemesterList> list = courseService.getCoursesBySemester();
		model.addAttribute("list", list);
		return "queryCoursesBySemester";
	}

	// 학기별 조회 상세보기
	@RequestMapping(value = "/queryCoursesBySemester/detail", method = RequestMethod.GET)
	public String queryCoursesBySemesterDetail(Model model, int year, int semester) {
		List<Course> course = courseService.getCoursesBySemesterDetail(year, semester);
		model.addAttribute("course", course);
		return "detail";
	}

	// 구분별 조회
	@RequestMapping(value = "/queryCoursesByClassify", method = RequestMethod.GET)
	public String queryCoursesByClassify(Model model) {
		List<String> classifies = courseService.getClassifiesLists();
		int[] classifyGrade = courseService.getTotalGradeByClassify(classifies);
		int totalGrade = 0;
		for (int i = 0; i < classifyGrade.length; i++)
			totalGrade += classifyGrade[i];

		model.addAttribute("classifyGrade", classifyGrade);
		model.addAttribute("classifies", classifies);
		model.addAttribute("totalGrade", totalGrade);
		return "queryCoursesByClassify";
	}
}
