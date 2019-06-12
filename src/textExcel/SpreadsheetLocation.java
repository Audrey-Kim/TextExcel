// @author Audrey Kim

package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private int row;
    private int col;

	@Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return ((int) row);
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	this.col = cellName.toUpperCase().charAt(0) - 65;
    	this.row = Integer.parseInt(cellName.substring(1)) - 1;
    }
    
    public SpreadsheetLocation(char c, int r) {
    	this.col = c - 65;
    	this.row = r;
    }

}
