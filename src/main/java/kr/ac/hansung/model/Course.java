package kr.ac.hansung.model;

public class Course {

	// 수강년도
	private int year;
	// 학기
	private int semester;
	// 교과코드
	private String courseID;
	// 교과목명
	private String courseName;
	// 구분
	private String classify;
	// 이수 학점
	private int courseGrade;

	public Course() {

	}

	public Course(int year, int semester, int courseGrade) {

	}

	public Course(int year, int semester, String courseID, String courseName, String classify, int courseGrade) {
		this.year = year;
		this.semester = semester;
		this.courseID = courseID;
		this.courseName = courseName;
		this.classify = classify;
		this.courseGrade = courseGrade;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}

}