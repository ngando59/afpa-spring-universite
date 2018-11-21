package fr.ngando.universite;

import java.text.DecimalFormat;

public interface DecimalFormatPrintable {
	default String print2df(Double d) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(true);
		return df.format(d);
	}
}
