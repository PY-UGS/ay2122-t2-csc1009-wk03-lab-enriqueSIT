import java.util.Scanner;



public class Loan {
    
    private double annualInterestRate;
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    private int numberOfYears;
    public int getNumberOfYears() {
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    private double loanAmount;
    
    public double getLoanAmount() {
        return loanAmount;
    }
    
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    private java.util.Date loanDate;
    
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(java.util.Date loanDate) {
        this.loanDate = loanDate;
    }

    
    public Loan() {}

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate / 100;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new java.util.Date();
    }

    public double GetMonthlyPayment() {
        return 
        (this.getLoanAmount() * this.getAnnualInterestRate() / 12) / 
        (1 - (1 / (Math.pow((1 + this.getAnnualInterestRate() / 12), 
        (this.getNumberOfYears() * 12)))));
    }

    public double getTotalPayment() {
        return this.GetMonthlyPayment() * this.getNumberOfYears() * 12;
    }


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter annual interest rate: ");
        double rate = reader.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int years = reader.nextInt();
        System.out.print("Enter loan amount: ");
        double loanAmount = reader.nextDouble();

        reader.close();

        Loan myLoan = new Loan(rate, years, loanAmount);
        
        System.out.printf("The loan was created on %s%n", myLoan.getLoanDate());
        System.out.printf("The monthly payment is %.2f%n", myLoan.GetMonthlyPayment());
        System.out.printf("The total payment is %.2f%n", myLoan.getTotalPayment());
        
    }
}
