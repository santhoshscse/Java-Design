package whatfix.traffic.multidestination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import whatfix.traffic.singledestination.Orbit;
import whatfix.traffic.singledestination.Route;
import whatfix.traffic.singledestination.SingleDestinationTrafficSolution;
import whatfix.traffic.singledestination.Vehicle;
import whatfix.traffic.singledestination.Weather;

/**
 * This class helps
 * 
 * 1. To memoize best routes from given source to destination 2. To find
 * possible routes from one destination to another destination in recursive way
 */
public class RoutePathHelper {

	public static RoutePath[][] getRouteMatrixForVehicle(RoutePath[][] originalRouteMatrix,
			HashMap<String, Orbit> orbitMap, Weather weather, Vehicle vehicle, HashMap<Integer, Location> locationMap) {
		RoutePath[][] routeMatrix = originalRouteMatrix.clone();
		fillBestRoute(routeMatrix, orbitMap, vehicle, weather);
		fillConnectingRouteList(routeMatrix, locationMap);
		return routeMatrix;
	}

	private static void fillBestRoute(RoutePath[][] routeMatrix, HashMap<String, Orbit> orbitMap, Vehicle vehicle,
			Weather weather) {
		for (int i = 0; i < routeMatrix.length; i++) {
			for (int j = 0; j < routeMatrix[i].length; j++) {
				RoutePath tmpRouteMatrix = routeMatrix[i][j];
				if (tmpRouteMatrix == null) {
					continue;
				}
				if (tmpRouteMatrix.getBestOrbit() == null) {
					getShortestRoute(routeMatrix, orbitMap, vehicle, weather, i, j, tmpRouteMatrix);
				}

			}
		}
	}

	public static String getShortestRoute(RoutePath[][] routeMatrix, HashMap<String, Orbit> orbitMap, Vehicle vehicle,
			Weather weather, int i, int j, RoutePath tmpRouteMatrix) {
		Route route = SingleDestinationTrafficSolution
				.getShortestRoute(getAsOrbitList(tmpRouteMatrix.getListOfOrbits(), orbitMap), vehicle, weather);
		tmpRouteMatrix.setBestOrbit(route.getOrbit().getName());
		routeMatrix[j][i].setBestOrbit(route.getOrbit().getName());
		return route.getOrbit().getName();
	}

	private static List<Orbit> getAsOrbitList(List<String> listOfOrbits, HashMap<String, Orbit> orbitMap) {
		List<Orbit> orbitList = new ArrayList<>(listOfOrbits.size());
		for (String name : listOfOrbits) {
			orbitList.add(orbitMap.get(name));
		}
		return orbitList;
	}

	public static void fillConnectingRouteList(RoutePath[][] routeMatrix, HashMap<Integer, Location> locMap) {
		for (int i = 0; i < routeMatrix.length; i++) {
			for (int j = 0; j < routeMatrix[i].length; j++) {

				if (i == j) {
					continue;
				}
				if (routeMatrix[i][j] == null) {
					routeMatrix[i][j] = new RoutePath();
				}
				if (!routeMatrix[i][j].isDirectRouteAvailable() && !routeMatrix[i][j].isConnectingRouteAvailable()) {
					List<Integer> path = new ArrayList<>();
					path.add(i);
					List<List<Integer>> pathList = new ArrayList<>();
					findPossibleWays(i, j, path, pathList, locMap);
					if (pathList.size() > 0) {
						routeMatrix[i][j].setConnectingRouteList(pathList);
						if (routeMatrix[j][i] == null) {
							routeMatrix[j][i] = new RoutePath();
						}
						routeMatrix[i][j].setConnectingRouteList(pathList);
					}
				}
			}
		}
	}

	private static List<Integer> findPossibleWays(int startLoc, int endLoc, List<Integer> path,
			List<List<Integer>> pathList, HashMap<Integer, Location> locMap) {

		if (startLoc == endLoc) {
			return path;
		}

		for (Integer loc : locMap.get(startLoc).getConnectingLocation()) {
			if (path.contains(loc)) {
				continue;
			}
			List<Integer> tmpPath = new ArrayList<>(path);
			tmpPath.add(loc);
			tmpPath = findPossibleWays(loc, endLoc, tmpPath, pathList, locMap);
			if (tmpPath != null) {
				pathList.add(tmpPath);
			}
		}

		return null;
	}
}
