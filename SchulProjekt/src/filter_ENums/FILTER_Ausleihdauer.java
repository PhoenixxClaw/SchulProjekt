package filter_ENums;

public enum FILTER_Ausleihdauer {

	ONE {
		public String toString() {
			return "1 Tag";
		}
	},

	THREE {
		public String toString() {
			return "3 Tage";
		}
	},

	SEVEN {
		public String toString() {
			return "1 Woche";
		}
	},

	FOURTEEN {
		public String toString() {
			return "2 Wochen";
		}
	}

}
