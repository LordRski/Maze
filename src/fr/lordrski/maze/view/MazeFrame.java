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
package fr.lordrski.maze.view;

import javax.swing.JFrame;

import fr.lordrski.maze.algorithm.builder.MazeBuilder;
import fr.lordrski.maze.algorithm.builder.RecursiveMazeBuilder;
import fr.lordrski.maze.entity.Maze;

/**
 * Fenêtre qui contient la version graphique du labyrinthe.
 */
public class MazeFrame extends JFrame {
	
	private static final long serialVersionUID = -6592995018159462764L;

	public MazeFrame() {
		super("Maze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MazeBuilder builder = new RecursiveMazeBuilder();
		Maze maze = builder.build(20, 20);
		MazePanel panel = new MazePanel(maze);
		JFrame f = new MazeFrame();
		f.add(panel);
		f.pack();
		f.setLocationRelativeTo(null);
	}

}
