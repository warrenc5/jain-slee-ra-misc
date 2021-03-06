package old;

import org.apache.cxf.binding.xml.interceptor.XMLMessageInInterceptor;
import org.apache.cxf.interceptor.DocLiteralInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.interceptor.StaxInInterceptor;
import org.apache.cxf.interceptor.WrappedInInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class DatabindingInSetupInterceptor extends AbstractPhaseInterceptor<Message> {

    private static final WrappedInInterceptor WRAPPED_IN = new WrappedInInterceptor();
    private static final XMLMessageInInterceptor XML_IN = new XMLMessageInInterceptor();
    private static final DocLiteralInInterceptor DOCLIT_IN = new DocLiteralInInterceptor();
    private static final URIParameterInInterceptor URI_IN = new URIParameterInInterceptor();
    private static final StaxInInterceptor STAX_IN = new StaxInInterceptor();
    private static final DispatchInterceptor DISPATCH_IN = new DispatchInterceptor();

    public DatabindingInSetupInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) throws Fault {
        boolean client = Boolean.TRUE.equals(message.get(Message.REQUESTOR_ROLE));
        InterceptorChain chain = message.getInterceptorChain();

        if (client) {
            chain.add(DOCLIT_IN);
            chain.add(XML_IN);
            chain.add(WRAPPED_IN);
            chain.add(STAX_IN);
        } else {
            chain.add(URI_IN);
            chain.add(DISPATCH_IN);
        }
    }

}
