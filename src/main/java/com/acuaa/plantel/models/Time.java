package com.acuaa.plantel.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "times")
public class Time {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	private String swimmingpool;
	
	private Integer distance;
	
	@Enumerated(EnumType.STRING)
	@Column(name="swim_style")
	private SwimStyle swimStyle;
	
	private Integer minutes;
	
	private Integer seconds;
	
	private Integer miliseconds;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	

	public Time(Long id, Date date, String swimmingpool, Integer distance, SwimStyle swimStyle, Integer minutes,
			Integer seconds, Integer miliseconds, User user) {
		this.date = date;
		this.swimmingpool = swimmingpool;
		this.distance = distance;
		this.swimStyle = swimStyle;
		this.minutes = minutes;
		this.seconds = seconds;
		this.miliseconds = miliseconds;
		this.user = user;
	}
	public Time() {
		this.date = null;
		this.swimmingpool = null;
		this.distance = null;
		this.swimStyle = null;
		this.minutes = null;
		this.seconds = null;
		this.miliseconds = null;
		this.user = null;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Time [id=" + id + ", date=" + date + ", swimmingpool=" + swimmingpool + ", distance=" + distance
				+ ", swimStyle=" + swimStyle + ", minutes=" + minutes + ", seconds=" + seconds + ", miliseconds="
				+ miliseconds + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, distance, id, miliseconds, minutes, seconds, swimStyle, swimmingpool, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(date, other.date) && Objects.equals(distance, other.distance)
				&& Objects.equals(id, other.id) && Objects.equals(miliseconds, other.miliseconds)
				&& Objects.equals(minutes, other.minutes) && Objects.equals(seconds, other.seconds)
				&& swimStyle == other.swimStyle && Objects.equals(swimmingpool, other.swimmingpool)
				&& Objects.equals(user, other.user);
	}

	
}
