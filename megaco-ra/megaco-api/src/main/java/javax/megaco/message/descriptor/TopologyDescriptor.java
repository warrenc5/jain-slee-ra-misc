package javax.megaco.message.descriptor;


import javax.megaco.message.Descriptor;
import javax.megaco.message.DescriptorType;
import javax.megaco.message.Termination;

/**
 * The class extends JAIN MEGACO Descriptor. This class describes the topology
 * descriptor.
 */
public class TopologyDescriptor extends Descriptor {

	private Termination termA = null;
	private Termination termB = null;
	private TopologyDirection topologyDirect = null;

	/**
	 * Constructs a Topology Descriptor with the mandatory parameters of the
	 * termination-A, termination-B and the topology direction between these
	 * terminations.
	 * 
	 * @param termA
	 *            - This specifies an object identifier for the termination A.
	 * @param termB
	 *            - This specifies an object identifier for the termination B.
	 * @param topologyDirect
	 *            - This specifies topology direction between the terminations.
	 * @throws IllegalArgumentException
	 *             : This exception is raised if the reference of either of
	 *             Termination Ids or the Topology Direction passed to this
	 *             method is NULL.
	 */
	public TopologyDescriptor(Termination termA, Termination termB, TopologyDirection topologyDirect) throws IllegalArgumentException {
		if (termA == null || termB == null || topologyDirect == null) {
			IllegalArgumentException invalidArgumentException = new IllegalArgumentException("None of Termination A,b and TopologyDirection can be null");
			throw invalidArgumentException;
		}

		this.termA = termA;
		this.termB = termB;
		this.topologyDirect = topologyDirect;
		super.descriptorId = DescriptorType.M_TOPOLOGY_DESC;
	}

	/**
	 * This method cannot be overridden by the derived class. This method
	 * returns that the descriptor identifier is of type Topology descriptor.
	 * This method overrides the corresponding method of the base class
	 * Descriptor.
	 * 
	 * @return Returns an integer value that identifies this object as the type
	 *         of topology descriptor. It returns that it is Topology Descriptor
	 *         i.e., M_TOPOLOGY_DESC.
	 */
	public final int getDescriptorId() {
		return super.descriptorId;
	}

	/**
	 * This method retrieves the termination A set in the topology descriptor.
	 * 
	 * @return Returns the termination A for the topology.
	 */
	public Termination getTermA() {
		return this.termA;
	}

	/**
	 * This method retrieves the termination B set in the topology descriptor.
	 * 
	 * @return Returns the termination B for the topology.
	 */
	public Termination getTermB() {
		return this.termB;
	}

	/**
	 * This method retrieves the integer value of the topology direction set in
	 * the topology descriptor.
	 * 
	 * @return Returns the integer value for the topology direction. It can take
	 *         only the values set in TopologyDirection
	 */
	public int getTopologyDirection() {
		return this.topologyDirect.getTopologyDirection();
	}
















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TopologyDescriptor:");
bob.append(super.toString());

if(termA !=null)
bob.append("termA=").append(termA).append(",");
if(termB !=null)
bob.append("termB=").append(termB).append(",");
if(topologyDirect !=null)
bob.append("topologyDirect=").append(topologyDirect).append(",");

return bob.append(";").toString(); 
}



















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.TopologyDescriptor o = (javax.megaco.message.descriptor.TopologyDescriptor)oo;
if (!super.equals(o)) return false;
if((termA !=null && o.termA == null) ||(termA == null && o.termA != null) ) return false;
if(termA ==null && o.termA == null) return true ; else if(termA !=null && o.termA != null)
if (termA != null && o.termA !=null && !termA.equals(o.termA)) return false;
if((termB !=null && o.termB == null) ||(termB == null && o.termB != null) ) return false;
if(termB ==null && o.termB == null) return true ; else if(termB !=null && o.termB != null)
if (termB != null && o.termB !=null && !termB.equals(o.termB)) return false;
if((topologyDirect !=null && o.topologyDirect == null) ||(topologyDirect == null && o.topologyDirect != null) ) return false;
if(topologyDirect ==null && o.topologyDirect == null) return true ; else if(topologyDirect !=null && o.topologyDirect != null)
if (topologyDirect != null && o.topologyDirect !=null && !topologyDirect.equals(o.topologyDirect)) return false;

return true;
}

}
























