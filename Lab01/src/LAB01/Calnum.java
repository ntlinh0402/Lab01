package LAB01;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Calnum {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        String[] options = {"Solve linear equation", "Solve system of linear equation", "Solve Quadratic equation"};
        int choice = JOptionPane.showOptionDialog(null, 
                "Choose type of equation", 
                "Solve equation",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]);
        
        switch(choice) {
            case 0:
                solveLinearEqu();
                break;
            case 1:
                solveLinearSys();
                break;
            case 2:
                solveSecondDegree();
                break;
            default:
                System.exit(0);
        }
        
        scanner.close();
    }

    private static void solveLinearEqu() {
        System.out.print("Enter coefficient A (Ax+B=0): ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter coefficient B (Ax+B=0): ");
        double b = scanner.nextDouble();
        
        if(a==0) {
            if(b==0) {
                System.out.println("The equation has infinite solutions");
            }
            else {
                System.out.println("The equation has no solution");
            }
        }
        else {
            double res = -b/a;
            System.out.println("Solution is: x = " + res);
        }
    }
    private static void solveLinearSys() {
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1; 
        if(D!=0) {
            double x1 = D1/D;
            double x2 = D2/D;
            System.out.println("The system has a unique solution:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else {
            if(D1==0 && D2==0) {
                System.out.println("The system has infinite solutions");
            }
            else {
                System.out.println("The system has no solution");
            }
        }
    }
    
    private static void solveSecondDegree() {
        System.out.print("Enter coefficient A (Ax²+Bx+C=0): ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient B (Ax²+Bx+C=0): ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient C (Ax²+Bx+C=0): ");
        double c = scanner.nextDouble();
        double delta = b*b - 4*a*c;
        if(delta<0) {
            System.out.println("The equation has no real solution");
        }
        else if(delta==0) {
            double sol = -b/(2*a);
            System.out.println("The equation has a double solution: x = " + sol);
        }
        else {
            double x1 = (-b-Math.sqrt(delta))/(2*a);
            double x2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("The equation has two distinct solutions:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}