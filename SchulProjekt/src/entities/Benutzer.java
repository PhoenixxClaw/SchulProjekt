package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Benutzer
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllBenutzer", query = "SELECT b FROM Benutzer b") })
public class Benutzer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer benutzerID;
	
	@Column(nullable = false, length = 60)
	private String vorname;
	
	@Column(nullable = false, length = 60)
	private String nachname;
	
	@Column(nullable = false, length = 60)
	private String adresse;
	
	@Column(nullable = false, length = 60)
	private String benutzerName;
	
	@Column(nullable = false, length = 60)
	private String passwort;
	
	@Column(nullable = false, length = 60)
	private String geburtsdatum;
	
	@Column (nullable = false, columnDefinition = "TINYINT(0)")
	private Boolean isAdmin;
	
	@Column (nullable = false, columnDefinition = "TINYINT(0)")
	private Boolean status;
	
	private static final long serialVersionUID = 1L;

	public Benutzer() {
		super();
	}   
	public Integer getBenutzerID() {
		return this.benutzerID;
	}

	public void setBenutzerID(Integer benutzerID) {
		this.benutzerID = benutzerID;
	}   
	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}   
	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getBenutzerName() {
		return benutzerName;
	}
	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
   
}
