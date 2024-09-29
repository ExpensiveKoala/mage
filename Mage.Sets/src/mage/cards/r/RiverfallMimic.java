package mage.cards.r;

import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.common.SpellCastControllerTriggeredAbility;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.effects.common.continuous.SetBasePowerToughnessSourceEffect;
import mage.abilities.keyword.CantBeBlockedSourceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.filter.FilterSpell;
import mage.filter.predicate.mageobject.ColorPredicate;

import java.util.UUID;

/**
 * @author jeffwadsworth
 */
public final class RiverfallMimic extends CardImpl {

    private static final FilterSpell filter = new FilterSpell("a spell that's both blue and red");

    static {
        filter.add(new ColorPredicate(ObjectColor.BLUE));
        filter.add(new ColorPredicate(ObjectColor.RED));
    }

    public RiverfallMimic(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{U/R}");
        this.subtype.add(SubType.SHAPESHIFTER);

        this.color.setRed(true);
        this.color.setBlue(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(1);

        // Whenever you cast a spell that's both blue and red, Riverfall Mimic has base power and toughness 3/3 until end of turn and can't be blocked this turn.
        Ability ability = new SpellCastControllerTriggeredAbility(
                new SetBasePowerToughnessSourceEffect(3, 3, Duration.EndOfTurn),
                filter, false
        );
        ability.addEffect(new GainAbilitySourceEffect(new CantBeBlockedSourceAbility(), Duration.EndOfTurn)
                .setText("and can't be blocked this turn"));
        this.addAbility(ability);
    }

    private RiverfallMimic(final RiverfallMimic card) {
        super(card);
    }

    @Override
    public RiverfallMimic copy() {
        return new RiverfallMimic(this);
    }
}
