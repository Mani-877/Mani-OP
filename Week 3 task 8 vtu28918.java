import java.util.Comparator;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score; // Higher score first
        }
        return a.name.compareTo(b.name); // Alphabetical order if scores are equal
    }
}

Output

amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
