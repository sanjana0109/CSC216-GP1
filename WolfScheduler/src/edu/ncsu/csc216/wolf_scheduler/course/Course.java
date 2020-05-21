package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Course class for WolfScheduler, use to 
 * create Course objects.
 *
 * @author Sanjana Cheelra
 */
public class Course {
	
	/** Course's name. */
	private String name;
	
	/** Course's title. */
	private String title;
	
	/** Course's section. */
	private String section;
	
	/** Course's credit hours. */
	private int credits;
	
	/** Course's instructor. */
	private String instructorId;
	
	/** Course's meeting days. */
	private String meetingDays;
	
	/** Course's starting time. */
	private int startTime;
	
	/** Course's ending time. */
	private int endTime;
	
	/** Length of a section number */
	private static final int SECTION_LENGTH = 3;
	
	/** Maximum length of name */
	private static final int MAX_NAME_LENGTH = 6;
	
	/** Minimum length of name */
	private static final int MIN_NAME_LENGTH = 4;	
	
	/** Max credits for a course */
	private static final int MAX_CREDITS = 5;
	
	/** Minimum credits for a course */
	private static final int MIN_CREDITS = 1;
	
	/** Upper time limit */
	private static final int UPPER_TIME = 2400;
	
	/** Upper hour limit */
	private static final int UPPER_HOUR = 60;
	
	/** Constant for accessing different parts of time */
	private static final int TIME_CONSTANT = 100;
	
	/** Time constant to differentiate between 
	 * AM and PM in standard time format */
	private static final int AM_OR_PM = 12;
	
