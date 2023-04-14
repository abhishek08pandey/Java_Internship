package decorater;

public class MainClass {

	public static void main(String[] args) {
		
		Circle circle = new Circle();
		
		Shape redCircle = new RedShapeDecorater(new Circle());
		
		Shape redRactanguler = new RedShapeDecorater(new Ractanguler());
		
		System.out.println("only circle");
		circle.draw();
		
		System.out.println("red circle");
		redCircle.draw();
		
		System.out.println("red ractanguler");
		redRactanguler.draw();
	}
}
