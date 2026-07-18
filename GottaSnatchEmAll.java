import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {
    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> myMinusTheirs = new HashSet<>(myCollection);
        myMinusTheirs.removeAll(theirCollection);
        Set<String> theirsMinusMine = new HashSet<>(theirCollection);
        theirsMinusMine.removeAll(myCollection);
        return !myMinusTheirs.isEmpty() && !theirsMinusMine.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) {
            return new HashSet<>();
        }
        Set<String> intersection = new HashSet<>(collections.get(0));
        for (Set<String> collection : collections) {
            intersection.retainAll(collection);
        }
        return intersection;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        if (collections.isEmpty()) {
            return new HashSet<>();
        }
        Set<String> union = new HashSet<>();
        for (Set<String> collection : collections) {
            union.addAll(collection);
        }
        return union;
    }
}
