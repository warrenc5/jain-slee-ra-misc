package mofokom.resource.mlp;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

public interface MLPActivityContextInterfaceFactory {
     public ActivityContextInterface getActivityContextInterface(MLPActivity activity) throws UnrecognizedActivityException;
}
