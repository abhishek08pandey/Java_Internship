package jsptags;

public class ScriptletTag {

	static int i = 10;
	static int ii = 122;
	
	String name= "abhishek";
	
	public static void main(String[] args) {
		ScriptletTag obj = new ScriptletTag();
		
		System.out.println(i);
		System.out.println(ScriptletTag.ii);
		System.out.println(obj.name);
		obj.text();
	}
	
	public void text() {
		System.out.println(i);
		System.out.println(ScriptletTag.ii);
		System.out.println(this.ii);
	}

}
