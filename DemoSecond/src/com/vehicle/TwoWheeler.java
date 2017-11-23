package com.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("two")
public class TwoWheeler extends Vehicle {
	public String steeringHandle;

	public TwoWheeler() {
		super();
	}

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
