package cbskarmory.units.land;

import cbskarmory.Player;
import cbskarmory.PassiveFlag.MoveType;
import cbskarmory.terrain.Terrain;
import cbskarmory.units.Unit;
import cbskarmory.weapons.WeaponType;

/**
 * Gets NONE, MG (infinite ammo machine gun)
 * Costs 400
 *  MoveType TIRES
 *  Does well against infantry, poorly vs armor -- quite mobile
 */
public class Recon extends Unit{

	/**
	 * Constructs a Recon truck
	 * sets primary weapon to NONE, seconday to MG
	 * @param owner
	 */
	public Recon(Player owner) {
		super(owner);
		setWeapon(0, WeaponType.NONE); //has no primary -- seconday has infinite ammo
		setWeapon(1, WeaponType.MG);
	}

	@Override
	public int getBuildCost() {
		return 400;
	}

	@Override
	public double getBaseArmorResistance() {
		return 1;
	}

	@Override
	public void outOfFuel() {
		//do nothing
	}

	@Override
	public MoveType getMovementType() {
		return MoveType.TIRES;
	}
	@Override
	public boolean couldTarget(Unit toCheck, Terrain hypothetical) { //cannot target jet fighters
		return super.couldTarget(toCheck, hypothetical)&&!toCheck.isJet();
	}
}
