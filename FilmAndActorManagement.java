/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class FilmAndActorManagement {
    LinkedList<Film> films; 
    LinkedList<Actor> actors; 

    public FilmAndActorManagement() {
        this.films = new LinkedList<>();
        this.actors = new LinkedList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void removeFilm(Film film) {
        films.remove(film);
    }

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    public void displayAllFilms() {
        films.display();
    }

    public void displayAllActors() {
        actors.display();
    }
}
