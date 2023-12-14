package mage.game.mulligan;

import mage.cards.Card;

import java.util.Comparator;

/**
 * GUI related, hand card sorting for mulligan
 *
 * @author JayDi85
 */
public class MulliganDefaultHandSorter implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        // groups: lands > other > creatures
        // inside group: by mana value, by name

        // lands
        if (c1.isLand() != c2.isLand()) {
            return Boolean.compare(c2.isLand(), c1.isLand());
        }
        // creatures
        if (c1.isCreature() != c2.isCreature()) {
            return Boolean.compare(c1.isCreature(), c2.isCreature());
        }
        // by mana
        if (c1.getManaValue() != c2.getManaValue()) {
            return Integer.compare(c1.getManaValue(), c2.getManaValue());
        }
        // by name
        return c1.getName().compareTo(c2.getName());
    }
}
