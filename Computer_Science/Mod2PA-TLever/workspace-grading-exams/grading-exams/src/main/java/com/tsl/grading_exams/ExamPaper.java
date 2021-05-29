package com.tsl.grading_exams;



/**
 * ExamPaper represents the structure for an exam paper.
 * @author Tom Lever
 * @version 1.0
 * @since 05/28/21
 *
 */

class ExamPaper {

	
	/**
	 * theStudentsName is an attribute of an exam paper.
	 */
	private String studentsName;
	
	
	/**
	 * theExamScore is an attribute of an exam paper.
	 */
	private int examScore;
	
	
	protected ExamPaper(String theStudentsNameToUse, int theExamScoreToUse) {
		this.studentsName = theStudentsNameToUse;
		this.examScore = theExamScoreToUse;
	}
	
	
	protected void setTheStudentsName(String theStudentsNameToUse) {
		this.studentsName = theStudentsNameToUse;
	}
	
	
	protected void setTheExamScore(int theExamScoreToUse) {
		this.examScore = theExamScoreToUse;
	}
	
	
	protected String getTheStudentsName() {
		return this.studentsName;
	}
	
	
	protected int getTheExamScore() {
		return this.examScore;
	}
	
	
	@Override
	public String toString() {
		
		return this.studentsName + "\tScore: " + this.examScore;
		
	}
	
}
