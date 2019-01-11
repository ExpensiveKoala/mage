package mage.cards.d;

import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.ReturnFromGraveyardToHandTargetEffect;
import mage.abilities.keyword.SpectacleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.FilterCard;
import mage.filter.common.FilterCreatureCard;
import mage.target.common.TargetCardInYourGraveyard;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class DeadRevels extends CardImpl {

    private static final FilterCard filter = new FilterCreatureCard("creature cards from your graveyard");

    public DeadRevels(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{3}{B}");

        // Spectacle {1}{B}
        this.addAbility(new SpectacleAbility(this, new ManaCostsImpl("{1}{B}")));

        // Return up to two target creature cards from your graveyard to your hand.
        this.getSpellAbility().addEffect(new ReturnFromGraveyardToHandTargetEffect());
        this.getSpellAbility().addTarget(new TargetCardInYourGraveyard(0, 2, filter));
    }

    private DeadRevels(final DeadRevels card) {
        super(card);
    }

    @Override
    public DeadRevels copy() {
        return new DeadRevels(this);
    }
}
