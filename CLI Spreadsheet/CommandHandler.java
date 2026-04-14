import java.util.Scanner;

public class CommandHandler {
    private Spreadsheet sheet;
    private Scanner scanner;

    public CommandHandler(Spreadsheet sheet) {
        this.sheet = sheet;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("CLI Spreadsheet Started!");
        System.out.println("Commands: SET, GET, PRINT, EXIT");

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine();

            String[] parts = input.split(" ");

            switch (parts[0].toUpperCase()) {

                case "SET":
                    handleSet(parts);
                    break;

                case "GET":
                    handleGet(parts);
                    break;

                case "PRINT":
                    sheet.display();
                    break;

                case "EXIT":
                    return;

                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private void handleSet(String[] parts) {
        try {
            String cellRef = parts[1];
            String value = parts[2];

            int col = cellRef.charAt(0) - 'A';
            int row = Integer.parseInt(cellRef.substring(1)) - 1;

            if (value.startsWith("=")) {
                double result = FormulaParser.evaluate(value.substring(1), sheet);
                sheet.setCell(row, col, String.valueOf(result));
            } else {
                sheet.setCell(row, col, value);
            }

        } catch (Exception e) {
            System.out.println("Invalid SET command!");
        }
    }

    private void handleGet(String[] parts) {
        try {
            String cellRef = parts[1];

            int col = cellRef.charAt(0) - 'A';
            int row = Integer.parseInt(cellRef.substring(1)) - 1;

            System.out.println(sheet.getCell(row, col));

        } catch (Exception e) {
            System.out.println("Invalid GET command!");
        }
    }
}
