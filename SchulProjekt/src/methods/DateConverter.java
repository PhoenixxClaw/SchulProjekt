package methods;

import alerts.Alerts;

public class DateConverter {

	public String convertDay(String startDatum, int tagZahl) {
		int ablaufTagInt = 0, ablaufMonatInt = 0, ablaufJahrInt = 0;
		String ablaufTag, ablaufMonat, ablaufJahr, endDatum;
		String erstellDatum = startDatum;
		String[] split = erstellDatum.split("-");
		String erstellTag = split[0];
		String erstellMonat = split[1];
		String erstellJahr = split[2];
		int erstellJahrInt = Integer.valueOf(erstellJahr);
		int erstellTagInt = Integer.valueOf(erstellTag);
		int erstellMonatInt = Integer.valueOf(erstellMonat);
		int numDays = 0;
		switch (erstellMonatInt) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			if (((erstellJahrInt % 4 == 0) && !(erstellJahrInt % 100 == 0)) || (erstellJahrInt % 400 == 0))
				numDays = 29;
			else
				numDays = 28;
			break;

		default:
			break;
		}

		if (erstellTagInt + tagZahl > numDays) {
			ablaufTagInt = (erstellTagInt + tagZahl) - numDays;
			ablaufMonatInt = erstellMonatInt + 1;
			if (ablaufMonatInt > 12) {
				ablaufMonatInt = 1;
				ablaufJahrInt = erstellJahrInt + 1;
			} else {
				ablaufMonatInt = erstellMonatInt;
			}
		} else {
			ablaufTagInt = erstellTagInt + tagZahl;
			ablaufMonatInt = erstellMonatInt;
			ablaufJahrInt = erstellJahrInt;
		}
		ablaufTag = Integer.toString(ablaufTagInt);
		ablaufMonat = Integer.toString(ablaufMonatInt);
		ablaufJahr = Integer.toString(ablaufJahrInt);

		if (ablaufTag.length() < 2) {
			ablaufTag = "0" + ablaufTag;
		}
		if (ablaufMonat.length() < 2) {
			ablaufMonat = "0" + ablaufMonat;
		}
		endDatum = ablaufTag + "-" + ablaufMonat + "-" + ablaufJahr;
		return endDatum;
	}

	public String convertMonth(String startDatum, int monatZahl) {
		int ablaufTagInt = 0, ablaufMonatInt = 0, ablaufJahrInt = 0;
		String ablaufTag, ablaufMonat, ablaufJahr, endDatum;
		String erstellDatum = startDatum;
		String[] split = erstellDatum.split("-");
		String erstellTag = split[0];
		String erstellMonat = split[1];
		String erstellJahr = split[2];
		int erstellJahrInt = Integer.valueOf(erstellJahr);
		int erstellTagInt = Integer.valueOf(erstellTag);
		int erstellMonatInt = Integer.valueOf(erstellMonat);

		ablaufMonatInt = erstellMonatInt + monatZahl;
		if (ablaufMonatInt > 12) {
			ablaufMonatInt = 1;
			ablaufJahrInt = erstellJahrInt + 1;
		} else {
			ablaufJahrInt = erstellJahrInt;
		}

		int numDays = 0;
		switch (ablaufMonatInt) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			if (((erstellJahrInt % 4 == 0) && !(erstellJahrInt % 100 == 0)) || (erstellJahrInt % 400 == 0))
				numDays = 29;
			else
				numDays = 28;
			break;

		default:
			break;
		}

		if (erstellTagInt > numDays) {
			ablaufTagInt = erstellTagInt - numDays;
		} else {
			ablaufTagInt = erstellTagInt;
		}
		ablaufTag = Integer.toString(ablaufTagInt);
		ablaufMonat = Integer.toString(ablaufMonatInt);
		ablaufJahr = Integer.toString(ablaufJahrInt);

		if (ablaufTag.length() < 2) {
			ablaufTag = "0" + ablaufTag;
		}
		if (ablaufMonat.length() < 2) {
			ablaufMonat = "0" + ablaufMonat;
		}
		endDatum = ablaufTag + "-" + ablaufMonat + "-" + ablaufJahr;
		return endDatum;
	}
}
