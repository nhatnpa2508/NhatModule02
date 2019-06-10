import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        System.out.println("Read numbers from 1 to 999");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scanner.nextInt();
        int special = num % 100;
        String str = "";
        if (num == 0) {
            str += "zero";
        } else if (special == 0) {
            int hundreds = num / 100;
            switch (hundreds) {
                case 1:
                    str += "one hundred";
                    break;
                case 2:
                    str += "two hundred";
                    break;
                case 3:
                    str += "three hundred";
                    break;
                case 4:
                    str += "four hundred";
                    break;
                case 5:
                    str += "five hundred";
                    break;
                case 6:
                    str += "six hundred";
                    break;
                case 7:
                    str += "seven hundred";
                    break;
                case 8:
                    str += "eight hundred";
                    break;
                case 9:
                    str += "nine hundred";
                    break;
                default:
                    str += "";
            }
        } else if (num > 0 && num < 1000) {
            int ones = num % 10;
            int dozens = ((num % 100) - ones) / 10;
            int hundreds = (num - (num % 100)) / 100;
            switch (hundreds) {
                case 1:
                    str += "one hundred and";
                    break;
                case 2:
                    str += "two hundred and";
                    break;
                case 3:
                    str += "three hundred and";
                    break;
                case 4:
                    str += "four hundred and";
                    break;
                case 5:
                    str += "five hundred and";
                    break;
                case 6:
                    str += "six hundred and";
                    break;
                case 7:
                    str += "seven hundred and";
                    break;
                case 8:
                    str += "eight hundred and";
                    break;
                case 9:
                    str += "nine hundred and";
                    break;
                default:
                    str += "";
                    break;
            }
            if (dozens >= 2) {
                switch (dozens) {
                    case 2:
                        str += " twenty";
                        break;
                    case 3:
                        str += " thirty";
                        break;
                    case 4:
                        str += " forty";
                        break;
                    case 5:
                        str += " fifty";
                        break;
                    case 6:
                        str += " sixty";
                        break;
                    case 7:
                        str += " seventy";
                        break;
                    case 8:
                        str += " eighty";
                        break;
                    case 9:
                        str += " ninety";
                        break;
                    default:
                        str += "";
                        break;
                }
                switch (ones) {
                    case 1:
                        str += " one";
                        break;
                    case 2:
                        str += " two";
                        break;
                    case 3:
                        str += " three";
                        break;
                    case 4:
                        str += " four";
                        break;
                    case 5:
                        str += " five";
                        break;
                    case 6:
                        str += " six";
                        break;
                    case 7:
                        str += " seven";
                        break;
                    case 8:
                        str += " eight";
                        break;
                    case 9:
                        str += " nine";
                        break;
                    default:
                        str += "";
                        break;
                }
            } else if (dozens < 2) {
                int specialNum = num % 100;
                switch (specialNum) {
                    case 1:
                        str += " one";
                        break;
                    case 2:
                        str += " two";
                        break;
                    case 3:
                        str += " three";
                        break;
                    case 4:
                        str += " four";
                        break;
                    case 5:
                        str += " five";
                        break;
                    case 6:
                        str += " six";
                        break;
                    case 7:
                        str += " seven";
                        break;
                    case 8:
                        str += " eight";
                        break;
                    case 9:
                        str += " nine";
                        break;
                    case 10:
                        str += " ten";
                        break;
                    case 11:
                        str += " eleven";
                        break;
                    case 12:
                        str += " twelve";
                        break;
                    case 13:
                        str += " thirteen";
                        break;
                    case 14:
                        str += " fourteen";
                        break;
                    case 15:
                        str += " fifteen";
                        break;
                    case 16:
                        str += " sixteen";
                        break;
                    case 17:
                        str += " seventeen";
                        break;
                    case 18:
                        str += " eighteen";
                        break;
                    case 19:
                        str += " nineteen";
                        break;
                    default:
                        str += "";
                        break;
                }
            }
        }
        if (str != "") {
            System.out.printf("'%d' is '%s'!", num, str);
        } else {
            System.out.print("Invalid input!");
        }
    }
}

