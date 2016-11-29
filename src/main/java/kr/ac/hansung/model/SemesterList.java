package kr.ac.hansung.model;

public class SemesterList {
	int year;
	int semester;
	int totalGrade;

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

	public void setTotalGrade(int totalGrade) {
		this.totalGrade = totalGrade;
	}

	public int getTotalGrade() {
		return totalGrade;
	}
}
