/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class PopularityRankings {
    private Heap heap;
    private LinkedList<Film> filmsList;

    public PopularityRankings(int initialCapacity) {
        this.heap = new Heap(initialCapacity); 
        this.filmsList = new LinkedList<>();
    }

    public void addFilm(Film film) {
        filmsList.add(film); 
        if (filmsListSize() > heap.getCapacity()) {
            heap = new Heap(filmsListSize()); 
        }
        heap.insert(film); 
    }

    public void updateFilmRevenue(String filmName, double additionalRevenue) {
        LinkedList.Node<Film> temp = filmsList.getHead();  
        while (temp != null) {
            Film film = temp.data;
            if (film.getFilmName().equals(filmName)) {
                film.totalRevenue += additionalRevenue; 
                heapifyHeap(); 
                return;
            }
            temp = temp.next;
        }
        System.out.println("Film bulunamadı: " + filmName);
    }
 
    public void displayPopularityRankings() {
        heap.displayHeap();
    }

    private void heapifyHeap() {
        Heap newHeap = new Heap(filmsListSize());  
        LinkedList.Node<Film> temp = filmsList.getHead();  
        while (temp != null) {
            newHeap.insert(temp.data); 
            temp = temp.next;
        }
        this.heap = newHeap; 
    }

    private int filmsListSize() {
        int size = 0;
        LinkedList.Node<Film> temp = filmsList.getHead();  
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    } 
}
