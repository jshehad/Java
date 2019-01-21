
public class Map extends Tile {
	private Tile[][] map;// holds the tiles coordinate
	private int freeRow;// the row of map
	private int freeColumn;// the column of map

	public Map(int width, int height) {
		super();
		freeColumn = width;
		freeRow = height;
		map = new Tile[freeRow][freeColumn];
	}

	public boolean addTile(Tile tile) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++)
				if (map[r][c] == null) {
					map[r][c] = tile;
					tile.setColumn(c);
					tile.setRow(r);
					return true;
				}
		}
		return false;
	}

	public Tile getTile(int row, int col) {
		return map[row][col];
	}

	public Tile[] getNeighbors(Tile tile, Direction direction) {
		int count = 0;

		Tile[] Neighbors = new Tile[freeRow * freeColumn];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {

				if (direction == Direction.EAST) {
					if ((tile.getRow() == r || tile.getRow() + 1 == r || tile.getRow() - 1 == r)
							&& (tile.getColumn() + 1 == c)) {
						Neighbors[count] = map[r][c];
						count++;

					}
				} else if (direction == Direction.WEST) {
					if ((tile.getRow() == r || tile.getRow() + 1 == r || tile.getRow() - 1 == r)
							&& (tile.getColumn() - 1 == c)) {
						Neighbors[count] = map[r][c];
						count++;

					}
				} else if (direction == Direction.NORTH) {
					if ((tile.getColumn() == c || tile.getColumn() + 1 == c || tile.getColumn() - 1 == c)
							&& (tile.getRow() - 1 == r)) {
						Neighbors[count] = map[r][c];
						count++;
					}
				} else if (direction == Direction.SOUTH) {
					if ((tile.getColumn() == c || tile.getColumn() + 1 == c || tile.getColumn() - 1 == c)
							&& (tile.getRow() + 1 == r)) {
						Neighbors[count] = map[r][c];
						count++;
					}
				}
			}

		}

		return trimToSize(Neighbors);

	}

	// trims the incoming array of tiles
	// mainly used in getNeighbors
	private Tile[] trimToSize(Tile[] neighbors) {
		Tile[] trimmed;
		int count = 0;
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] != null) {
				count++;
				continue;
			}
			break;
		}
		trimmed = new Tile[count];
		count = 0;
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] != null) {
				trimmed[count] = neighbors[i];
				count++;
			}
		}
		return trimmed;
	}

	public void propagate(Force force, int row, int column, Direction direction) {
		Tile tile = getTile(row, column);

		Force weaken = tile.weaken(force);
		Force strengthen = tile.strengthen(force);
		tile.setMeasurement((strengthen.getLoad() + weaken.getLoad()) / 2);
		Tile[] neighbors = getNeighbors(tile, direction);
		force.setLoad((strengthen.getLoad() + weaken.getLoad()) / 2);

		// recursion below
		for (int i = 0; i < neighbors.length; i++)
			propagate(force, neighbors[i].getRow(), neighbors[i].getColumn(), direction);
	}

	@Override
	public Force strengthen(Force f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canPropagate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		String str1 = "";
		String str12;
		for (Tile[] i : map) {
			for (Tile x : i) {
				str12 = String.format("%-32s", x.subString());
				str1 += str12;
			}
			str1 += "\n";
		}
		return str1;

	}

	@Override
	public String subString() {
		// TODO Auto-generated method stub
		return null;
	}
}
