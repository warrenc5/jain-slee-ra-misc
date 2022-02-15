/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl.codec;

import java.util.List;
import java.util.Objects;
import javax.megaco.association.AssociationInd;
import javax.megaco.association.RemoteAddr;

/**
 *
 * @author wozza
 */
public class MessageHeader {

    RemoteAddr remoteAddr;
    AssociationInd association;

    String mId;
    int spIndex;
    int sequenceNumber;
    String authData;
    int protocolVersion;

    List<Integer[]> transactionIdList ;
    int transactionId;
    boolean transaction,transactionResponseAck,pending, reply;

    public AssociationInd getAssociation() {
        return association;
    }

    public void setAssociation(AssociationInd association) {
        this.association = association;
    }

    public String getAuthData() {
        return authData;
    }

    public void setAuthData(String authData) {
        this.authData = authData;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public RemoteAddr getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(RemoteAddr remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getSpIndex() {
        return spIndex;
    }

    public void setSpIndex(int spIndex) {
        this.spIndex = spIndex;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public boolean isTransactionResponseAck() {
        return transactionResponseAck;
    }

    public void setTransactionResponseAck(boolean transactionResponseAck) {
        this.transactionResponseAck = transactionResponseAck;
    }

    public List<Integer[]> getTransactionIdList() {
        return transactionIdList;
    }

    public void setTransactionIdList(List<Integer[]> transactionIdList) {
        this.transactionIdList = transactionIdList;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MessageHeader other = (MessageHeader) obj;
        if (!Objects.equals(this.remoteAddr, other.remoteAddr))
            return false;
        if (!Objects.equals(this.association, other.association))
            return false;
        if (!Objects.equals(this.mId, other.mId))
            return false;
        if (this.spIndex != other.spIndex)
            return false;
        if (this.sequenceNumber != other.sequenceNumber)
            return false;
        if (!Objects.equals(this.authData, other.authData))
            return false;
        if (this.protocolVersion != other.protocolVersion)
            return false;
        if (this.transactionId != other.transactionId)
            return false;
        if (this.transactionResponseAck != other.transactionResponseAck)
            return false;
        if (this.pending != other.pending)
            return false;
        if (this.reply != other.reply)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }



    @Override
    public String toString() {
        return "MessageHeader{" + "remoteAddr=" + remoteAddr + ", association=" + association + ", mId=" + mId + ", spIndex=" + spIndex + ", sequenceNumber=" + sequenceNumber + ", authData=" + authData + ", protocolVersion=" + protocolVersion + ", transactionId=" + transactionId + ", transaction=" + transaction + ", transactionResponseAck=" + transactionResponseAck + ", pending=" + pending + ", reply=" + reply + ",transactionList="+transactionIdList + '}';
    }


    

}