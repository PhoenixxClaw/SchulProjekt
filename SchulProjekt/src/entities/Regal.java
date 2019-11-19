package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Regal
 *
 */
@Entity

public class Regal implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RegalID;
	@Column(nullable = false, length = 60)
	private String RegalName;
	@Column(nullable = false)
	private int Fachanzahl;
	@Column(nullable = false)
	private int freiePlaetze;
	
	private static final long serialVersionUID = 1L;

	public Regal() {
		super();
	}   
	public int getRegalID() {
		return this.RegalID;
	}

	public void setRegalID(int RegalID) {
		this.RegalID = RegalID;
	}   
	public String getRegalName() {
		return this.RegalName;
	}

	public void setRegalName(String RegalName) {
		this.RegalName = RegalName;
	}   
	public int getFachanzahl() {
		return this.Fachanzahl;
	}

	public void setFachanzahl(int Fachanzahl) {
		this.Fachanzahl = Fachanzahl;
	}   
	public int getFreiePlaetze() {
		return this.freiePlaetze;
	}

	public void setFreiePlaetze(int freiePlaetze) {
		this.freiePlaetze = freiePlaetze;
	}
   
}
