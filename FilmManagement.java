/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class FilmManagement {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        // Film and actor management
        FilmAndActorManagement management = new FilmAndActorManagement();
        
        // Popularity rankings, revenue simulation, and search functionality classes
        PopularityRankings rankings = new PopularityRankings(20);
        RevenueSimulation revenueSimulation = new RevenueSimulation();
        RevenueHistory revenueHistory = new RevenueHistory();
        SearchFunctionality searchFunctionality = new SearchFunctionality();
        
        // Sample actors
        Actor[] actors = {
            new Actor("Robert Downey Jr.", 101),
            new Actor("Scarlett Johansonn", 102),
            new Actor("Chris Hemsworth", 103),
            new Actor("Tom Holland", 104),
            new Actor("Chris Evans", 105),
            new Actor("Mark Ruffalo", 106),
            new Actor("Benedict Cumberbatch", 107),
            new Actor("Jeremy Renner", 108),
            new Actor("Brie Larson", 109),
            new Actor("Elizabeth Olsen", 110)
        };
        // Sample films
        Film[] films = {
            new Film("Avengers: End Game", 201, "Action", 2019),
            new Film("Avengers: Infinity War", 202, "Action", 2018),
            new Film("Thor: Ragnarok", 203, "Fantasy", 2017),
            new Film("Spider-Man: No Way Home", 204, "Advanture", 2021),
            new Film("Captain America: Civil War", 205, "Action", 2016),
            new Film("Doctor Strange", 206, "Fantasy", 2016),
            new Film("Black Panther", 207, "Action", 2018),
            new Film("Guardians of Galaxy", 208, "Sci-Fi", 2014),
            new Film("Ant-Man", 209, "Comedy", 2015),
            new Film("Iron Man 3", 210, "Action", 2013),
            new Film("Captain Marvel", 211, "Sci-Fi", 2019),
            new Film("Hawkeye", 212, "Action", 2021),
            new Film("WandaVision", 213, "Drama", 2021),
            new Film("Iron Man", 214, "Action", 2018),
            new Film("Thor", 215, "Fantasy", 2011),
            new Film("The Incredible Hulk", 216, "Action", 2018),
            new Film("Black Widow", 217, "Action", 2021),
            new Film("The Avengers", 218, "Action/Sci-Fi", 2012)
        };
        // Adding actors and films
        for (Actor actor : actors) {
            management.addActor(actor);
            searchFunctionality.addActor(actor);
        }
        for (Film film : films) {
            management.addFilm(film);
            searchFunctionality.addFilm(film);
            rankings.addFilm(film);
            revenueSimulation.scheduleFilm(film);
        }
        // Adding feedback
        films[0].addFeedback(5, "A timeless classic!");
        films[1].addFeedback(4, "Incredible concept and execution.");
        films[2].addFeedback(5, "Revolutionary in its genre.");
        films[3].addFeedback(5, "Epic and action-packed.");
        films[4].addFeedback(5, "Heartwarming and inspirational.");
        films[5].addFeedback(4, "A cinematic masterpiece.");
        films[6].addFeedback(4, "Quirky and unpredictable.");
        films[7].addFeedback(5, "A thrilling and intense ride.");
        films[8].addFeedback(4, "Provocative and engaging.");
        films[9].addFeedback(5, "Visually stunning and emotional.");
        films[10].addFeedback(5, "A moving story of hope.");
        films[11].addFeedback(4, "Epic battles and heartfelt moments.");
        films[12].addFeedback(5, "A childhood favorite.");
        films[13].addFeedback(5, "Dark and thought-provoking.");
        films[14].addFeedback(4, "A delightful family adventure.");
        films[15].addFeedback(5, "Timeless and charming.");
        films[16].addFeedback(4, "A groundbreaking sci-fi classic.");
        films[17].addFeedback(5, "Exciting and full of action.");

        // Assigning actors to films based on their appearances
        films[0].addActor(actors[0]); // Robert Downey Jr.
        films[0].addActor(actors[1]); // Scarlett Johansonn
        films[0].addActor(actors[4]); // Chris Evans
        films[0].addActor(actors[5]); // Mark Ruffalo

        films[1].addActor(actors[0]); // Robert Downey Jr.
        films[1].addActor(actors[1]); // Scarlett Johansonn
        films[1].addActor(actors[4]); // Chris Evans
        films[1].addActor(actors[5]); // Mark Ruffalo

        films[2].addActor(actors[2]); // Chris Hemsworth

        films[3].addActor(actors[3]); // Tom Holland

        films[4].addActor(actors[4]); // Chris Evans

        films[5].addActor(actors[6]); // Benedict Cumberbatch

        films[6].addActor(actors[5]); // Mark Ruffalo

        films[7].addActor(actors[7]); // Jeremy Renner

        films[8].addActor(actors[8]); // Brie Larson

        films[9].addActor(actors[0]); // Robert Downey Jr.

        films[10].addActor(actors[8]); // Brie Larson

        films[11].addActor(actors[7]); // Jeremy Renner

        films[12].addActor(actors[9]); // Elizabeth Olsen

        films[13].addActor(actors[0]); // Robert Downey Jr.

        films[14].addActor(actors[2]); // Chris Hemsworth

        films[15].addActor(actors[5]); // Mark Ruffalo

        films[16].addActor(actors[9]); // Elizabeth Olsen

        films[17].addActor(actors[0]); // Robert Downey Jr.

        // Revenue simulation and history recording for all films
        System.out.println("\n--- Revenue Simulation and Recording ---");
        for (Film film : films) {
            int viewers = 50000 + (int) (Math.random() * 20000); // Random viewers
            double ticketPrice = 10.0 + (Math.random() * 5.0);   // Random ticket price
            double revenue = viewers * ticketPrice;             // Calculated revenue

        // Update film revenue and record to history
        film.updateRevenue(revenue);
        revenueHistory.recordRevenue(revenue);

        System.out.println("Revenue for " + film.getFilmName() + ": $" + revenue);
        }

        // Dynamic user operations (example: search operations)
        System.out.println("\n--- Film Search ---");
        searchFunctionality.searchFilm("Titanic");
        searchFunctionality.searchFilm("Unknown Film");

        System.out.println("\n--- Actor Search ---");
        searchFunctionality.searchActor("Leonardo DiCaprio");
        searchFunctionality.searchActor("Unknown Actor");

        // Outputs
        System.out.println("\n--- Actor List ---");
        management.displayAllActors();

        System.out.println("\n--- Film List ---");
        management.displayAllFilms();

        System.out.println("\n--- Popularity Rankings ---");
        rankings.displayPopularityRankings();

        System.out.println("\n--- Revenue History ---");
        revenueHistory.getLastNRevenues(2);

        System.out.println("\n--- All Films (Sorted) ---");
        searchFunctionality.displayAllFilms();

        System.out.println("\n--- All Actors (Sorted) ---");
        searchFunctionality.displayAllActors();
        
    }
}

    