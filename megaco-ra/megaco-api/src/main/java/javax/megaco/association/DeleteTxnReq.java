package javax.megaco.association;

import javax.megaco.AssociationEvent;


/**
 * 
 * @author wozza
 */
public class DeleteTxnReq extends AssociationEvent {

	private int txnHandle = -1;

    /**
     * 
     * @param source
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    public DeleteTxnReq(Object source, int assocHandle)
			throws IllegalArgumentException {
		super(source, assocHandle);
	}

	@Override
	public final int getAssocOperIdentifier() {

		return AssocEventType.M_DELETE_TXN_REQ;
	}

	/**
	 * Gets an object identifier that specifies the transaction identifier. If
	 * the transaction identifier is set to 0, then this would be the case when
	 * the transaction identifier is to represent all transactions.<br><br>
	 * If the transaction identifier is not set, then this method returns 0, indicating all transactions. 
	 * 
	 * @return Returns an integer value that specifies the transaction identifier.
	 */
	public final int getTxnHandle() {
		if(txnHandle==-1)
			return 0;
		
		return txnHandle;
		
	}
	
	/**
	 * This method sets the transaction identifier. To delete all transactions, the transaction identifier is set to 0. 
	 * @param transactionHandle A reference to transaction identifier.
	 * @throws IllegalArgumentException This exception is raised if the value of transaction handle passed to this method is less than 0.
	 */
	public final void setTxnHandle(int transactionHandle)     throws IllegalArgumentException
	{
		
		if(transactionHandle<0)
			throw new IllegalArgumentException("Txn Handle can not be less than zero");
		
		this.txnHandle=transactionHandle;
	}







public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("DeleteTxnReq:");
bob.append(super.toString());

bob.append("txnHandle=").append(txnHandle).append(",");

return bob.append(";").toString(); 
}












public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.association.DeleteTxnReq o = (javax.megaco.association.DeleteTxnReq)oo;
if (!super.equals(o)) return false;
if (txnHandle != o.txnHandle) return false;

return true;
}

}












