package com.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("four")
public class FourWheeler extends Vehicle {
	public String steeringWheel;

	public FourWheeler() {
		super();
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
