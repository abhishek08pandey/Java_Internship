package factoryDesignPattern;

public class MainFactory {

	public static void main(String[] args) {
		ShapeType shapeType = new ShapeType();
		
		Shape shape1 = shapeType.setShape("circle");
		shape1.draw();
		
		Shape shape2 = shapeType.setShape("squre");
		shape2.draw();
		
		Shape shape3 = shapeType.setShape("ractanguler");
		shape3.draw();
	}
}