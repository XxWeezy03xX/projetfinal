package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.formation.model.Adresse;
import org.formation.model.EMotif;
import org.formation.model.Motif;
import org.formation.model.Patient;
import org.formation.model.Planning;
import org.formation.model.Praticien;
import org.formation.model.Rdv;

public class testPraticien {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		createPraticien();
	}
	
	public static void createPraticien() throws ParseException {
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
		p1.setNaissance(d);
		
//		System.out.println(p.getMotifs().get(0).getPrix());
		
//		for (Motif x: p.getMotifs()) {
//			System.out.println(x.getPrix());
//			System.out.println(x.getMotif());
//		}
		
		Planning planning = new Planning();
		planning.setPraticien(p);
		ArrayList<Date> disp = new ArrayList<Date>();
		
		Date d1 = new SimpleDateFormat("yyyy/MM/dd-HH:mm").parse("2007/01/01-09:30");
		Date d2 = new SimpleDateFormat("yyyy/MM/dd-HH:mm").parse("2007/01/01-10:00");
		Date d3 = new SimpleDateFormat("yyyy/MM/dd-HH:mm").parse("2007/01/01-10:30");
		disp.add(d1);
		disp.add(d2);
		disp.add(d3);
		planning.setDisponibilite(disp);
		
//		for (Date x: disp) {
//			System.out.println(x);
//		}
		
		
		
		Rdv r = new Rdv();
		r.setPraticien(p);
		r.setMotif(m1);
		r.setLieu(a);
		r.setPatients(p1);
		r.setDate(disp.remove(1));
		
		System.out.println(r.getPatients().getNom());
		System.out.println(r.getDate());
		System.out.println(r.getMotif().getMotif());
		System.out.println(r.getPraticien().getNom());
		System.out.println(r.getLieu().getCp());
	}

}
