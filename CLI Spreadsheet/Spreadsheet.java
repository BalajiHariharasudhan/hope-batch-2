public class Spreadsheet {
    private Cell[][] grid;
    private int rows;
    private int cols;

    public Spreadsheet(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void setCell(int row, int col, String value) {
        grid[row][col].setValue(value);
    }

    public String getCell(int row, int col) {
        return grid[row][col].getValue();
    }

    public Cell getCellObject(int row, int col) {
        return grid[row][col];
    }

    public void display() {
        System.out.print("    ");
        for (int i = 0; i < cols; i++) {
            System.out.print((char) ('A' + i) + "     ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < cols; j++) {
                String val = grid[i][j].getValue();
                System.out.print((val.isEmpty() ? "-" : val) + " | ");
            }
            System.out.println();
        }
    }
}
