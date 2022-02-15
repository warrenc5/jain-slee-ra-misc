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
package mofokom.cxf.transport.slee;

import java.io.*;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import mofokom.jaxws.resource.impl.AbstractCXFResourceAdaptor;
import mofokom.jaxws.resource.impl.WebServiceActivityImpl;

import org.apache.cxf.Bus;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.http.*;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.params.HttpParams;

/**
 *
 */
public class SleeHTTPConduit extends HTTPConduit {

    private final AbstractCXFResourceAdaptor ra;

    public SleeHTTPConduit(AbstractCXFResourceAdaptor ra, Bus b, EndpointInfo ei) throws IOException {
        super(b, ei);
        this.ra = ra;
    }

    public SleeHTTPConduit(AbstractCXFResourceAdaptor ra, Bus b, EndpointInfo ei, EndpointReferenceType t) throws IOException {
        super(b, ei, t);
        this.ra = ra;
    }

    protected OutputStream createOutputStream(Message message,
            boolean needToCacheRequest,
            boolean isChunking,
            int chunkThreshold) throws IOException {
        BufferedOutputStream bos = message.get(BufferedOutputStream.class);
        

        return bos;
    }

    @Override
    protected void setupConnection(Message message, URI url, HTTPClientPolicy csPolicy) throws IOException {

        HttpEntityEnclosingRequest entityRequest = new BasicHttpEntityEnclosingRequest("POST", message.getExchange().getEndpoint().getEndpointInfo().getAddress());
        PipedInputStream pis = new PipedInputStream(2048);

        final PipedOutputStream os = new PipedOutputStream(pis);
        final BufferedOutputStream bos = new BufferedOutputStream(os, 2048);

        WebServiceActivityImpl activity = ra.createActivity(message);

        AbstractHttpEntity entity = new InputStreamEntity(pis, -1);
        if (entityRequest == null)
            throw new NullPointerException("entity request null");

        entityRequest.setEntity(entity);

        entity.setContentType("text/xml");
        message.put(BufferedOutputStream.class, bos);
        
        try {
            ra.submitRequest(entityRequest, activity);
        } catch (InterruptedException ex) {
            Logger.getLogger(SleeHTTPConduit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SleeHTTPConduit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(SleeHTTPConduit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HttpException ex) {
            Logger.getLogger(SleeHTTPConduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}