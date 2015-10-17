/**
 * This file is part of Maze.
 *
 * Maze is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Maze is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.				 
 * 
 * You should have received a copy of the GNU General Public License
 * along with Maze.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Edouard CATTEZ <edouard.cattez@sfr.fr> (La 7 Production)
 */
package fr.ecattez.maze.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Direction;
import fr.ecattez.maze.entity.Maze;

/**
 * Vue graphique du labyrinthe qui utilise la bibliothèque Swing.
 */
public class GraphicalMazeDisplayer extends JPanel implements Displayer {
	
	private static final long serialVersionUID = -9141284611503607659L;
	
	@Override
	public String display(final Maze maze) {
		final JPanel grid = new JPanel();
		init(grid, maze);
		
		this.setLayout(new BorderLayout());
		this.add(grid, BorderLayout.CENTER);
		
		JFrame f = new JFrame("Maze");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.add(this);
		f.pack();
		f.setLocationRelativeTo(null);
		return "See graphical interface";
	}
	
	private void init(JPanel grid, Maze maze) {
		grid.removeAll();
		grid.setLayout(new GridLayout(maze.getHeight(), maze.getWidth()));
		Cell[] cells = maze.getCells();
		JCell[] jcells = new JCell[maze.size()];
		
		int i = 0;
		for (Cell c : cells) {
			jcells[i] = new JCell(c);
			grid.add(jcells[i]);
			i++;
		}
		grid.repaint();
	}
	
	private class JCell extends JLabel implements Observer {
		
		public static final int SIZE = 32;
		
		private static final long serialVersionUID = 7184321433013115575L;
		
		private Cell cell;
		
		public JCell(Cell cell) {
			int top = cell.hasWall(Direction.NORTH) ? 1 : 0;
			int left = cell.hasWall(Direction.WEST) ? 1 : 0 ;
			int bottom = cell.hasWall(Direction.SOUTH) ? 1 : 0;
			int right = cell.hasWall(Direction.EAST) ? 1 : 0;
			this.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
			this.setPreferredSize(new Dimension(SIZE + 4, SIZE + 4));
			this.setForeground(cell.getColor());
			this.cell = cell;
			this.cell.addObserver(this);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			Ellipse2D.Double circle = new Ellipse2D.Double(getWidth()/2, getHeight()/2, SIZE/4, SIZE/4);
			g2d.fill(circle);
		}

		@Override
		public void update(Observable o, Object arg) {
			this.repaint();
		}
		
	}

}
