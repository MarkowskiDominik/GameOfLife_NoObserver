package gameOfLife;

public class Cell {
	private Integer column;
	private Integer row;
	private Integer numberOfLivingNeighbors;

	public Cell(Integer column, Integer row) {
		this.column = column;
		this.row = row;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.column.equals(((Cell) obj).getColumn()) && this.row.equals(((Cell) obj).getRow()));
	}

	@Override
	public String toString() {
		return column.toString() + " " + row.toString();
	}

	public Integer getColumn() {
		return column;
	}

	public void setColums(Integer column) {
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getNumberOfLivingNeighbors() {
		return numberOfLivingNeighbors;
	}

	public void setNumberOfLivingNeighbors(Integer numberOfLivingNeighbors) {
		this.numberOfLivingNeighbors = numberOfLivingNeighbors;
	}

}
