/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class RevenueHistory {
        private Stack<Double> revenueStack; 

    public RevenueHistory() {
        revenueStack = new Stack<>();
    }

    public void recordRevenue(double revenue) {
        revenueStack.push(revenue);
    }

    public void getLastNRevenues(int n) {
        System.out.println("Last " + n + " Revenue Calculations:");
        Stack<Double> tempStack = new Stack<>();
        int count = 0;

        while (!revenueStack.isEmpty() && count < n) {
            Double revenue = revenueStack.pop();
            System.out.println("Revenue: $" + revenue);
            tempStack.push(revenue);
            count++;
        }

        while (!tempStack.isEmpty()) {
            revenueStack.push(tempStack.pop());
        }
    }  
}
