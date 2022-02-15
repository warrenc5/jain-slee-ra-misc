package javax.megaco.message.descriptor;

import java.io.Serializable;

/**
 * Topology direction constants used in package javax.megaco.message.descriptor.
 * This class defines the topology direction for the megaco package.
 * 
 */
public class TopologyDirection implements Serializable {
    /**
     * 
     */
    public static final int M_BOTHWAY = 0;
    /**
     * 
     */
    public static final int M_ISOLATE = 1;
    /**
     * 
     */
    public static final int M_ONEWAY = 2;

    /**
     * 
     */
    public static final TopologyDirection BOTHWAY = new TopologyDirection(M_BOTHWAY);

    /**
     * 
     */
    public static final TopologyDirection ISOLATE = new TopologyDirection(M_ISOLATE);

    /**
     * 
     */
    public static final TopologyDirection ONEWAY = new TopologyDirection(M_ONEWAY);

	private int topology_direction;

	private TopologyDirection(int topology_direction) {
		this.topology_direction = topology_direction;
	}

    /**
     * 
     * @return
     */
    public int getTopologyDirection() {
		return this.topology_direction;
	}

    /**
     * 
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    public static final TopologyDirection getObject(int value) throws IllegalArgumentException {
		TopologyDirection t = null;
		switch (value) {
		case M_BOTHWAY:
			t = BOTHWAY;
			break;
		case M_ISOLATE:
			t = ISOLATE;
			break;
		case M_ONEWAY:
			t = ONEWAY;
			break;

		default:
			throw new IllegalArgumentException("No TopologyDirection for value = " + value);
		}

		return t;
	}

	private Object readResolve() {
		return this.getObject(this.topology_direction);
	}

	@Override
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TopologyDirection:");

bob.append("topology_direction=").append(topology_direction).append(",");

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.TopologyDirection o = (javax.megaco.message.descriptor.TopologyDirection)oo;
if (topology_direction != o.topology_direction) return false;

return true;
}

}


























