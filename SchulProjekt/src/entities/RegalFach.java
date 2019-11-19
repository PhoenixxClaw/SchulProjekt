package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RegalFach
 *
 */
@Entity

public class RegalFach implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FachID;
	@Column(nullable = false)
	private int Fachzahl;
	@Column(nullable = false)
	private int FreiePlaetze;
	
	private static final long serialVersionUID = 1L;

	public RegalFach() {
		super();
	}   
	public int getFachID() {
		return this.FachID;
	}

	public void setFachID(int FachID) {
		this.FachID = FachID;
	}   
	public int getFachzahl() {
		return this.Fachzahl;
	}

	public void setFachzahl(int Fachzahl) {
		this.Fachzahl = Fachzahl;
	}   
	public int getFreiePlaetze() {
		return this.FreiePlaetze;
	}

	public void setFreiePlaetze(int FreiePlaetze) {
		this.FreiePlaetze = FreiePlaetze;
	}
   
}
