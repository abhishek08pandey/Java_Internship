package adaptivedesignpattern;

public class AdapterClass2 implements Interface1{

	Interface2 interface2;
	
	public AdapterClass2(Interface2 interface2) {
		this.interface2=interface2;
	}
	
	@Override
	public void test11() {
		interface2.test22();
		
	}

}
