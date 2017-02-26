package majig12346.units.air;

import majig12346.PassiveFlag.MoveType;
import majig12346.Player;
import majig12346.terrain.Terrain;
import majig12346.units.Stealth;
import majig12346.units.Unit;
import majig12346.weapons.WeaponType;

/**
 * The stealth bomber is a stealth air-to-ground aircraft
 * Gets HEAT (direct A2G)
 *  Costs 3200
 *  Costs 5 fuel/turn to stay airborne, 
 *  costs 3 extra when hidden (8 total /turn)
 */
public class StealthBomber extends Stealth {

	/**
	 * Constructs a stealth bomber.
	 * sets primary weapon to HEAT
	 * @param owner owner of the unit
	 */
	public StealthBomber(Player owner) {
		super(owner);
		setWeapon(0, WeaponType.HEAT);
	}

	@Override
	public int getExtraDailyCost() {
		return 3;
	}

	@Override
	public int getBuildCost() {
		return 3200;
	}

	@Override
	public double getBaseArmorResistance() {
		return 1;
	}
	@Override
	public int getDailyCost() {
		return 5;
	}
	/**
     * 50% of small arms miss, HMG lacks net velocity -- 50% damage reduction
	 * missiles have limited effectiveness against stealth, 30% damage reduction
     */
	@Override
	public double resist(double damage, String source) {
		//
		switch(source){
		case WeaponType.RIFLE:
			return damage*0.5;
		case WeaponType.MG:
			return damage*0.5;
		case WeaponType.HMG:
			return damage*0.5;
		case WeaponType.MISSILE:
			return damage*0.7;
		case WeaponType.MISSILES:
			return damage*0.7;
		default:
			return damage;
		}
	}
	@Override
	public boolean couldTarget(Unit toCheck, Terrain hypothetical) { //cannot target air
		return super.couldTarget(toCheck, hypothetical)&&!MoveType.AIR.equals(toCheck.getMovementType());
	}
}
