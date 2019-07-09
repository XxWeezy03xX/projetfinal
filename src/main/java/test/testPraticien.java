package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.formation.model.Adresse;
import org.formation.model.EMotif;
import org.formation.model.Motif;
import org.formation.model.Patient;
import org.formation.model.Praticien;
import org.formation.model.Rdv;

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
		
		Adresse a = new Adresse(24, "De paris", "93880", "Paris");
		p.setAvis("Très bonne docteur");
		p.setNote(7);
		p.setAdresse(a);
		
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
		
		Patient p1 = new Patient();
		p1.setPrenom("test patient");
		p1.setNom("test patient non");
		Date d = new SimpleDateFormat("yyyy/MM/dd").parse("2007/01/01");
		p1.setNaissance();
		
//		System.out.println(p.getMotifs().get(0).getPrix());
		
		for (Motif x: p.getMotifs()) {
			System.out.println(x.getPrix());
			System.out.println(x.getMotif());
		}
		
		Rdv r = new Rdv();
		r.setPraticien(p);
		r.setMotif(m1);
		r.setLieu(a);
	}

}