	/** Constant to check if minutes is between 0 and 9 included */
	private static final int SINGLE_DIGIT_MINUTE = 10;
	/**
	 * Constructs a Course object with values for all fields.
	 * Source: Method is from GP1 Guided Task: Encapsulation and 
	 * Reducing Redundancy, Reducing Redundancy in the Course Constructors.
	 * 
	 * @param name 
	 * 			Name of Course
	 * @param title 
	 * 			Title of Course
	 * @param section 
	 * 			Section of Course
	 * @param credits 
	 * 			Credit hours for Course
	 * @param instructorId 
	 * 			Instructor's unity id
	 * @param meetingDays 
	 * 			Meeting days for Course as series of chars
	 * @param startTime 
	 * 			Start time for Course
	 * @param endTime 
	 * 			End time for Course
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
	        int startTime, int endTime) {
	    setName(name);
	    setTitle(title);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	    setMeetingDays(meetingDays);
	    setCourseTime(startTime, endTime);
	}

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId, and meetingDays for 
	 * courses that are arranged.
	 * Source: Method is from GP1 Guided Task: Encapsulation and 
	 * Reducing Redundancy, Reducing Redundancy in the Course Constructors.
	 * 
	 * @param name 
	 * 			Name of Course
	 * @param title 
	 * 			Title of Course
	 * @param section 
	 * 			Section of Course
	 * @param credits 
	 * 			Credit hours for Course
	 * @param instructorId 
	 * 			Instructor's unity id
	 * @param meetingDays
	 * 			Meeting days for Course as series of chars
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
	    this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}

	/**
	 * Returns the Course's name
	 * 
	 * @return String of the name of the course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Course's name. If the name is null, has a length less than 4 or 
	 * greater than 6, an IllegalArgumentException is thrown.
	 * Source: method is from GP1 Independent Task: Finish Course Implementation
	 * setName() implementation.
	 * 
	 * @param name 
	 * 			The name to set
	 * @throws IllegalArgumentException 
	 * 			If name is null or length is less than 4 or 
	 * 			greater than 6
	 */
	private void setName(String name) {
	    if (name == null) {
	        throw new IllegalArgumentException();
	    }
	    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
	        throw new IllegalArgumentException();
	    }
	    this.name = name;
	}
	
	/**
	 * Returns the Course's title
	 * 
	 * @return String of the Course's title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the Course's title. If the title is null or an empty string, an 
	 * IllegalArgumentException is thrown.
	 * 
	 * @param title 
	 * 			The title to set
	 * @throws IllegalArgumentException 
	 * 			If title is null or an empty string
	 */
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException(); 
		}
		if (title.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.title = title;
	}
	
	/**
	 * Returns the Course's section
	 * 
	 * @return String of the Course's section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * Sets the Course's section. If the section number is not 3 numbers long,
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param section 
	 * 			The section to set
	 * @throws IllegalArgumentException 
	 * 			If the section is not 3 numbers long
	 */
	public void setSection(String section) {
		if (section == null || section.length() != SECTION_LENGTH ) {
			throw new IllegalArgumentException();
		}
		
		if(Character.isDigit(section.charAt(0)) && 
				Character.isDigit(section.charAt(1)) &&
				Character.isDigit(section.charAt(SECTION_LENGTH - 1))){
			this.section = section;
			return;
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Returns the Course's credits
	 * 
	 * @return The number of credits of the Course
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Sets the Course's credits. If the course credits is not a digit, 
	 * or credits is less than 1 or greater than 5
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param credits 
	 * 			The number credits to set for the course
	 * @throws IllegalArgumentException 
	 * 			If credits is less than 1 or greater than 5
	 */
	public void setCredits(int credits) {

		if(credits < MIN_CREDITS) {
			throw new IllegalArgumentException();
		}
		if(credits > MAX_CREDITS) {
			throw new IllegalArgumentException();
		}
		
		this.credits = credits;
	}
	
	/**
	 * Returns the Course's instructorId
	 * 
	 * @return String of the Course's instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	
	/**
	 * Sets the Course's instructorId. If instructorId is null or empty
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param instructorId 
	 * 			The instructorId to set
	 * @throws IllegalArgumentException 
	 * 			If instructorId is null or empty.
	 */
	public void setInstructorId(String instructorId) {
		if(instructorId == null || instructorId.isEmpty() ) {
			throw new IllegalArgumentException();
		}
		this.instructorId = instructorId;
	}
	
	/**
	 * Returns the Course's meetingDays
	 * 
	 * @return String of the meetingDays that the course meets
	 */
	public String getMeetingDays() {
		return meetingDays;
	}
	
	/**
	 * Sets the Course's meetingDays. If the meetingDays contains any 
	 * other characters than "M,T,W,H,F,A", an IllegalArgumentException is thrown.
	 * If there is an "A" it must be the only character or else,
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param meetingDays 
	 * 			The meetingDays to set
	 * @throws IllegalArgumentException 
	 * 			If meetingDays is null or empty, 
	 * 			and if the meetingDays are invalid meaning that it must have
	 * 			"M" "T" "W" "T" "F" as a combination of strings and no other
	 * 			characters. If there is an "A" it must be the only character.
	 */
	public void setMeetingDays(String meetingDays) {
		if(meetingDays == null || meetingDays.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if(meetingDays.contains("A") && meetingDays.length() == 1){
			this.meetingDays = meetingDays;
			return;
		}
		
		if (meetingDays.contains("A") && meetingDays.length() != 1) {
			throw new IllegalArgumentException();
		}
		
		boolean isValid = true;
		
		for(int i = 0; i < meetingDays.length(); i++) {
			if(!(meetingDays.charAt(i) == 'M') && !(meetingDays.charAt(i) == 'T')
					&& !(meetingDays.charAt(i) == 'W') && !(meetingDays.charAt(i) == 'H')
					&& !(meetingDays.charAt(i) == 'F')) {
				isValid = false;
				break;
			}
		}
		
		if(!isValid) {
			throw new IllegalArgumentException();
		}
		if(isValid) {
			this.meetingDays = meetingDays;	
		}
		
	}
	
	/**
	 * Returns the Course's startTime
	 * 
	 * @return the startTime of the Course
	 */
	public int getStartTime() {
		return startTime;
	}

	
	/**
	 * Returns the Course's endTime
	 * 
	 * @return the endTime of the Course
	 */
	public int getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets Course's startTime and endTime. If the startTime
	 * or endTime is not between 0 and 2359 included, 
	 * an IllegalArgumentException is thrown.
	 * If the Course has meeting days of "A" then
	 * startTime and endTime are set to 0000.
	 * 
	 * @param startTime 
	 * 			The Course's startTime
	 * @param endTime 
	 * 			The Course's end time
	 * @throws IllegalArgumentException 
	 * 			If start time or end time is less than 0 or greater than 2359, 
	 * 			and the minutes are not between 0 and 59 inclusive.
	 */
	public void setCourseTime(int startTime, int endTime) {
		if(startTime / TIME_CONSTANT < 0 || startTime / TIME_CONSTANT > UPPER_TIME / TIME_CONSTANT - 1) {
			throw new IllegalArgumentException();
		}
		if(startTime % TIME_CONSTANT < 0 || startTime % TIME_CONSTANT > UPPER_HOUR - 1) {
			throw new IllegalArgumentException();
		}
		if(endTime / TIME_CONSTANT < 0 || endTime / TIME_CONSTANT > UPPER_TIME / TIME_CONSTANT - 1) {
			throw new IllegalArgumentException();
		}
		if(endTime % TIME_CONSTANT < 0 || endTime % TIME_CONSTANT > UPPER_HOUR - 1) {
			throw new IllegalArgumentException();
		}
		if(endTime < startTime) {
			throw new IllegalArgumentException();
		}
		if(this.meetingDays.equals("A")) {
			this.startTime = 0000;
			this.endTime = 0000;
			return;
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Returns a String of meetingDays followed by startTime
	 * and endTime in standard time format with respective
	 * AM and PM.
	 * 
	 * @return a String representation of Course meetingDays 
	 * and startTime and endTime.
	 */
	public String getMeetingString() {
		if(this.meetingDays.contentEquals("A")) {
			return "Arranged";
		}
		String startTimeStandard = convertTimeMilitaryToStandard(this.startTime);
		String endTimeStandard = convertTimeMilitaryToStandard(this.endTime);
		return this.meetingDays + " " + startTimeStandard + "-" + endTimeStandard;
	}
	
	/**
	 * Returns a string representation of militaryTime with AM or 
	 * PM attached to the end. For example 1340 would return "1:40PM".
	 * 
	 * @param militaryTime 
	 * 			The time in military time to be converted
	 * 			to standard time format
	 * @return a String representation of time in standard format 
	 */
	private String convertTimeMilitaryToStandard(int militaryTime) {
		int hour = militaryTime / TIME_CONSTANT;
		int minutes = militaryTime % TIME_CONSTANT;

		// PM times
		if (hour >= AM_OR_PM) {
			hour = hour % AM_OR_PM;
			if (hour == 0) {
				hour = AM_OR_PM;
			}

			if (minutes < SINGLE_DIGIT_MINUTE) {
				return hour + ":0" + minutes + "PM";
			}

			return hour + ":" + minutes + "PM";
		}

		// AM times
		if (hour == 0) {
			hour = AM_OR_PM;
		}
		if (minutes < SINGLE_DIGIT_MINUTE) {
			return hour + ":0" + minutes + "AM";
		}

		return hour + ":" + minutes + "AM";
	}
	
	/**
	 * Generates a hashCode for Course using all fields.
	 * 
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + endTime;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Compares a given object to this object for equality on all fields
	 * 
	 * @param obj 
	 * 		The Object to compare
	 * @return true if the objects are the same on all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (endTime != other.endTime)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Returns a comma separated value String of all Course fields.
	 * 
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
	    if (meetingDays.equals("A")) {
	        return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays;
	    }
	    return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays + "," + startTime + "," + endTime; 
	}
	

}
