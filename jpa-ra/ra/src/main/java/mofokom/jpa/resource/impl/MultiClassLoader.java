package mofokom.jpa.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

class MultiClassLoader extends ClassLoader {

    private final ClassLoader[] parents;

    MultiClassLoader(ClassLoader... parents) {
        this.parents = parents;
    }

    @Override
    public URL getResource(String name) {
        for (ClassLoader c : parents) {
            URL o = c.getResource(name);
            if (o != null)
                return o;
        }
        return null;
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        for (ClassLoader c : parents) {
            InputStream o = c.getResourceAsStream(name);
            if (o != null)
                return o;
        }
        return null;
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        List<URL> l = new ArrayList<URL>();
        for (ClassLoader c : parents) {
            Enumeration<URL> o = c.getResources(name);
            l.addAll(Collections.list(o));
        }
        return Collections.enumeration(l);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        for (ClassLoader c : parents) {
            try {
                Class<?> o = c.loadClass(name);
                return o;
            } catch (Exception x) {
            }
        }
        throw new ClassNotFoundException(name);
    }
}
