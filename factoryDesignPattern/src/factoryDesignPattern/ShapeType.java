package factoryDesignPattern;

public class ShapeType {

	public Shape getShape(String shaprType) {
		
		if(shaprType==null) {
			return null;
		}
		else if(shaprType.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		else if(shaprType.equalsIgnoreCase("ractanguler")) {
			return new Ractanguler();
		}
		else if(shaprType.equalsIgnoreCase("squre")) {
			return new Squre();
		}
		return null;
	}
}