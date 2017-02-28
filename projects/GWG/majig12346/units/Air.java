package majig12346.units;

import majig12346.PassiveFlag.MoveType;
import majig12346.Player;

/**
 * abstract Air represents all air units
 * Air units use some fuel every day to stay in flight and will crash without fuel.
 * These get MoveType.AIR
 * Air units traverse all Terrains for 1 mobility
 */
public abstract class Air extends Unit {

	/**
	 * calls super(Player) from child classes
	 * don't invoke this
	 * @param owner
	 */
	public Air(Player owner) {
		super(owner);
	}

	@Override
	public void outOfFuel() {
		//TODO crash animation
		this.selfDestruct(true);
	}

	@Override
	public MoveType getMovementType() {
		return MoveType.AIR;
	}

}
