package gameOfLife;

import java.util.LinkedList;

public class GameOfLife {

	private LinkedList<Cell> livingCells;
	private LinkedList<Cell> neighbors;

	public GameOfLife(LinkedList<Cell> livingCells) {
		this.livingCells = new LinkedList<Cell>(livingCells);
		neighbors = new LinkedList<Cell>();
	}

	public void symulationOfCellsLife() {
		generateNeighborhoods();
		calculateNumberOfLivingNeighbors();
		deathOfLivingCells();
		revivalOfDeadCells();
		neighbors.clear();
	}

	private void generateNeighborhoods() {
		for (Cell cell : livingCells) {
			addNeighborsOfCell(cell);
		}
	}

	private void addNeighborsOfCell(Cell cell) {
		Integer row = cell.getRow();
		Integer column = cell.getColumn();

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				Cell neighbor = new Cell(column + i, row + j);
				if (!livingCells.contains(neighbor) && !neighbors.contains(neighbor)) {
					neighbors.add(neighbor);
				}
			}
		}
	}

	private void calculateNumberOfLivingNeighbors() {
		for (Cell cell : livingCells) {
			calculateNumberOfLivingNeighborsForCell(cell);
		}
		for (Cell cell : neighbors) {
			calculateNumberOfLivingNeighborsForCell(cell);
		}
	}

	private void calculateNumberOfLivingNeighborsForCell(Cell cell) {
		Integer numberOfLivingNeighbors = 0;
		Integer cellColumn = cell.getColumn();
		Integer cellRow = cell.getRow();

		for (Cell neighbor : livingCells) {
			Integer neighborColumn = neighbor.getColumn();
			Integer neighborRow = neighbor.getRow();
			if (cellRow - 2 < neighborRow && neighborRow < cellRow + 2 && cellColumn - 2 < neighborColumn
					&& neighborColumn < cellColumn + 2 && !(neighborRow == cellRow && neighborColumn == cellColumn)) {
				numberOfLivingNeighbors++;
			}
		}
		cell.setNumberOfLivingNeighbors(numberOfLivingNeighbors);
	}

	private void deathOfLivingCells() {
		LinkedList<Cell> toRemove = new LinkedList<Cell>();
		Integer numberOfLivingNeighbors;
		
		for (Cell cell : livingCells) {
			numberOfLivingNeighbors = cell.getNumberOfLivingNeighbors();
			if (!numberOfLivingNeighbors.equals(Integer.valueOf(2))
					&& !numberOfLivingNeighbors.equals(Integer.valueOf(3))) {
				toRemove.add(cell);
			}
		}
		livingCells.removeAll(toRemove);
	}

	private void revivalOfDeadCells() {
		for (Cell cell : neighbors) {
			if (cell.getNumberOfLivingNeighbors().equals(Integer.valueOf(3))) {
				livingCells.add(cell);
			}
		}
	}

	public LinkedList<Cell> getLivingCells() {
		return livingCells;
	}

	public void setLivingCells(LinkedList<Cell> livingCells) {
		this.livingCells = livingCells;
	}
}
