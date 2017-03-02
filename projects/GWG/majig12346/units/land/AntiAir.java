package majig12346.units.land;

import majig12346.PassiveFlag.MoveType;
import majig12346.Player;
import majig12346.terrain.Terrain;
import majig12346.units.Unit;
import majig12346.weapons.WeaponType;

public class AntiAir extends Tank{

	public AntiAir(Player owner) {
		super(owner);
		this.setWeapon(0, WeaponType.FLAK);
	}

	@Override
	public int getBuildCost() {
		return 800;
	}

	@Override
	public double getBaseArmorResistance() {
		//5% resistance
		return 0.95;
	}

	@Override
	public double resist(double damage, String source) {
		//25% resistance to rocket pods, small arms
		switch(source){
		case WeaponType.ROCKET_POD:
			return damage*0.75;
		case WeaponType.RIFLE:
			return damage*0.75;
		case WeaponType.MG:
			return damage*0.75;
		default:
			return damage;
		}
	}
	@Override
	public boolean couldTarget(Unit toCheck, Terrain hypothetical) { //cannot target Boats
		if(null==toCheck){
			return false; //can't target nothing
		}
		return hypothetical.distanceTo((Terrain) toCheck.getLocation())==1&&!MoveType.SEA.equals(toCheck.getMovementType());
	}
}
