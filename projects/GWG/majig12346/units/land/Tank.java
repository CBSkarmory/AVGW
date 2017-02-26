package majig12346.units.land;

import majig12346.PassiveFlag.MoveType;
import majig12346.terrain.Terrain;
import majig12346.Player;
import majig12346.units.Unit;
import majig12346.weapons.WeaponType;

/*
 * A Tank is a Unit
 * Gets HE
 * Costs 700
 * MoveType TREADS
 * This is light/regular tank
 * High Explosive shells are strong against infantry
 */
public class Tank extends Unit{

	/**
	 * Constructs a Tank
	 * sets primary weapon to HE
	 * @param owner owner of the Unit
	 */
	public Tank(Player owner) {
		super(owner);
		setWeapon(0, WeaponType.HE);
	}

	@Override
	public int getBuildCost() {
		return 700;
	}

	@Override
	public double getBaseArmorResistance() {
		//5% resistance
		return 0.95;
	}
	
	@Override
	public double resist(double damage, String source) {
		//35% small arms resistance
		switch(source){
		case WeaponType.RIFLE:
			return damage*0.65;
		case WeaponType.MG:
			return damage*0.65;
		default:
			return damage;
		}
	}
	@Override
	public void outOfFuel() {
		//do nothing
	}

	@Override
	public MoveType getMovementType() {
		return MoveType.TREADS;
	}
	@Override
	public boolean couldTarget(Unit toCheck, Terrain hypothetical) { //cannot target air
		return super.couldTarget(toCheck, hypothetical)&&!MoveType.AIR.equals(toCheck.getMovementType());
	}

}
