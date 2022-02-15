package javax.megaco.message;

import java.io.Serializable;

/**
 * The Jain MEGACO descriptor class is an abstract class. This is to be derived
 * by the individual descriptor classes.
 * 
 * @author amit bhayani
 * 
 */
public abstract class Descriptor implements Serializable {

    /**
     * 
     */
    protected int descriptorId = -1;

	/**
	 * Constructs a Jain Megaco abstract class.
	 */
	public Descriptor() {

	}

	/**
	 * The method is an abstract method and can be used to get the descriptor
	 * identifier. By overriding this method the derived class would return a
	 * hardcoded value that would correspond to its descriptor identity.
	 * 
	 * @return descriptorId - The integer corresponding to the descriptor id.
	 *         The values shall be defined in DescriptorType
	 */
	public abstract int getDescriptorId();

	@Override


















public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("Descriptor:");

bob.append("descriptorId=").append(descriptorId).append(",");

return bob.append(";").toString(); 
}




















public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.Descriptor o = (javax.megaco.message.Descriptor)oo;
if (descriptorId != o.descriptorId) return false;

return true;
}

}




























