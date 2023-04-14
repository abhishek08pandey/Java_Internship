package decorater;

public class RedShapeDecorater extends Decorater{

	public RedShapeDecorater(Shape shape) {
		super(shape);
	}
	
	public void draw() {
		shape.draw();
		setRedBorder();
	}
	public void setRedBorder() {
		System.out.println("With red border");
	}
}
