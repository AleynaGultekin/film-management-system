/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaley
 */
public class Film {
    String filmName; 
    int uniqueFilmID; 
    LinkedList<Actor> actorList; 
    String genre; 
    int releaseYear; 
    double totalRevenue; 
    List<ViewerFeedback> feedbackList = new ArrayList<>();

    public Film(String filmName, int uniqueFilmID, String genre, int releaseYear) {
        this.filmName = filmName;
        this.uniqueFilmID = uniqueFilmID;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = 0.0;
        this.actorList = new LinkedList<>();
        this.feedbackList = new ArrayList<>();

    }
   
    public String getFilmName() {
        return this.filmName;
    }
    
    public LinkedList<Actor> getActorList() {
        return actorList;
    }
    
    public void addFeedback(int rating, String review) {
        ViewerFeedback feedback = new ViewerFeedback(rating, review);
        feedbackList.add(feedback);
        if (feedbackList == null) {
           feedbackList = new ArrayList<>();
        }
        updatePopularity(); 
    }

    public void updatePopularity() {
        double totalRating = 0.0;
        for (ViewerFeedback feedback : feedbackList) {
            totalRating += feedback.getRating();
        }
        double averageRating = totalRating / feedbackList.size();
        System.out.println("Average Rating for " + filmName + ": " + averageRating);
    }
    
    public double getPopularityScore() {
        return totalRevenue;
    }

    public void addActor(Actor actor) {
        if (!actorList.contains(actor)) {
            actorList.add(actor);
            actor.addFilm(this); 
        }
    }

    public void removeActor(Actor actor) {
        if (actorList.contains(actor)) {
            actorList.remove(actor);
            actor.removeFilm(this); 
        }
    }

    public void updateRevenue(double revenue) {
        this.totalRevenue += revenue;
    }

    public void updateFilm(String newName, String newGenre, int newYear) {
        if (newName != null && !newName.isEmpty()) this.filmName = newName;
        if (newGenre != null && !newGenre.isEmpty()) this.genre = newGenre;
        if (newYear > 0) this.releaseYear = newYear;
    }

    @Override
    public String toString() {
        return "Film: " + filmName + " (ID: " + uniqueFilmID + "), Genre: " + genre + ", Year: " + releaseYear + ", Revenue: " + totalRevenue;
    } 
}
