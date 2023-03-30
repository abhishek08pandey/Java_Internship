package singletonDesignPattern;

public class StaticBlockInitialization {

	private static StaticBlockInitialization staticBlockInitialization;

	private StaticBlockInitialization() {
	}

	static {
		if (staticBlockInitialization == null) {
			staticBlockInitialization = new StaticBlockInitialization();
		}
	}

	public static StaticBlockInitialization getInstance() {
		return staticBlockInitialization;
	}// here first class loaded than static block through instance initialize than as per client call method return its Instance
	//that is not thread safe
}
