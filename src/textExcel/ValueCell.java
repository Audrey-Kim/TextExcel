package textExcel;

public class ValueCell extends RealCell{
	
	public ValueCell(String text) {
		super(text);
	}
	
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		String substring = super.fullCellText().substring(Math.max(super.fullCellText().length() - 2, 0));
		if (!substring.equals(".0") && !super.fullCellText().contains(".")) { //if the last 2 chars of substring 
			String ret = super.fullCellText() + ".0" + "       ";
			return ret.substring(0, 10);
		}
		String sub = super.fullCellText();
		while (sub.charAt(sub.length() - 1) == '0' && sub.contains(".")) {
			sub = sub.substring(0, sub.length()-1);
		}
		if (sub.charAt(sub.length()-1) == '.') {
			sub += "0";
		}
		
		sub += "          ";
		return sub.substring(0, 10);
	}
	
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		return super.fullCellText();
	}
	
	public double getDoubleValue() { // returns calculated value of the cell as a double 
		return super.getDoubleValue();
	}
	
}
