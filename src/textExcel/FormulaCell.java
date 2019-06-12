// @author Audrey Kim 

package textExcel;

public class FormulaCell extends RealCell{
	
	// fields
	private Spreadsheet sprSheet;

	public FormulaCell(String text, Spreadsheet sprSheet) {
		super(text);
		this.sprSheet = sprSheet;
	} 
	
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		String answer = Double.toString(getDoubleValue());
		String sub = answer + "          ";
		return sub.substring(0, 10);
	}
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		return super.fullCellText();
	}
	
	public double getDoubleValue() { // calculates the stuff 
		String[] form = fullCellText().split(" "); // splitting string into digits and operators
		if (form.length == 3) { // if it's just a single number/cell
			return getNumber(form[1]);
		}
		if ((form[1].equalsIgnoreCase("avg") || form[1].equalsIgnoreCase("sum")) && form.length == 4) { // if it's returning sum/average
			String[] sumAvg = form[2].split("-"); // makes array with start and end cells
			Location startLoc = new SpreadsheetLocation(sumAvg[0]); 
			Location endLoc = new SpreadsheetLocation(sumAvg[1]);
			double sum = 0; 
			int count = 0;
			for (int i = startLoc.getRow(); i <= endLoc.getRow(); i++) { //cycles through each row and col of range of cells
				for (char j = sumAvg[0].toUpperCase().charAt(0); j <= sumAvg[1].toUpperCase().charAt(0); j++) { 
					Location loc = new SpreadsheetLocation(j + Integer.toString(i + 1)); // makes location with cell made from i and j 
					sum += Double.parseDouble(sprSheet.getCell(loc).abbreviatedCellText()); // adds on numerical value from cell 
					if (form[1].equalsIgnoreCase("AVG")) { 
						count++; // to be divided by sum to get the average of the range 
					}
				}
			}
			if (count != 0) { // calculating average 
				sum /= count;
			}
			return sum;
		} else { //just cell reference
			double num1 = getNumber(form[1]);
			for (int i = 1; i < form.length - 2; i+=2) {
				num1 = calculating(num1, form[i + 1], form[i + 2]);
			}
			return num1;
		}
	}
	
	public double getNumber(String str) { //returns numerical value in string format 
		if (str.charAt(0) >= 65) {
			Location loc = new SpreadsheetLocation(str);
			return Double.parseDouble(sprSheet.getCell(loc).abbreviatedCellText());
		} else {
			return Double.parseDouble(str);
		}
	}
		
	public double calculating (double num, String operator, String num2) { //where the actual math happens 
				if (operator.equals("+")) {
					num += getNumber(num2);
				} else if (operator.equals("-")) {
					num -= getNumber(num2);
				} else if (operator.equals("*")) {
					num *= getNumber(num2);
				} else if (operator.equals("/")) {
					num /= getNumber(num2);
				} else if (operator.equals("%")) {
					num %= getNumber(num2);
				}

				return num;
	}
	
}
