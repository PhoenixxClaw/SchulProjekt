package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RegalPlatz
 *
 */
@Entity

public class RegalPlatz implements Serializable {

	   
	@Id
	private int PlatzID;
	private String Platzname;
	private Boolean StatusBelegt;
	private static final long serialVersionUID = 1L;

	public RegalPlatz() {
		super();
	}   
	public int getPlatzID() {
		return this.PlatzID;
	}

	public void setPlatzID(int PlatzID) {
		this.PlatzID = PlatzID;
	}   
	public String getPlatzname() {
		return this.Platzname;
	}

	public void setPlatzname(String Platzname) {
		this.Platzname = Platzname;
	}   
	public Boolean getStatusBelegt() {
		return this.StatusBelegt;
	}

	public void setStatusBelegt(Boolean StatusBelegt) {
		this.StatusBelegt = StatusBelegt;
	}
   
}
