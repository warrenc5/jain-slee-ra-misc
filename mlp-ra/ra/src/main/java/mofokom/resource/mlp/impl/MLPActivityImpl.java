/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.mlp.impl;

import java.io.Serializable;
import mofokom.resource.mlp.MLPActivity;
import mofokom.resource.common.AbstractTransaction;

/**
 *
 * @author wozza
 */
public class MLPActivityImpl extends AbstractTransaction<Serializable,String> implements MLPActivity {

    public MLPActivityImpl(Serializable attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}