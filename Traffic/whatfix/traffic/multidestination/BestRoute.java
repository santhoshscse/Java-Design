package whatfix.traffic.multidestination;

import java.util.List;

import whatfix.traffic.singledestination.Vehicle;

public class BestRoute {
	List<Integer> routePath;
	List<String> orbitList;
	Vehicle vehicle;
	float minDist;

	public BestRoute(List<Integer> routePath, List<String> routeList, Vehicle vehicle, float minDist) {
		this.routePath = routePath;
		this.orbitList = routeList;
		this.vehicle = vehicle;
		this.minDist = minDist;
	}

	public List<Integer> getRoutePath() {
		return routePath;
	}

	public List<String> getOrbitList() {
		return orbitList;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public float getMinDist() {
		return minDist;
	}

}
