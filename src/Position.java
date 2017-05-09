
public class Position {

	
	private int row; // row location in grid
	private int col; // column location in grid
	
	public Position(int r, int c) {
		row = r;
		col = c;
	}
	
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}

	
    public String toString()
    {
        return "(" + getRow() + ", " + getCol() + ")";
    }
	
}
