public class Main {
    public static void main(String[] args) {
        Spreadsheet sheet = new Spreadsheet(5, 5);
        CommandHandler handler = new CommandHandler(sheet);
        handler.start();
    }
}
