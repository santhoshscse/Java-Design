package whatfix.traffic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import whatfix.traffic.multidestination.Location;
import whatfix.traffic.multidestination.RoutePath;
import whatfix.traffic.multidestination.RoutePathHelper;
import whatfix.traffic.singledestination.Orbit;
import whatfix.traffic.singledestination.Vehicle;
import whatfix.traffic.singledestination.Weather;
import whatfix.traffic.singledestination.Vehicle.VehicleName;

class InputUtil {

	public static void main(String[] args) {
		getRouteMatrixNew();
	}

	public static RoutePath[][] getRouteMatrixNew() {

		// 0 - silkboard
		// 1 - marathhalli
		// 2 - kr puram
		int noOfPlaces = 3;
		RoutePath[][] routeMatrix = new RoutePath[noOfPlaces][noOfPlaces];
		HashMap<Integer, Location> locMap = new HashMap<>();
		Location loc0 = new Location();
		loc0.setId(0);
		loc0.addToConnectingLocation(1);
		loc0.addToConnectingLocation(2);
		locMap.put(0, loc0);

		Location loc1 = new Location();
		loc1.setId(1);
		loc1.addToConnectingLocation(0);
		loc1.addToConnectingLocation(2);
		locMap.put(1, loc1);

		Location loc2 = new Location();
		loc2.setId(2);
		loc2.addToConnectingLocation(0);
		loc2.addToConnectingLocation(1);
		locMap.put(2, loc2);

		RoutePath tmp1 = new RoutePath();
		tmp1.addToListOfOrbits("Orbit1");
		routeMatrix[0][1] = tmp1;
		routeMatrix[1][0] = tmp1;

		RoutePath tmp2 = new RoutePath();
		tmp2.addToListOfOrbits("Orbit2");
		routeMatrix[0][2] = tmp2;
		routeMatrix[2][0] = tmp2;

		RoutePathHelper.fillConnectingRouteList(routeMatrix, locMap);

		return routeMatrix;
	}

	public static RoutePath[][] getRouteMatrix() {

		// 0 - silkboard
		// 1 - marathhalli
		// 2 - kr puram
		int noOfPlaces = 3;
		RoutePath[][] routeMatrix = new RoutePath[noOfPlaces][noOfPlaces];

		RoutePath tmp1 = new RoutePath();
		tmp1.addToListOfOrbits("Orbit1");
		tmp1.addToListOfOrbits("Orbit2");
		routeMatrix[0][1] = tmp1;
		routeMatrix[1][0] = tmp1;

		RoutePath tmp2 = new RoutePath();
		tmp2.addToListOfOrbits("Orbit3");
		routeMatrix[0][2] = tmp2;
		routeMatrix[2][0] = tmp2;

		RoutePath tmp3 = new RoutePath();
		tmp3.addToListOfOrbits("Orbit4");
		routeMatrix[1][2] = tmp3;
		routeMatrix[2][1] = tmp3;

		return routeMatrix;
	}

	public static HashMap<String, Orbit> getOrbitMap() {
		HashMap<String, Orbit> orbitMap = new HashMap<>();
		Orbit orbit1 = new Orbit();
		orbit1.setName("Orbit1");
		orbit1.setDistance(18);
		orbit1.setNoOfCrater(20);
		orbitMap.put(orbit1.getName(), orbit1);

		Orbit orbit2 = new Orbit();
		orbit2.setName("Orbit2");
		orbit2.setDistance(20);
		orbit2.setNoOfCrater(10);
		orbitMap.put(orbit2.getName(), orbit2);

		Orbit orbit3 = new Orbit();
		orbit3.setName("Orbit3");
		orbit3.setDistance(30);
		orbit3.setNoOfCrater(15);
		orbitMap.put(orbit3.getName(), orbit3);

		Orbit orbit4 = new Orbit();
		orbit4.setName("Orbit4");
		orbit4.setDistance(15);
		orbit4.setNoOfCrater(18);
		orbitMap.put(orbit4.getName(), orbit4);

		return orbitMap;
	}

	public static List<Vehicle> getVehicleList() {
		List<Vehicle> vehicleList = new ArrayList<>();
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName(VehicleName.BIKE);
		vehicle1.setSpeed(10);
		vehicle1.setTimeToCrater(2);
		vehicleList.add(vehicle1);

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName(VehicleName.TUKTUK);
		vehicle2.setSpeed(12);
		vehicle2.setTimeToCrater(1);
		vehicleList.add(vehicle2);

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName(VehicleName.CAR);
		vehicle3.setSpeed(20);
		vehicle3.setTimeToCrater(3);
		vehicleList.add(vehicle3);
		return vehicleList;
	}

	public static Weather getSunnyWeather() {
		Weather weather = new Weather();
		weather.setName("Sunny");
		weather.addAllowedVehicle(VehicleName.BIKE);
		weather.addAllowedVehicle(VehicleName.TUKTUK);
		weather.addAllowedVehicle(VehicleName.CAR);
		weather.setPercentageChangeInCrater(-10);
		return weather;
	}

	public static Weather getWindyWeather() {
		Weather weather = new Weather();
		weather.setName("Windy");
		weather.addAllowedVehicle(VehicleName.BIKE);
		weather.addAllowedVehicle(VehicleName.CAR);
		weather.setPercentageChangeInCrater(0);
		return weather;
	}

}
