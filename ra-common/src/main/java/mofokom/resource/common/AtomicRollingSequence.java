/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wozza
 */
public class AtomicRollingSequence {

    AtomicInteger seq;

    public AtomicRollingSequence() {
        seq = new AtomicInteger();
    }

    public AtomicRollingSequence(int seq) {
        this.seq = new AtomicInteger(seq);
    }

    public int getNextSequenceNumber(){
        if (seq.get() == Integer.MAX_VALUE)
            reset();

        return seq.getAndIncrement();
    }


    public void reset() {
        seq.set(0);
    }


}
