package whatfix.traffic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import whatfix.traffic.singledestination.Orbit;
import whatfix.traffic.singledestination.Route;
import whatfix.traffic.singledestination.SingleDestinationTrafficSolution;
import whatfix.traffic.singledestination.Vehicle;
import whatfix.traffic.singledestination.Weather;

public class SingleDestinationTrafficTest {

	public static void main(String[] args) {
		case1();
		System.out.println("===============");
		case2();
		System.out.println("===============");
		case3();
		System.out.println("===============");
		case4();

	}

	private static void case1() {
		Weather weather = InputUtil.getSunnyWeather();

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		List<Orbit> orbitList = new ArrayList<>();
		Orbit orbit1 = orbitMap.get("Orbit1");
		orbit1.setTraffic(12);
		orbitList.add(orbit1);

		Orbit orbit2 = orbitMap.get("Orbit2");
		orbit2.setTraffic(10);
		orbitList.add(orbit2);

		List<Vehicle> vehicleList = InputUtil.getVehicleList();

		Route route = SingleDestinationTrafficSolution.getShortestRoute(orbitList, vehicleList, weather);

		System.out.println("Case3 result :: " + route.getVehicle().getName() + " " + route.getOrbit().getName());
	}

	private static void case2() {
		Weather weather = InputUtil.getWindyWeather();

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		List<Orbit> orbitList = new ArrayList<>();
		Orbit orbit1 = orbitMap.get("Orbit1");
		orbit1.setTraffic(14);
		orbitList.add(orbit1);

		Orbit orbit2 = orbitMap.get("Orbit2");
		orbit2.setTraffic(20);
		orbitList.add(orbit2);

		List<Vehicle> vehicleList = InputUtil.getVehicleList();

		Route route = SingleDestinationTrafficSolution.getShortestRoute(orbitList, vehicleList, weather);

		System.out.println("Case2 result :: " + route.getVehicle().getName() + " " + route.getOrbit().getName());
	}

	private static void case3() {
		Weather weather = InputUtil.getSunnyWeather();

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		List<Orbit> orbitList = new ArrayList<>();
		Orbit orbit1 = orbitMap.get("Orbit1");
		orbit1.setTraffic(10);
		orbitList.add(orbit1);

		Orbit orbit2 = orbitMap.get("Orbit2");
		orbit2.setTraffic(12);
		orbitList.add(orbit2);

		List<Vehicle> vehicleList = InputUtil.getVehicleList();

		Route route = SingleDestinationTrafficSolution.getShortestRoute(orbitList, vehicleList, weather);

		System.out.println("Case3 result :: " + route.getVehicle().getName() + " " + route.getOrbit().getName());
	}

	private static void case4() {
		Weather weather = InputUtil.getSunnyWeather();

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		List<Orbit> orbitList = new ArrayList<>();
		Orbit orbit1 = orbitMap.get("Orbit1");
		orbit1.setTraffic(10);
		orbitList.add(orbit1);

		Orbit orbit2 = orbitMap.get("Orbit2");
		orbit2.setTraffic(12);
		orbitList.add(orbit2);

		Orbit orbit3 = orbitMap.get("Orbit3");
		orbit3.setTraffic(15);
		orbitList.add(orbit3);

		Orbit orbit4 = orbitMap.get("Orbit4");
		orbit4.setTraffic(12);
		orbitList.add(orbit4);

		List<Vehicle> vehicleList = InputUtil.getVehicleList();

		Route route = SingleDestinationTrafficSolution.getShortestRoute(orbitList, vehicleList, weather);

		System.out.println("Case4 result :: " + route.getVehicle().getName() + " " + route.getOrbit().getName());
	}
}
