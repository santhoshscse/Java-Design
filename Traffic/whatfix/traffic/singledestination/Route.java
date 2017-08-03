package whatfix.traffic.singledestination;

public class Route {
	Orbit orbit;
	Vehicle vehicle;

	public Orbit getOrbit() {
		return orbit;
	}

	public void setOrbit(Orbit orbit) {
		this.orbit = orbit;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Route [orbit=" + orbit + ", vehicle=" + vehicle + "]";
	}

}
