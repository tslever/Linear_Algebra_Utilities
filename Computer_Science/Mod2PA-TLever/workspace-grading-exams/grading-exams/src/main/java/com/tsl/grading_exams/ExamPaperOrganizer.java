package com.tsl.grading_exams;

/**
 * Hello world!
 *
 */
public class ExamPaperOrganizer {

	
    public static void main( String[] args ) throws ANoExamScoresExistToAverageException {
    	
    	while (true) {
    	
	    	ExamPaperStack theExamPaperStackForAllExams =
	    		AnInputOutputManager.askAboutAndReadStudentsNamesAndExamScores();
	    	System.out.println(
	    		"\nThe exam-paper stack contains papers with the following names and scores: {\n" +
	    		theExamPaperStackForAllExams + "\n" +
	    		"}"
	    	);
	    	
	    	System.out.println("The number of exam papers is: " + theExamPaperStackForAllExams.size());
	    	
	    	double theAverageExamScore;
	    	try {
		    	theAverageExamScore = theExamPaperStackForAllExams.getTheAverageExamScore();
				System.out.println(
					"The average of the scores for the " + theExamPaperStackForAllExams.size() + " exam papers is: " +
					theAverageExamScore + "\n"
				);
	    	}
	    	catch (ANoExamScoresExistToAverageException theNoExamScoresExistToAverageException) {
	    		System.out.println("No exam scores exist to average.");
	    		continue;
	    	}
	    	
	    	ExamPaperStack theExamPaperStackForExamsWithScoresLessThanTheAverage = new ExamPaperStack();
	    	ExamPaperStack theExamPaperStackForExamsWithScoresGreaterThanOrEqualToTheAverage = new ExamPaperStack();
	    	
	    	while (!theExamPaperStackForAllExams.isEmpty()) {
	    		
	    		ExamPaper theExamPaper = theExamPaperStackForAllExams.poptop();
	    		
	    		if ((double)theExamPaper.getTheExamScore() < theAverageExamScore) {
	    			theExamPaperStackForExamsWithScoresLessThanTheAverage.push(theExamPaper);
	    		}
	    		else {
	    			theExamPaperStackForExamsWithScoresGreaterThanOrEqualToTheAverage.push(theExamPaper);
	    		}
	    		
	    	}
	    	
	    	System.out.println(
	    		"The exam papers with scores greater than or equal to the average exam score of " + theAverageExamScore +
	    		" have the following names and scores: {\n" +
	    		theExamPaperStackForExamsWithScoresGreaterThanOrEqualToTheAverage + "\n" +
	    		"}\n" +
	    		"The number of exam papers with scores greater than or equal to the average exam score: " +
	    		theExamPaperStackForExamsWithScoresGreaterThanOrEqualToTheAverage.size() + "\n"
	    	);
	    	
	    	System.out.println(
	    		"The exam papers with scores less than the average exam score of " + theAverageExamScore +
	    		" have the following names and scores: {\n" +
	    		theExamPaperStackForExamsWithScoresLessThanTheAverage + "\n" +
	    		"}\n" +
	    		"The number of exam papers with scores less than the average exam score: " +
	    		theExamPaperStackForExamsWithScoresLessThanTheAverage.size() + "\n"
	    	);
	    	
	    	break;
    	
    	}
    	
    }
    
}
