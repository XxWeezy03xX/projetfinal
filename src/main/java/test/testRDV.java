package test;

import org.formation.model.Rdv;

public class testRDV {

	public static void main(String[] args) {
		test1();

	}
	
	public static void test1() {
		Rdv rdv = new RDV();
		rdv.getId();
		rdv.getPatient("chirurgien");
		rdv.getPraticien("chirurgien");
		System.out.println(rdv);
		
		

		

		
	}

}
