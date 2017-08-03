package whatfix.traffic.singledestination;

public class Vehicle {

	public enum VehicleName {
		BIKE(1), TUKTUK(2), CAR(3);

		private int priority;

		private VehicleName(int priority) {
			this.priority = priority;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

	}

	VehicleName name;
	int speed;
	int timeToCrater;

	public VehicleName getName() {
		return name;
	}

	public void setName(VehicleName name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTimeToCrater() {
		return timeToCrater;
	}

	public void setTimeToCrater(int timeToCrater) {
		this.timeToCrater = timeToCrater;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", speed=" + speed + ", timeToCrater=" + timeToCrater + "]";
	}

}
