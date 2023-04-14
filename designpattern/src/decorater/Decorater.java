package decorater;

public abstract class Decorater implements Shape {

	protected Shape shape;
	
	public Decorater(Shape shape){
		this.shape=shape;
	}
	@Override
	public void draw() {
		shape.draw();
	}

}
