// Decompiled by Jad v1.5.8d. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MailMessage.java
package mofokom.resource.mail.impl;

import java.io.*;
import java.net.URL;

import javax.activation.DataSource;

class AttachmentDataSource<B> implements DataSource {

    public AttachmentDataSource(B obj, String s) {
        content = obj;
        type = s;
    }

    B content;
    String type;
    String name;

    public String getContentType() {
        return type;
    }

    public InputStream getInputStream() throws IOException {
        if (content instanceof URL){
            return ((URL)content).openStream();
        } else if(content instanceof String)
            return new ByteArrayInputStream(((String) content).getBytes());
        else if (content instanceof byte[])
            return new ByteArrayInputStream((byte[]) content);
        else
            return (InputStream) content;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public OutputStream getOutputStream() {
        return new ByteArrayOutputStream();
    }
}
