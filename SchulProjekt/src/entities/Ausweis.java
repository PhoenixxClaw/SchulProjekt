package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ausweis
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllAusweise", query = "SELECT a FROM Ausweis a") })
public class Ausweis implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AusweisID;
	
	@Column(nullable = false, length = 60)
	private String ErstellDatum;
	
	@Column(nullable = false, length = 60)
	private String AblaufDatum;
	
	@Column (nullable = false, length = 60)
	private String Status;
	
	@Column (nullable = false)
	private int AusweisNummer;
	
	@ManyToOne
	private Benutzer benutzer;
	
	@OneToMany(mappedBy = "ausweis", orphanRemoval = true)
	private List<Buch> buecher;
	
	private static final long serialVersionUID = 1L;

	public Ausweis() {
		super();
	}   
	public Integer getAusweisID() {
		return this.AusweisID;
	}

	public void setAusweisID(Integer AusweisID) {
		this.AusweisID = AusweisID;
	}   
	public String getErstellDatum() {
		return this.ErstellDatum;
	}

	public void setErstellDatum(String ErstellDatum) {
		this.ErstellDatum = ErstellDatum;
	}   
	public String getAblaufDatum() {
		return this.AblaufDatum;
	}

	public void setAblaufDatum(String AblaufDatum) {
		this.AblaufDatum = AblaufDatum;
	}   
	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}
	public int getAusweisNummer() {
		return AusweisNummer;
	}
	public void setAusweisNummer(int ausweisNummer) {
		AusweisNummer = ausweisNummer;
	}
	public Benutzer getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	public List<Buch> getBuecher() {
		return buecher;
	}
	public void setBuecher(List<Buch> buecher) {
		this.buecher = buecher;
	}
   
}
