package whatfix.traffic.singledestination;

public class Orbit {
	int distance;
	int noOfCrater;
	int traffic;
	String name;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getNoOfCrater() {
		return noOfCrater;
	}

	public void setNoOfCrater(int noOfCrater) {
		this.noOfCrater = noOfCrater;
	}

	public int getTraffic() {
		return traffic;
	}

	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Orbit [distance=" + distance + ", noOfCrater=" + noOfCrater + ", traffic=" + traffic + ", name=" + name
				+ "]";
	}

}
