package model;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDateTime;
import javax.xml.datatype.DatatypeConfigurationException;

public class PracticeLogEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	public PracticeLogEntry(LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @param startTime
	 *            formatted as yyyy-MM-dd'T'HH:mm:ss
	 * @param endTime
	 *            formatted as yyyy-MM-dd'T'HH:mm:ss
	 * @throws DatatypeConfigurationException
	 * @throws ParseException
	 */
	public PracticeLogEntry(String startTimeAsString, String endTimeAsString) {
		this.startTime = date(startTimeAsString);
		this.endTime = date(endTimeAsString);
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	private LocalDateTime date(String date ) {
        return LocalDateTime.parse( date );
    }
}
