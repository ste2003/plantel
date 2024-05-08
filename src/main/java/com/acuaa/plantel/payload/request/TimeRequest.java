package com.acuaa.plantel.payload.request;

import java.util.Date;

import com.acuaa.plantel.models.SwimStyle;
import com.acuaa.plantel.models.User;

public class TimeRequest {
	private Long userId;
	
	private Date date;
	
	private String swimmingpool;
	
	private Integer distance;
	
	private SwimStyle swimStyle;
	
	private Integer minutes;
	
	private Integer seconds;
	
	private Integer miliseconds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSwimmingpool() {
		return swimmingpool;
	}

	public void setSwimmingpool(String swimmingpool) {
		this.swimmingpool = swimmingpool;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public SwimStyle getSwimStyle() {
		return swimStyle;
	}

	public void setSwimStyle(SwimStyle swimStyle) {
		this.swimStyle = swimStyle;
	}

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
	public String toString() {
		return "TimeRequest [userId=" + userId + ", date=" + date + ", swimmingpool=" + swimmingpool + ", distance="
				+ distance + ", swimStyle=" + swimStyle + ", minutes=" + minutes + ", seconds=" + seconds
				+ ", miliseconds=" + miliseconds + "]";
	}
	
}
