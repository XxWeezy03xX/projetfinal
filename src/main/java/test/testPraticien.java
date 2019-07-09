package test;

import java.util.ArrayList;

import org.formation.model.EMotif;
import org.formation.model.Motif;
import org.formation.model.Praticien;

public class testPraticien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createPraticien();
	}
	
	public static void createPraticien() {
		Praticien p = new Praticien();
		p.setNom("Nom test");
		p.setPrenom("Prenom test");
		p.setEmail("raphael.fosse91@gmail.com");
		
		ArrayList<String> ar = new ArrayList<String>();
		String s1 = "Dentiste";
		String s2 = "Chirurgien";
		ar.add(s2);
		ar.add(s1);
		p.setSpecialites(ar);
		
		p.setPresentation("Bonjour, je suis Raphael Fosse, chirurgien dentiste !");
		p.setMoyen_paiement("QUE DU CASH");
		p.setAvis("Très bonne docteur");
		p.setNote(7);
//		System.out.println(p.getSpecialites());
		
		ArrayList<Motif> arm = new ArrayList<Motif>();
		
		Motif m = new Motif();
		Motif m1 = new Motif();
		m.setMotif(EMotif.PREMIER_CONSULTATION);
		m.setPrix(365);
		m1.setMotif(EMotif.SOIN_DENTAIRE);
		m1.setPrix(155);
		arm.add(m1);
		arm.add(m);
		p.setMotifs(arm);
		
//		System.out.println(p.getMotifs().get(0).getPrix());
		
		for (Motif x: p.getMotifs()) {
			System.out.println(x.getPrix());
			System.out.println(x.getMotif());
		}
	}

}
