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
package fr.ecattez.maze;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.ecattez.maze.algorithm.builder.MazeBuilder;
import fr.ecattez.maze.algorithm.builder.RecursiveMazeBuilder;
import fr.ecattez.maze.algorithm.finder.PathFinder;
import fr.ecattez.maze.algorithm.finder.QueuePathFinder;
import fr.ecattez.maze.entity.Maze;
import fr.ecattez.maze.view.JMaze;

/**
 * Classe de démarrage.
 */
public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable()  {
			public void run() {
				MazeBuilder builder = new RecursiveMazeBuilder();
				Maze maze = builder.build(20, 20);
				
				JFrame f = new JFrame("Maze");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setContentPane(new JMaze(maze));
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				
				PathFinder finder = new QueuePathFinder(maze, maze.getEntrance(), maze.getExit());
				Thread thread = new Thread(finder);
				thread.start();
			}
		});		
	}

}
