public class FormulaParser {

    public static double evaluate(String formula, Spreadsheet sheet) {
        try {
            formula = formula.replace(" ", "");

            String[] parts;

            if (formula.contains("+")) {
                parts = formula.split("\\+");
                return getValue(parts[0], sheet) + getValue(parts[1], sheet);
            } else if (formula.contains("-")) {
                parts = formula.split("-");
                return getValue(parts[0], sheet) - getValue(parts[1], sheet);
            } else if (formula.contains("*")) {
                parts = formula.split("\\*");
                return getValue(parts[0], sheet) * getValue(parts[1], sheet);
            } else if (formula.contains("/")) {
                parts = formula.split("/");
                return getValue(parts[0], sheet) / getValue(parts[1], sheet);
            }

        } catch (Exception e) {
            System.out.println("Invalid Formula!");
        }
        return 0;
    }

    private static double getValue(String ref, Spreadsheet sheet) {
        int col = ref.charAt(0) - 'A';
        int row = Integer.parseInt(ref.substring(1)) - 1;

        String val = sheet.getCell(row, col);

        return Double.parseDouble(val);
    }
}
