package whatfix.traffic.singledestination;

import java.util.ArrayList;
import java.util.List;

import whatfix.traffic.singledestination.Vehicle.VehicleName;

public class Weather {
	String name;
	List<VehicleName> allowedVehicle;
	int percentageChangeInCrater;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VehicleName> getAllowedVehicle() {
		return allowedVehicle;
	}

	public void addAllowedVehicle(VehicleName vehicle) {
		if (allowedVehicle == null) {
			allowedVehicle = new ArrayList<>();
		}
		allowedVehicle.add(vehicle);
	}

	public int getPercentageChangeInCrater() {
		return percentageChangeInCrater;
	}

	public void setPercentageChangeInCrater(int percentageChangeInCrater) {
		this.percentageChangeInCrater = percentageChangeInCrater;
	}

	@Override
	public String toString() {
		return "Weather [name=" + name + ", allowedVehicle=" + allowedVehicle + ", percentageChangeInCrater="
				+ percentageChangeInCrater + "]";
	}

}
