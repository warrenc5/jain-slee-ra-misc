package javax.megaco.association;

import javax.megaco.AssociationEvent;


/**
 * 
 * @author wozza
 */
public class CreateTxnReq extends AssociationEvent {

	// FIXME 0 is correct defautl value?
    /**
     * 
     */
    protected int exchangeId = 0;

	/**
	 * Constructs a Create Transaction Request Event object.
	 * 
	 * @param source
	 *            - A reference to the object, the "source", that is logically
	 *            deemed to be the object upon which the Event in question
	 *            initially occurred.
	 * @param assocHandle
	 *            - The association handle to uniquely identify the MG-MGC pair.
	 *            This is allocated by the stack when the Listener registers
	 *            with the provider with a unique MG-MGC identity.
	 * @param exchangeId
	 *            - The exchange Identifier value.
	 * @throws IllegalArgumentException
	 */
	public CreateTxnReq(Object source, int assocHandle, int exchangeId)
			throws IllegalArgumentException {
		super(source, assocHandle);
		this.exchangeId=exchangeId;
	}

	@Override
	public int getAssocOperIdentifier() {

		return AssocEventType.M_CREATE_TXN_REQ;
	}

	/**
	 * Gets the echange identifier value. This identifier is used for
	 * corellating the create transaction request and response. The response for
	 * this create transaction event must have the same exchange Id.
	 * 
	 * @return Returns the exchange identifier value.
	 */
	public int getExchangeId() {
		return exchangeId;
	}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("CreateTxnReq:");
bob.append(super.toString());

bob.append("exchangeId=").append(exchangeId).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.CreateTxnReq o = (javax.megaco.association.CreateTxnReq)oo;
if (!super.equals(o)) return false;
if (exchangeId != o.exchangeId) return false;

return true;
}

}












