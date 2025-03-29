public class testeRubens {
   

	public static int count(String input) {
        input = input.trim();
        if (input.isEmpty()) return 0;
        return input.split("\s+").length;
    }

    public static void main(String[] args) {
        String input;
        while (!(input = MyIO.readLine()).equals("FIM")) {
            MyIO.println(count(input));
        }
    }
}
