package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;

/**
 * 
 * WolfScheduler class maintains an array list of
 * courses from the provided file and also a schedule for
 * a student.
 * 
 * @author Sanjana Cheerla
 *
 */
public class WolfScheduler {
	
	/** Title of the schedule */
	private String title;
	
	/** The schedule */
	private ArrayList<Course> schedule;
	
	/**  The catalog of courses */
	private ArrayList<Course> catalog;
	
	/** The number of rows used in getCourseCatalog() and getScheduledCourses() */
	private static final int SCHEDULE_COURSE_INDEX = 3;
	
	/** The number of rows used in getFullScheduledCourses() */
	private static final int FULL_SCHEDULE_COURSE_INDEX = 6;
	
	/**
	 * Constructs a WolfScheduler Object, title is
	 * initialized to "My Schedule". A new scheduled is 
	 * initialized to an ArrayList of courses. A catalog of
	 * courses, consisting of an Array List, is made from the given
	 * file name parameter. If there is an error regarding the 
	 * fileName, an IllegalArgumentException is thrown with
	 * the message "Cannot find file"
	 * 
	 * @param fileName 
	 * 			The file name for course records
	 * @throws IllegalArgumentException 
	 * 			If the file cannot be accessed, with 
	 * 			the message "Cannot find file" 
	 */
	public WolfScheduler(String fileName) {
		try {
			setTitle("My Schedule");
			catalog = CourseRecordIO.readCourseRecords(fileName);
			schedule = new ArrayList<Course>();
		}
		catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file");
		}
	}
	
	/**
	 * Searches for a Course with the given name and section in the
	 * catalog and if it is found, returns the course that has that
	 * name and section. If no such course exists, null is returned.
	 * 
	 * @param name 
	 * 			The name of the Course being found
	 * @param section 
	 * 			The section of the Course being found
	 * @return the Course if it is found, null if there is no
	 * such Course in the catalog
	 */
	public Course getCourseFromCatalog(String name, String section) {
		
		for(int i = 0; i < catalog.size(); i++) {
			if(catalog.get(i).getName().equals(name) &&
					catalog.get(i).getSection().contentEquals(section)) {
				return catalog.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the title of the schedule
	 * 
	 * @return the title of the schedule
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the schedule. If the title is
	 * null, an IllegalArgumentException is thrown with the message
	 * "Title cannot be null".
	 * 
	 * @param title 
	 * 			The title to set for the schedule
	 * @throws IllegalArgumentException 
	 * 			If the title is null.
	 */
	public void setTitle(String title) {
		if(title == null) {
			throw new IllegalArgumentException("Title cannot be null");
		}
		this.title = title;
	}
	

	/**
	 * Organizes the catalog ArrayList into a 2D array consisting of 
	 * one column for the course name, one for the section, and
	 * one for the title.
	 * 
	 * @return String[][]
	 * 			2D String array of the courses available into 
	 * 			one row for each course, and in the columns, one for the name,
	 * 			one for the title, and one for the section number.
	 */
	public String[][] getCourseCatalog() {
		if(this.catalog.isEmpty()) {
			return new String[0][0];
		}
		String[][] courseCatalog = new String[this.catalog.size()][SCHEDULE_COURSE_INDEX];
		for(int i = 0; i < courseCatalog.length; i++) {
			int index = 0;
			courseCatalog[i][index] = this.catalog.get(i).getName();
			courseCatalog[i][++index] = this.catalog.get(i).getSection();
			courseCatalog[i][++index] = this.catalog.get(i).getTitle();
		}
		return courseCatalog;
	}

	/**
	 * Organizes the schedule ArrayList into a 2D array consisting of 
	 * one column for the course name, one for the section, and
	 * one for the title.
	 * 
	 * @return String[][]
	 * 			2D String array of the courses in the student' schedule
	 * 			into one row for each course, and in the columns, one for the name,
	 * 			one for the title, and one for the section number.
	 */
	public String[][] getScheduledCourses() {
		if(this.schedule.isEmpty()) {
			return new String[0][0];
		}
		String[][] scheduleCatalog = new String[this.schedule.size()][SCHEDULE_COURSE_INDEX];
		for(int i = 0; i < scheduleCatalog.length; i++) {
			int index = 0;
			scheduleCatalog[i][index] = this.schedule.get(i).getName();
			scheduleCatalog[i][++index] = this.schedule.get(i).getSection();
			scheduleCatalog[i][++index] = this.schedule.get(i).getTitle();
		}
		return scheduleCatalog;
	}

	/**
	 * Organizes the schedule ArrayList into a 2D array consisting of 
	 * one column for the course name, one for the section, and
	 * one for the title, one for the number of credits, one for the 
	 * instructorId, and one for the days the courses meet.
	 * 
	 * @return String[][]
	 * 			2D String array of the courses in the student' schedule
	 * 			into one row for each course, and in the columns, one for the name,
	 * 			one for the title, and one for the section number, one for the number
	 * 			of credits, one for the instructorId, and one for the days 
	 * 			the courses meet.
	 */
	public String[][] getFullScheduledCourses() {
		if(this.schedule.isEmpty()) {
			return new String[0][0];
		}
		String[][] scheduleCatalog = new String[this.schedule.size()][FULL_SCHEDULE_COURSE_INDEX];
		for(int i = 0; i < scheduleCatalog.length; i++) {
			int index = 0;
			scheduleCatalog[i][index] = this.schedule.get(i).getName();
			scheduleCatalog[i][++index] = this.schedule.get(i).getSection();
			scheduleCatalog[i][++index] = this.schedule.get(i).getTitle();
			int credits = this.schedule.get(i).getCredits();
			scheduleCatalog[i][++index] = Integer.toString(credits);
			scheduleCatalog[i][++index] = this.schedule.get(i).getInstructorId();
			scheduleCatalog[i][++index] = this.schedule.get(i).getMeetingString();
		}
		return scheduleCatalog;
	}

	/**
	 * Exports the current schedule to the given file.
	 * 
	 * @param fileName 
	 * 			The name of the file that the course is being written to
	 * @throws IllegalArgumentException 
	 * 				With the message "The file cannot be saved" 
	 * 				if an IOException is caught.
	 */
	public void exportSchedule(String fileName) {
		try {
			CourseRecordIO.writeCourseRecords(fileName, schedule);
		}
		catch (IOException e) {
			throw new IllegalArgumentException("The file cannot be saved.");
		}
	}

	/**
	 * Adds the specified course to the student schedule. If the 
	 * course is already added in the schedule an exception is thrown.
	 * If the course does not exist in the catalog the method returns
	 * false. If the course exists and is not in the student schedule.
	 * the course is added to the schedule and a value of true is returned.
	 * 
	 * @param name 
	 * 			The name of the course to be added
	 * @param section 
	 * 			The section number of the course to be added
	 * @throws IllegalArgumentException 
	 * 			With the message "You are already enrolled in " 
	 * 			if the course with the same name
	 * 			exists in the student schedule.
	 * @return true if the schedule has been added to the schedule,
	 * and false if the course is not in the course catalog
	 */
	public boolean addCourse(String name, String section) {
		if(this.getCourseFromCatalog(name, section) == null) {
			return false;
		}
		
		Course c = this.getCourseFromCatalog(name, section);
		
		for(int i = 0; i < this.schedule.size(); i++) {
			if(this.schedule.get(i).getName().equals(c.getName())) {
				throw new IllegalArgumentException("You are already enrolled in " + name);
			}
		}
		
		this.schedule.add(c);
		return true;
	}

	/**
	 * If the course is in the student schedule, this
	 * method removes that specified course from the 
	 * schedule and returns true if the course can be 
	 * removed. If the schedule does not contain the 
	 * course then the method returns false.
	 * 
	 * @param name 
	 * 			The name of the course to be removed
	 * @param section 
	 * 			The section number of the course to be removed
	 * @return true if the course can be removed from the schedule, and
	 * false if the course does not exist in the schedule.
	 */
	public boolean removeCourse(String name, String section) {
		Course c = this.getCourseFromCatalog(name, section);
		if(!this.schedule.contains(c)) {
			return false;
		}
		if(this.schedule.contains(c)) {
			this.schedule.remove(c);
			return true;
		}
		return false;
	}

	/**
	 * Resets the schedule by removing all elements.
	 */
	public void resetSchedule() {
		schedule.removeAll(schedule);
		this.setTitle("My Schedule");
	}

}
