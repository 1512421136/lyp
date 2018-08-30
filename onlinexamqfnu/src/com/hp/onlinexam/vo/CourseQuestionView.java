package com.hp.onlinexam.vo;
/**
 * 教师课程信息视图类
 * @author Administrator
 *
 */
public class CourseQuestionView {
//	private int  tcId;
//	private int  tcCourseId;
//	private int  tcTeaId; 
//	private int  teacherId;
//	private String  teacherName;
//	private int  stuclassId;
//	private String  stuclassName;
//	private String  departmentName;
//	private int  courseId;
//	private String  courseName;
	
	private int courseId;
	private String courseName;
	
	private String quecourseId;
	private int queType;
	private String queTitle;
	private String quechoiceA;
	private String quechoiceB;
	private String quechoiceC;
	private String quechoiceD;
	private String queans;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getQuecourseId() {
		return quecourseId;
	}
	public void setQuecourseId(String quecourseId) {
		this.quecourseId = quecourseId;
	}
	public int getQueType() {
		return queType;
	}
	public void setQueType(int queType) {
		this.queType = queType;
	}
	public String getQueTitle() {
		return queTitle;
	}
	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}
	public String getQuechoiceA() {
		return quechoiceA;
	}
	public void setQuechoiceA(String quechoiceA) {
		this.quechoiceA = quechoiceA;
	}
	public String getQuechoiceB() {
		return quechoiceB;
	}
	public void setQuechoiceB(String quechoiceB) {
		this.quechoiceB = quechoiceB;
	}
	public String getQuechoiceC() {
		return quechoiceC;
	}
	public void setQuechoiceC(String quechoiceC) {
		this.quechoiceC = quechoiceC;
	}
	public String getQuechoiceD() {
		return quechoiceD;
	}
	public void setQuechoiceD(String quechoiceD) {
		this.quechoiceD = quechoiceD;
	}
	public String getQueans() {
		return queans;
	}
	public void setQueans(String queans) {
		this.queans = queans;
	}

	
}