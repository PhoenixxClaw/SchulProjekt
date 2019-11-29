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
	@Column(nullable = false, length = 20)
	private String status;
	@Column(nullable = false, length = 2)
	private String Reihe;
	
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
   
}
