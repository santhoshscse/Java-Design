package whatfix.traffic.multidestination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import whatfix.traffic.singledestination.Orbit;
import whatfix.traffic.singledestination.SingleDestinationTrafficSolution;
import whatfix.traffic.singledestination.Vehicle;
import whatfix.traffic.singledestination.Weather;

/**
 * This class helps to visit multiple destinations from given source
 */
public class MultiDestinationTrafficSolution {

	public static BestRoute getRouteMapSingleVehicleOption(int source, RoutePath[][] originalRouteMatrix,
			List<Integer> destinationListToVist, HashMap<String, Orbit> orbitMap, List<Vehicle> vehicleList,
			Weather weather, HashMap<Integer, Location> locationMap) {

		modifyOrbitListByWeather(orbitMap, weather);
		List<List<Integer>> routePathList = RouteCombinationUtil.getCombinationList(destinationListToVist);

		BestRoute bestRoute = null;
		for (Vehicle vehicle : vehicleList) {

			RoutePath[][] routeMatrix = RoutePathHelper.getRouteMatrixForVehicle(originalRouteMatrix, orbitMap, weather,
					vehicle, locationMap);

			BestRoute res = findBestRoute(source, orbitMap, weather, routePathList, bestRoute, vehicle, routeMatrix);
			if (bestRoute == null || bestRoute.getMinDist() > res.getMinDist()) {
				bestRoute = res;
			} else if (bestRoute.getMinDist() == res.getMinDist()
					&& bestRoute.getVehicle().getName().getPriority() > res.getVehicle().getName().getPriority()) {
				bestRoute = res;
			}
		}
		return bestRoute;

	}

	private static void modifyOrbitListByWeather(HashMap<String, Orbit> orbitMap, Weather weather) {

		for (String orbitName : orbitMap.keySet()) {
			Orbit orbit = orbitMap.get(orbitName);
			orbit.setNoOfCrater(orbit.getNoOfCrater() * (100 + weather.getPercentageChangeInCrater()) / 100);
		}

	}

	private static BestRoute findBestRoute(int source, HashMap<String, Orbit> orbitMap, Weather weather,
			List<List<Integer>> routePathList, BestRoute bestRoute, Vehicle vehicle, RoutePath[][] routeMatrix) {
		for (List<Integer> routePath : routePathList) {

			BestRoute res = getBestRouteForVehicle(source, routeMatrix, orbitMap, vehicle, weather, routePath);

			printDebugInfo(bestRoute);

			if (bestRoute == null || bestRoute.getMinDist() > res.getMinDist()) {
				bestRoute = res;
			} else if (bestRoute.getMinDist() == res.getMinDist()
					&& bestRoute.getVehicle().getName().getPriority() > res.getVehicle().getName().getPriority()) {
				bestRoute = res;
			}
			printDebugInfo(res);
			printDebugInfo(bestRoute);

		}
		return bestRoute;
	}

	private static void printDebugInfo(BestRoute bestRoute) {
		// if (bestRoute == null) {
		// return;
		// }
		// System.out.println(bestRoute.getRoutePath());
		// System.out.println(bestRoute.getOrbitList());
		// System.out.println(bestRoute.getMinDist());
		// System.out.println(bestRoute.getVehicle().getName());
		// System.out.println();
	}

	private static BestRoute getBestRouteForVehicle(int source, RoutePath[][] routeMatrix,
			HashMap<String, Orbit> orbitMap, Vehicle vehicle, Weather weather, List<Integer> routePath) {
		int start = source;
		float tmpMin = 0;

		List<String> bestRouteList = new ArrayList<>();
		for (Integer destination : routePath) {

			if (routeMatrix[start][destination].isDirectRouteAvailable()) {
				// String bestOrbit =
				// RoutePathHelperUtil.getShortestRoute(routeMatrix, orbitMap,
				// vehicle, weather, start,
				// destination, routeMatrix[start][destination]);
				String bestOrbit = routeMatrix[start][destination].getBestOrbit();

				Orbit orbit = orbitMap.get(bestOrbit);

				bestRouteList.add(bestOrbit);
				tmpMin += SingleDestinationTrafficSolution.getMinutesToTravel(orbit, vehicle);
				start = destination;
			} else if (routeMatrix[start][destination].isConnectingRouteAvailable()) {
				return findBestRoute(source, orbitMap, weather,
						routeMatrix[start][destination].getConnectingRouteList(), null, vehicle, routeMatrix);
			}
		}
		BestRoute bestRoute = new BestRoute(routePath, bestRouteList, vehicle, tmpMin);
		return bestRoute;
	}

}
