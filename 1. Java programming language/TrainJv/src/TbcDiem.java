import java.util.Scanner;

public class TbcDiem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tính điểm trung bình cộng của học sinh!");
        System.out.println("Enter Biology score: ");
        float biologyScore = scanner.nextFloat();
        System.out.println("Enter Physical score: ");
        float physicalScore = scanner.nextFloat();
        System.out.println("Enter Chemical score: ");
        float chemicalScore = scanner.nextFloat();
        float sum = biologyScore + physicalScore + chemicalScore;
        System.out.println("Total = " + sum);
        float result = sum / 3;
        System.out.println("Average = " + result);
    }
}
