/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.scarsofmirrodin;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.abilities.effects.common.counter.ProliferateEffect;
import mage.cards.CardImpl;
import mage.counters.CounterType;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Loki
 */
public class ContagionClasp extends CardImpl<ContagionClasp> {

    public ContagionClasp (UUID ownerId) {
        super(ownerId, 144, "Contagion Clasp", Rarity.UNCOMMON, new CardType[]{CardType.ARTIFACT}, "{2}");
        this.expansionSetCode = "SOM";
        Ability ability = new EntersBattlefieldTriggeredAbility(new AddCountersTargetEffect(CounterType.M1M1.createInstance()), false);
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
        ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new ProliferateEffect(), new GenericManaCost(4));
        ability.addCost(new TapSourceCost());
        this.addAbility(ability);
    }

    public ContagionClasp (final ContagionClasp card) {
        super(card);
    }

    @Override
    public ContagionClasp copy() {
        return new ContagionClasp(this);
    }

}
