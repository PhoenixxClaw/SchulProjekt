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
   
}
