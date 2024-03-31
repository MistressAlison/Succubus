package Succubus.cards;

import Succubus.cards.abstracts.AbstractEasyCard;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.cards.blue.Scrape;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.RipAndTearEffect;

import static Succubus.MainModfile.makeID;

public class TwinClaw extends AbstractEasyCard {
    public final static String ID = makeID(TwinClaw.class.getSimpleName());

    public TwinClaw() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = damage = 3;
        baseMagicNumber = magicNumber = 2;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            addToBot(new VFXAction(new RipAndTearEffect(m.hb.cX, m.hb.cY, Color.RED, Color.GOLD)));
            addToBot(new VFXAction(new RipAndTearEffect(m.hb.cX, m.hb.cY, Color.RED, Color.GOLD)));
        }
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        addToBot(new ModifyDamageAction(this.uuid, magicNumber));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }

    @Override
    public String cardArtCopy() {
        return Scrape.ID;
    }
}