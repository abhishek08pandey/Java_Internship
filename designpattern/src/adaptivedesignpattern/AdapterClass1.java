package adaptivedesignpattern;

public class AdapterClass1 implements Interface2{

	Interface1 interface1;
	
	public AdapterClass1(Interface1 interface1) {
		super();
		this.interface1 = interface1;
	}

	@Override
	public void test22() {
		interface1.test11();
		
	}

	
}
