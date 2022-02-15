/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package mofokom.jaxws.resource.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.cxf.continuations.SuspendedInvocationException;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.Invoker;

/**
 * Invokes a Binding's invoker with the
 * <code>INVOCATION_INPUT</code> from
 * the Exchange.
 *
 * @author Dan Diephouse
 */
public class AsyncSleeInterceptor extends AbstractPhaseInterceptor<Message> {
    private final AbstractCXFResourceAdaptor ra;
    private Object result;

    public AsyncSleeInterceptor(AbstractCXFResourceAdaptor ra) {
        super(Phase.INVOKE);
        this.ra = ra;
    }

    public void handleMessage(final Message message) {

        if(result!=null) {
            resumeResponse(message, result);
            return; 
        }
        Logger.getLogger("AsyncSleeInterceptor").info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        final Exchange exchange = message.getExchange();
        final Endpoint endpoint = exchange.get(Endpoint.class);
        final Service service = endpoint.getService();
        final Invoker invoker = service.getInvoker();

        //Runnable invocation = new Runnable() {

        //public void run() {
        Exchange runableEx = message.getExchange();
        result = "fuck off no way!!!" ; //invoker.invoke(runableEx, getInvokee(message));

        //ra.fireEventOnTransaction(result, null, result);
        new Thread(){

            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(100L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsyncSleeInterceptor.class.getName()).log(Level.SEVERE, null, ex);
                }
                resumeResponse(message, result);

            }
            
           }.start(); 

        throw new SuspendedInvocationException();

    }

    public void resumeResponse(final Message message,Object result) {
        Logger.getLogger("AsyncSleeInterceptor").info("<<<<<<<<<<<<<<<<<<< " + result);

        final Exchange exchange = message.getExchange();
        final Endpoint endpoint = exchange.get(Endpoint.class);
        final Service service = endpoint.getService();
        final Invoker invoker = service.getInvoker();

        if (!exchange.isOneWay()) {
        Logger.getLogger("AsyncSleeInterceptor").info("OK SET CONTENT " + result);
            Endpoint ep = exchange.get(Endpoint.class);

            Message outMessage = exchange.getOutMessage();
            if (outMessage == null) {
                outMessage = new MessageImpl();
                outMessage.setExchange(exchange);
                outMessage = ep.getBinding().createMessage(outMessage);
                exchange.setOutMessage(outMessage);
            }
            copyJaxwsProperties(message, outMessage);
            if (result != null) {
                MessageContentsList resList = null;
                if (result instanceof MessageContentsList)
                    resList = (MessageContentsList) result;
                else if (result instanceof List)
                    resList = new MessageContentsList((List<?>) result);
                else if (result.getClass().isArray())
                    resList = new MessageContentsList((Object[]) result);
                else
                    outMessage.setContent(Object.class, result);
                if (resList != null)
                    outMessage.setContent(List.class, resList);
            }
        message.getInterceptorChain().resume();
        }  
        
        /*
         * }
         *
         * };
         *
         * Executor executor = getExecutor(endpoint);
         * Executor executor2 = exchange.get(Executor.class);
         * if (executor2 == executor || executor == null) {
         * // already executing on the appropriate executor
         * invocation.run();
         * } else {
         * exchange.put(Executor.class, executor);
         * FutureTask<Object> o = new FutureTask<Object>(invocation, null) {
         * @Override
         * protected void done() {
         * super.done();
         * synchronized (this) {
         * this.notifyAll();
         * }
         * }
         * };
         * synchronized (o) {
         * executor.execute(o);
         * if (!o.isDone()) {
         * try {
         * o.wait();
         * } catch (InterruptedException e) {
         * //IGNORE
         * }
         * }
         * try {
         * o.get();
         * } catch (InterruptedException e) {
         * throw new Fault(e);
         * } catch (ExecutionException e) {
         * if (e.getCause() instanceof RuntimeException) {
         * throw (RuntimeException)e.getCause();
         * } else {
         * throw new Fault(e.getCause());
         * }
         * }
         * }
         * }
         *
         */
    }

    private Object getInvokee(Message message) {
        Object invokee = message.getContent(List.class);
        if (invokee == null)
            invokee = message.getContent(Object.class);
        return invokee;
    }

    /**
     * Get the Executor for this invocation.
     *
     * @param endpoint
     * @return
     */
    private Executor getExecutor(final Endpoint endpoint) {
        return endpoint.getService().getExecutor();
    }

    private void copyJaxwsProperties(Message inMsg, Message outMsg) {
        outMsg.put(Message.WSDL_OPERATION, inMsg.get(Message.WSDL_OPERATION));
        outMsg.put(Message.WSDL_SERVICE, inMsg.get(Message.WSDL_SERVICE));
        outMsg.put(Message.WSDL_INTERFACE, inMsg.get(Message.WSDL_INTERFACE));
        outMsg.put(Message.WSDL_PORT, inMsg.get(Message.WSDL_PORT));
        outMsg.put(Message.WSDL_DESCRIPTION, inMsg.get(Message.WSDL_DESCRIPTION));
    }
}
