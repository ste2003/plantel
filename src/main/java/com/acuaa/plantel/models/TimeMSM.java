package com.acuaa.plantel.models;

import java.util.Objects;

public class TimeMSM {
	private Integer minutes;
	
	private Integer seconds;
	
	private Integer miliseconds;

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	public Integer getMiliseconds() {
		return miliseconds;
	}

	public void setMiliseconds(Integer miliseconds) {
		this.miliseconds = miliseconds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(miliseconds, minutes, seconds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeMSM other = (TimeMSM) obj;
		return Objects.equals(miliseconds, other.miliseconds) && Objects.equals(minutes, other.minutes)
				&& Objects.equals(seconds, other.seconds);
	}

	@Override
	public String toString() {
		return "TimeMSM [minutes=" + minutes + ", seconds=" + seconds + ", miliseconds=" + miliseconds + "]";
	}
	
	
}
