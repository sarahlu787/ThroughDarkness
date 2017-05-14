import java.awt.Graphics;

import javax.swing.JPanel;

import info.gridworld.grid.Location;

public class GridPanel extends JPanel {
  
	private static final int GRID_SIZE = 20;
	private Grid<Actor> grid;

	public GridPanel(Grid<Actor> grid) {
		this.grid = grid;
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int y = 0; y < grid.getNumRows(); y++) {
			for (int x = 0; x < grid.getNumCols(); x++) {
				Actor actor = grid.get(new Location(x, y));
				if (actor != null)
				    actor.paint(g, x * GRID_SIZE, y * GRID_SIZE);
			}
		}
	}
}