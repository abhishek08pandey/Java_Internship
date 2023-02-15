package factoryDesignPattern;

public class MainFactory {

	public static void main(String[] args) {
		ShapeType shapeType = new ShapeType();
		
		Shape shape1 = shapeType.getShape("circle");
		shape1.draw();
		
		Shape shape2 = shapeType.getShape("squre");
		shape2.draw();
		
		Shape shape3 = shapeType.getShape("ractanguler");
		shape3.draw();
	}
}