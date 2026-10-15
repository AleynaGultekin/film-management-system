/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */

public class RevenueSimulation {
    private Queue<Film> filmQueue; 
    private Stack<Double> revenueStack; 

    public RevenueSimulation() {
        filmQueue = new Queue<>();
        revenueStack = new Stack<>();
    }

    public void scheduleFilm(Film film) {
        filmQueue.enqueue(film);
        System.out.println("Scheduled film for screening: " + film.filmName);
    }

    public void simulateRevenue(int viewers, double ticketPrice) {
        if (filmQueue.isEmpty()) {
            System.out.println("No films in the queue to simulate revenue.");
            return;
        }

        Film film = filmQueue.dequeue();
        double revenue = viewers * ticketPrice;

        film.updateRevenue(revenue);
        revenueStack.push(revenue);

        System.out.println("Simulated revenue for " + film.filmName + ": $" + revenue);
    }

    public void displayHistoricalRevenues() {
        System.out.println("Historical Revenues:");
        Stack<Double> tempStack = new Stack<>();

        while (!revenueStack.isEmpty()) {
            double revenue = revenueStack.pop();
            System.out.println("$" + revenue);
            tempStack.push(revenue); // Eski sıralamayı korumak için
        }

        while (!tempStack.isEmpty()) {
            revenueStack.push(tempStack.pop());
        }
    }

}
