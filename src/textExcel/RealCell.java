package textExcel;

public class RealCell implements Cell {

	private String text; 
	
	public RealCell(String text) {
		this.text = text;
	}
	
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		String temp = text + "          ";
		return temp.substring(0, 10);
	}
	
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		return text;
	}
	
	public double getDoubleValue() { // returns calculated value of the cell as a double - GETS OVERRIDEN
		return Double.parseDouble(text);
	}
	
}
