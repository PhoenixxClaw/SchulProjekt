package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Regal
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllRegal", query = "SELECT r FROM Regal r")}) 

public class Regal implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RegalID;
	@Column(nullable = false, length = 60)
	private String RegalName;
	@Column(nullable = false, length = 2)
	private String Reihe;
	@Column(nullable = false)
	private int Fachanzahl;
	
	@OneToMany(mappedBy = "regal", orphanRemoval = true)
	private List<Buch> buecher;
	
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
	
	public String getReihe() {
		return Reihe;
	}
	public void setReihe(String reihe) {
		Reihe = reihe;
	}
	public List<Buch> getBuecher() {
		return buecher;
	}
	public void setBuecher(List<Buch> buecher) {
		this.buecher = buecher;
	}
	
	public int getFachanzahl() {
		return Fachanzahl;
	}
	public void setFachanzahl(int fachanzahl) {
		Fachanzahl = fachanzahl;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Regal: "+this.RegalName+" | Reihe: "+this.Reihe;
		}
   
}
