import java.util.Scanner;
public class MateProg {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int numerals;
            System.out.println("Choose type of Numerals");
            System.out.println("Arabic(0)      Roman(1)");
            numerals = sc.nextInt();
            if (numerals == 0) {
                Arabic();
            } else if (numerals == 1) {
                Roman();
            } else {
                System.out.println("Error");
            }
        }
    }

    public static void Arabic() {
        float num1, num2;
        System.out.println("Enter first number");
        num1 = sc.nextFloat();
        System.out.println("Enter second number");
        num2 = sc.nextFloat();
        float result;
        char operation;
        System.out.println("Enter operation");
        operation = sc.next().charAt(0);
        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.println(result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(result);
                break;

            case '*':
                result = num1 * num2;
                System.out.println(result);
                break;

            case '/':
                result = num1 / num2;
                System.out.println(result);
                break;


        }

    }

    public static int Roman() {


        System.out.println("Enter first number");
        String arb = sc.next();
        System.out.println("Enter second number");
        String arb1 = sc.next();
        calculate(romanToArabic(arb), romanToArabic(arb1));
        return 0;
    }

    public static int romanToArabic(String romanNumber) {
        int Arabic = 0;
        int lastNumber = 0;

        String romanNumeral = romanNumber.toUpperCase();


        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToArabic = romanNumeral.charAt(x);

            switch (convertToArabic) {
                case 'M':
                    Arabic = processArabic(1000, lastNumber, Arabic);

                    lastNumber = 1000;
                    break;

                case 'D':
                    Arabic = processArabic(500, lastNumber, Arabic);

                    lastNumber = 500;
                    break;

                case 'C':
                    Arabic = processArabic(100, lastNumber, Arabic);

                    lastNumber = 100;
                    break;

                case 'L':
                    Arabic = processArabic(50, lastNumber, Arabic);

                    lastNumber = 50;
                    break;

                case 'X':
                    Arabic = processArabic(10, lastNumber, Arabic);

                    lastNumber = 10;
                    break;

                case 'V':
                    Arabic = processArabic(5, lastNumber, Arabic);

                    lastNumber = 5;
                    break;

                case 'I':
                    Arabic = processArabic(1, lastNumber, Arabic);

                    lastNumber = 1;
                    break;
            }

        }
        return Arabic;

    }


    public static int processArabic(int Arabic, int lastNumber, int lastArabic) {
        if (lastNumber > Arabic) {
            return lastArabic - Arabic;
        } else {
            return lastArabic + Arabic;
        }
    }

    private static String[] numerals = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private static int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};

   public static String ArabicToRoman(int result) {
       if (result>=3999 || result<=1 ) throw new IllegalArgumentException();
StringBuilder arabic = new StringBuilder();
int i=0;
while (result>0) {
    if (result - values[i] >= 0) {
        arabic.append(numerals[i]);
        result -= values[i];
    } else {
        i++;
    }

}
       System.out.println(arabic.toString());
return arabic.toString();
   }

    public static int calculate(int A, int B) {

        int arab1 = A;
        int arab2 = B;
        int result;
        char operation;
        System.out.println("Enter operation");
        operation = sc.next().charAt(0);
        switch (operation) {
            case '+':
                result = arab1 + arab2;
                ArabicToRoman(result);
                break;
            case '-':
                result = arab1 - arab2;
                ArabicToRoman(result);

                break;

            case '*':
                result = arab1 * arab2;
               ArabicToRoman(result);

                break;

            case '/':
                result = arab1 / arab2;
              ArabicToRoman(Math.round (result));
                break;

        }
        return 0;
    }
}

















