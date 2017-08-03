package whatfix.traffic.multidestination;

import java.util.ArrayList;
import java.util.List;

/**
 * This class keeps track of Location & other locations where current location
 * able to connect
 */
public class Location {
	int id;
	List<Integer> connectingLocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getConnectingLocation() {
		return connectingLocation;
	}

	public void addToConnectingLocation(Integer location) {
		if (connectingLocation == null) {
			connectingLocation = new ArrayList<>();
		}
		connectingLocation.add(location);
	}

	public void setConnectingLocation(List<Integer> connectingLocation) {
		this.connectingLocation = connectingLocation;
	}

}
