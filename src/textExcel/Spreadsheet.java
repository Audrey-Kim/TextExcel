/* @author Audrey Kim 
 * 
 */
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;
	private int rows = 20;
	private int cols = 12;

	public Spreadsheet() {
		sheet = new Cell[rows][cols];
		for(int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				sheet[row][col] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command){
		String[] commandParts = command.split(" ", 3);
		
		if (command.length() <= 3) { //cell inspection: returns value at cell
			
			Location loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
			
		} else if (command.contains(" = ")) { //assignment of values 
			
			Location loc = new SpreadsheetLocation(commandParts[0]);
			
			if (!commandParts[2].matches("\".*\"")) { //checks if command contain digits
				
				if (commandParts[2].contains("(")) { //assignment of FormulaCell
					
					sheet[loc.getRow()][loc.getCol()] = new FormulaCell(commandParts[2], this);
				
				} else if (commandParts[2].contains("%")) { //assignment of PercentCell
					
					sheet[loc.getRow()][loc.getCol()] = new PercentCell(commandParts[2]);
					
				} else { //assignment of ValueCell
				
					sheet[loc.getRow()][loc.getCol()] = new ValueCell(commandParts[2]);
					
				}
				
			} else { //assignment of TextCell
			
				sheet[loc.getRow()][loc.getCol()]= new TextCell(commandParts[2]);			
			}
			
		} else if (command.toLowerCase().contains("clear ")) { //clears
	
				Location loc = new SpreadsheetLocation(commandParts[1]);
				sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
				
		} else if (command.equalsIgnoreCase("clear")){ //clears entire sheet
				
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						sheet[i][j] = new EmptyCell();
					}
				}
		} 
		return getGridText();
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Cell getCell(Location loc)
	{ 
		// TODO Auto-generated method stub
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String r = "   |";
		for (char i = 'A'; i <= 'L'; i++) { //creates letter header 
			r += i + "         |";
		}
		r += "\n";
		for (int i = 0; i < 20; i++) {
			if (i < 9) {
				r += i+1 + "  |";
			} else {
				r += i+1 + " |";
			}
			for (char j = 0; j < 12; j++) {
				r += sheet[i][j].abbreviatedCellText() + "|";
			}
			r += "\n";
		}
		return r;
	}
	
	public String chaSiuBao() {
		return "cha siu baoooooooooooooooooooooo pls";
	}

}
