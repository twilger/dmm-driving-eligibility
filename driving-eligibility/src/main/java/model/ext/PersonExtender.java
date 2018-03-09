package model.ext;

import java.time.Duration;

import model.Person;
import model.PracticeLogEntry;

public class PersonExtender {

	public static Duration calculateTotalPracticeDuration(Person aPerson) {
		Duration retVal =  Duration.ZERO;
		
		for (PracticeLogEntry entry : aPerson.getPracticeLogEntries()) {
			retVal = retVal.plus(Duration.between(entry.getStartTime(), entry.getEndTime()));
		}
		
		return retVal;
	}
	
}
