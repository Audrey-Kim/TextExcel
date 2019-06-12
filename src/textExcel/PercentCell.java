package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String text) {
		super(text);
	}
	
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		int dot = super.fullCellText().indexOf('.');
		String sub = super.fullCellText().substring(0, dot) + '%' + "        ";
		return sub.substring(0, 10);
	}
	
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		String sub = super.fullCellText().substring(0, super.fullCellText().length() - 1);
		double tex = Double.parseDouble(sub) / 100;
		return Double.toString(tex);
	}
	
	public double getDoubleValue(String text) { // returns calculated value of the cell as a double 
		double d = Double.parseDouble(text);
		return d;
	}
	
}
