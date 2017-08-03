package whatfix.traffic.test;

public enum PlaceName {
	SilkDorb(0), Hallitharam(1), RKPuram(2);

	private int id;

	private PlaceName(int id) {
		this.id = id;
	}

	public static PlaceName getPlaceName(int id) {
		switch (id) {
		case 0:
			return SilkDorb;
		case 1:
			return Hallitharam;
		case 2:
			return PlaceName.RKPuram;
		default:
			return null;
		}
	}
}
