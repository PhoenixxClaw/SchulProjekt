package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
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
	
	@Column (nullable = false, columnDefinition = "TINYINT(0)")
	private Boolean Status;
	
	@Column (nullable = false)
	private int AusweisNummer;
	
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
	public Boolean getStatus() {
		return this.Status;
	}

	public void setStatus(Boolean Status) {
		this.Status = Status;
	}
   
}
