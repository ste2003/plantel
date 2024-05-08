package com.acuaa.plantel.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "distances")
public class Distance {
	@Id
	@Column(name="id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="distance")
	private Integer distance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Distance [id=" + id + ", distance=" + distance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distance other = (Distance) obj;
		return Objects.equals(distance, other.distance) && Objects.equals(id, other.id);
	}
	
	
}
