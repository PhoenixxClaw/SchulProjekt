package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Buch
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllBuecher", query = "SELECT b FROM Buch b")}) 

public class Buch implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BuchID;
	@Column(nullable = false, length = 100)
	private String Titel;
	@Column(nullable = false, length = 60)
	private String Author;
	@Column(nullable = false, length = 60)
	private String ISDN;
	@Column(nullable = true, length = 60)
	private String VerleihDatum;
	@Column(nullable = true, length = 60)
	private String RueckgabeDatum;
	
	@ManyToOne
	private Ausweis ausweis;
	
	@ManyToOne
	private Regal regal;
	
	private static final long serialVersionUID = 1L;

	public Buch() {
		super();
	}   
	public int getBuchID() {
		return this.BuchID;
	}

	public void setBuchID(int BuchID) {
		this.BuchID = BuchID;
	}   
	public String getTitel() {
		return this.Titel;
	}

	public void setTitel(String Titel) {
		this.Titel = Titel;
	}   
	public String getAuthor() {
		return this.Author;
	}

	public void setAuthor(String Author) {
		this.Author = Author;
	}   
	public String getISDN() {
		return this.ISDN;
	}

	public void setISDN(String ISDN) {
		this.ISDN = ISDN;
	}
	public Ausweis getAusweis() {
		return ausweis;
	}
	public void setAusweis(Ausweis ausweis) {
		this.ausweis = ausweis;
	}
	public Regal getRegal() {
		return regal;
	}
	public void setRegal(Regal regal) {
		this.regal = regal;
	}
	
	public String getVerleihDatum() {
		return VerleihDatum;
	}
	public void setVerleihDatum(String verleihDatum) {
		VerleihDatum = verleihDatum;
	}
	public String getRueckgabeDatum() {
		return RueckgabeDatum;
	}
	public void setRueckgabeDatum(String rueckgabeDatum) {
		RueckgabeDatum = rueckgabeDatum;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Titel: "+this.Titel+" | Author: "+this.Author;
		}
   
}
