package facadedesignpattern;

public class ClothesClass {

	private Winter winter;
	private Monsoon monsoon;
	private Summer summer;
	
	public ClothesClass() {
		winter = new Winter();
		monsoon = new Monsoon();
		summer = new Summer();
	}

	public void Summer() {
		//System.out.println("reach summer in cloths class");
		summer.seasion();
		MainClass.selectSeasion();
	}
	public void Winter() {
		//System.out.println("reach winter in cloths class");
		winter.seasion();
		MainClass.selectSeasion();
	}
	public void Monsoon() {
		//System.out.println("reach monsoon in cloths class");
		monsoon.seasion();
		MainClass.selectSeasion();
	}
	
}