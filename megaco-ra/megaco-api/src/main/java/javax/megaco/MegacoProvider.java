package javax.megaco;

/**
 * This interface must be implemented by any class that represents the JAIN
 * MEGACO abstraction of an MEGACO stack and that interacts directly with a
 * proprietary (vendor-specific) implementation of that MEGACO stack.
 * 
 */
public interface MegacoProvider {

    /**
     * 
     * @param listener
     * @param UserId
     * @return
     * @throws java.util.TooManyListenersException
     * @throws javax.megaco.InvalidUserIdException
     * @throws javax.megaco.AssocHandleExhaustedException
     * @throws IllegalArgumentException
     */
    public int addMegacoListener(MegacoListener listener, UserId UserId)
			throws java.util.TooManyListenersException,
			javax.megaco.InvalidUserIdException,
			javax.megaco.AssocHandleExhaustedException,
			IllegalArgumentException;

    /**
     * 
     * @return
     */
    public MegacoStack getMegacoStack();

    /**
     * 
     * @param UserId
     * @return
     * @throws javax.megaco.NonExistentAssocException
     */
    public int getAssocHandle(UserId UserId)
			throws javax.megaco.NonExistentAssocException;

    /**
     * 
     * @param listener
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public void removeMegacoListener(MegacoListener listener, int assocHandle)
			throws IllegalArgumentException;

    /**
     * 
     * @param jainMegacoAssocEvent
     */
    public void sendMegacoAssocEvent(AssociationEvent jainMegacoAssocEvent);

    /**
     * 
     * @param jainMegacoCmdEvent
     * @return
     */
    public int sendMegacoCmdEvent(CommandEvent jainMegacoCmdEvent);




}
