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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.ecattez.maze.entity.Cardinal;
import fr.ecattez.maze.entity.Cartesian;
import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Maze;

/**
 * Vue graphique du labyrinthe qui utilise la bibliothèque Swing.
 */
public class JMaze extends JPanel implements Observer {
	
private static final long serialVersionUID = -258981629780565455L;
	
	public static final Color DEFAULT_AVAILABLE_COLOR = Color.WHITE;
	public static final Color DEFAULT_USED_COLOR = Color.RED;
	public static final Color DEFAULT_ENTRANCE_COLOR = Color.ORANGE;
	public static final Color DEFAULT_EXIT_COLOR = Color.GREEN;
	public static final int CELL_SIZE = 32;
	
	private Maze maze;
	
	public JMaze(Maze maze) {
		super(new GridLayout(maze.getHeight(), maze.getWidth()));
		this.maze = maze;
		this.maze.addObserver(this);
		for (int y=0; y < maze.getHeight(); y++) {
			for (int x=0; x < maze.getWidth(); x++) {
				this.add(new JCell(new Cartesian(x, y)));
			}
		}
	}
	@Override
	public void update(Observable obs, Object o) {
		this.repaint();
	}	
	
	/**
	 * Classe interne pour la représentation d'une cellule
	 */
	class JCell extends JButton {
		
		private static final long serialVersionUID = 6952888330383232312L;
		
		private Coordinates coord;
		
		public JCell(final Coordinates coord) {
			this.coord = coord;
			int top = maze.isWalled(coord, Cardinal.NORTH) ? 1 : 0;
			int left = maze.isWalled(coord, Cardinal.WEST) ? 1 : 0 ;
			int bottom = maze.isWalled(coord, Cardinal.SOUTH) ? 1 : 0;
			int right = maze.isWalled(coord, Cardinal.EAST) ? 1 : 0;
			this.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
			this.setPreferredSize(new Dimension(CELL_SIZE + 4, CELL_SIZE + 4));
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (coord.equals(maze.getEntrance())) {
				this.setBackground(DEFAULT_ENTRANCE_COLOR);
			}
			else if (coord.equals(maze.getExit())) {
				this.setBackground(DEFAULT_EXIT_COLOR);
			}
			else if (maze.isAvailable(coord)) {
				this.setBackground(DEFAULT_AVAILABLE_COLOR);
			}
			else {
				this.setBackground(DEFAULT_USED_COLOR);
			}			
		}
		
	}

}
