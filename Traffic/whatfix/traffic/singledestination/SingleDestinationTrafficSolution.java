package whatfix.traffic.singledestination;

import java.util.Iterator;
import java.util.List;

public class SingleDestinationTrafficSolution {
	public static Route getShortestRoute(List<Orbit> orbitList, List<Vehicle> vehicleList, Weather weather) {
		float min = -1;
		Route route = new Route();

		modifyOrbitListByWeather(orbitList, weather);
		retainAllowedVehicleList(vehicleList, weather);
		for (Orbit orbit : orbitList) {
			for (Vehicle vehicle : vehicleList) {

				printDebug("prev", min, route.getOrbit(), route.getVehicle());

				float tmpTime = getMinutesToTravel(orbit, vehicle);
				if (min == -1 || min > tmpTime) {

					min = tmpTime;
					route.setOrbit(orbit);
					route.setVehicle(vehicle);

				} else if (min == tmpTime) {
					if (vehicle.getName().getPriority() < route.getVehicle().getName().getPriority()) {
						route.setVehicle(vehicle);
					}
				}

				printDebug("current", min, orbit, vehicle);
				printDebug("best", min, route.getOrbit(), route.getVehicle());

			}
		}
		return route;
	}

	private static void printDebug(String string, float min, Orbit route, Vehicle vehicle) {
//		if (route == null) {
//			return;
//		}
//		System.out.println(string + " " + min + " " + route + " " + vehicle);
//		System.out.println();
	}

	public static Route getShortestRoute(List<Orbit> orbitList, Vehicle vehicle, Weather weather) {
		float min = -1;
		Route route = null;

		modifyOrbitListByWeather(orbitList, weather);
		if (!weather.getAllowedVehicle().contains(vehicle.getName())) {
			return null;
		}
		route = new Route();
		for (Orbit orbit : orbitList) {
			printDebug("prev", min, route.getOrbit(), route.getVehicle());

			float tmpTime = getMinutesToTravel(orbit, vehicle);
			if (min == -1 || min > tmpTime) {

				min = tmpTime;
				route.setOrbit(orbit);
				route.setVehicle(vehicle);

			} else if (min == tmpTime) {
				if (vehicle.getName().getPriority() < route.getVehicle().getName().getPriority()) {
					route.setVehicle(vehicle);
				}
			}

			printDebug("current", min, orbit, vehicle);
			printDebug("best", min, route.getOrbit(), route.getVehicle());
		}
		return route;
	}

	public static float getMinutesToTravel(Orbit orbit, Vehicle vehicle) {
		int maxSpeed = Math.min(orbit.getTraffic(), vehicle.getSpeed());
		return (float) (((float) orbit.getDistance() / maxSpeed * 60.0)
				+ (orbit.getNoOfCrater() * vehicle.getTimeToCrater()));
	}

	private static List<Vehicle> retainAllowedVehicleList(List<Vehicle> vehicleList, Weather weather) {
		Iterator<Vehicle> iterator = vehicleList.iterator();
		while (iterator.hasNext()) {
			if (!weather.getAllowedVehicle().contains(iterator.next().getName())) {
				iterator.remove();
			}
		}
		return vehicleList;
	}

	private static List<Orbit> modifyOrbitListByWeather(List<Orbit> orbitList, Weather weather) {
		for (Orbit orbit : orbitList) {
			orbit.setNoOfCrater(orbit.getNoOfCrater() * (100 + weather.getPercentageChangeInCrater()) / 100);
		}
		return orbitList;
	}
}
