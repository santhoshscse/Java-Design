package whatfix.traffic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import whatfix.traffic.multidestination.BestRoute;
import whatfix.traffic.multidestination.MultiDestinationTrafficSolution;
import whatfix.traffic.multidestination.RoutePath;
import whatfix.traffic.singledestination.Orbit;

public class MultiDestinationTrafficTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		case1();

		System.out.println("=======================");

		case2();
	}

	private static void case1() {
		RoutePath[][] routeMatrix = InputUtil.getRouteMatrix();
		List<Integer> destinationListToVist = new ArrayList<>();
		destinationListToVist.add(1);
		destinationListToVist.add(2);

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		orbitMap.get("Orbit1").setTraffic(12);
		orbitMap.get("Orbit2").setTraffic(10);
		orbitMap.get("Orbit3").setTraffic(15);
		orbitMap.get("Orbit4").setTraffic(12);

		int source = 0;
		BestRoute res = MultiDestinationTrafficSolution.getRouteMapSingleVehicleOption(source, routeMatrix,
				destinationListToVist, orbitMap, InputUtil.getVehicleList(), InputUtil.getSunnyWeather(),
				InputUtil.getLocationMap());

		List<Integer> routePath = res.getRoutePath();
		List<String> routeList = res.getOrbitList();
		System.out.print("Case 1 results::");
		System.out.println("For case 1 your answer is wrong, right one is below");
		printResult(source, res, routePath, routeList);
	}

	private static void printResult(int source, BestRoute res, List<Integer> routePath, List<String> routeList) {
		System.out.println("Vehicle : " + res.getVehicle().getName());
		for (int i = 0; i < routeList.size(); i++) {
			String orbit = routeList.get(i);
			Integer start = i == 0 ? source : routePath.get(i - 1);

			System.out.println("From " + PlaceName.getPlaceName(start) + " to "
					+ PlaceName.getPlaceName(routePath.get(i)) + " via " + orbit);
		}
	}

	private static void case2() {
		RoutePath[][] routeMatrix = InputUtil.getRouteMatrix();
		List<Integer> destinationListToVist = new ArrayList<>();
		destinationListToVist.add(1);
		destinationListToVist.add(2);

		HashMap<String, Orbit> orbitMap = InputUtil.getOrbitMap();
		orbitMap.get("Orbit1").setTraffic(5);
		orbitMap.get("Orbit2").setTraffic(10);
		orbitMap.get("Orbit3").setTraffic(20);
		orbitMap.get("Orbit4").setTraffic(20);

		int source = 0;
		BestRoute res = MultiDestinationTrafficSolution.getRouteMapSingleVehicleOption(source, routeMatrix,
				destinationListToVist, orbitMap, InputUtil.getVehicleList(), InputUtil.getSunnyWeather(),
				InputUtil.getLocationMap());

		List<Integer> routePath = res.getRoutePath();
		List<String> routeList = res.getOrbitList();
		System.out.println("Case 2 results:");
		printResult(source, res, routePath, routeList);
	}

}
