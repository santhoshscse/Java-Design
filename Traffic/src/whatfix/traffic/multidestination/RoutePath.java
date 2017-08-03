package whatfix.traffic.multidestination;

import java.util.ArrayList;
import java.util.List;

public class RoutePath implements Cloneable {
	List<String> orbitList = new ArrayList<>();
	String bestOrbit;
	List<List<Integer>> connectingRouteList = new ArrayList<>();

	public List<List<Integer>> getViaList() {
		return connectingRouteList;
	}

	public List<List<Integer>> getConnectingRouteList() {
		return connectingRouteList;
	}

	public void setConnectingRouteList(List<List<Integer>> pathList) {
		this.connectingRouteList = pathList;
	}

	public List<String> getListOfOrbits() {
		return orbitList;
	}

	public void addToListOfOrbits(String orbit) {
		orbitList.add(orbit);
	}

	public void setBestOrbit(String bestRoute) {
		this.bestOrbit = bestRoute;
	}

	public String getBestOrbit() {
		return bestOrbit;
	}

	public boolean isDirectRouteAvailable() {
		return orbitList.size() > 0;
	}

	public boolean isConnectingRouteAvailable() {
		return connectingRouteList.size() > 0;
	}

	@Override
	public RoutePath clone() {
		RoutePath path = new RoutePath();
		path.orbitList = new ArrayList<>(this.orbitList);
		for (List<Integer> routeList : this.connectingRouteList) {
			path.connectingRouteList.add(new ArrayList<>(routeList));
		}
		return path;
	}

}
