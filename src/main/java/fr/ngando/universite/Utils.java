package fr.ngando.universite;

import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.universite.note.domain.Note;

public class Utils {

	private final static Integer NOTATION = 20;
	@SuppressWarnings("unused")
	private final static Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	public static Integer coefTotal(List<Note> notes) {
		Integer total = 0;
		for (Note n : notes) {
			total += (NOTATION * n.getMatiere().getCoef());
		}
		return total;
	}

	public static Double moyenne(List<Note> notes) {
		Double noteTotal = noteTotal(notes);
		Integer coefTotal = coefTotal(notes);
		if (coefTotal.equals(0)) {
			return 0.0;
		}
		return (noteTotal * NOTATION) / coefTotal;
	}

	public static Integer noteMax(Note note) {
		return (NOTATION * note.getMatiere().getCoef());
	}

	public static Double noteTotal(List<Note> notes) {
		Double total = 0.0;
		for (Note n : notes) {
			total += (n.getNote() * n.getMatiere().getCoef());
		}
		return total;
	}

	public static String print2df(Double d) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(true);
		return df.format(d);
	}
}
