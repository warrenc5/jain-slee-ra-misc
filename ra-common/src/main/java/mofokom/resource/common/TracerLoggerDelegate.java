/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.common;

import java.util.Arrays;
import java.util.logging.Level;
import javax.slee.facilities.TraceLevel;
import javax.slee.facilities.Tracer;

/**
 *
 * @author wozza
 */
public class TracerLoggerDelegate extends java.util.logging.Logger {
    private final Tracer delegate;

    public TracerLoggerDelegate(Tracer tracer) {
        super(tracer.getTracerName(), null);
        this.delegate = tracer;
    }

    @Override
    public void fine(String msg) {
        delegate.fine(msg);
    }

    @Override
    public void finer(String msg) {
        delegate.finer(msg);
    }

    @Override
    public void finest(String msg) {
        delegate.finest(msg);
    }

    @Override
    public Level getLevel() {
        return levelForTraceLevel(delegate.getTraceLevel());
    }

    @Override
    public String getName() {
        return delegate.getTracerName();
    }

    @Override
    public void info(String msg) {
        delegate.info(msg);
    }

    @Override
    public boolean isLoggable(Level level) {
        return delegate.isTraceable(traceLevelForLevel(level));
    }

    @Override
    public void log(Level level, String msg) {
        delegate.trace(traceLevelForLevel(level), msg);
    }

    @Override
    public void log(Level level, String msg, Object param1) {
        delegate.trace(traceLevelForLevel(level), msg);
    }

    @Override
    public void log(Level level, String msg, Object[] params) {
        delegate.trace(traceLevelForLevel(level), msg + " " + (Arrays.asList(params).toString()));
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        delegate.trace(traceLevelForLevel(level), msg,thrown);
    }

    @Override
    public void severe(String msg) {
        delegate.severe(msg);
    }

    @Override
    public void warning(String msg) {
        delegate.warning(msg);
    }

    private Level levelForTraceLevel(TraceLevel level) {
        if(level.isConfig())
            return Level.CONFIG;
        else if (level.isFine())
            return Level.FINE;
        else if (level.isFiner())
            return Level.FINER;
        else if (level.isFinest())
            return Level.FINEST;
        else if (level.isInfo())
            return Level.INFO;
        else if (level.isOff())
            return Level.OFF;
        else if (level.isSevere())
            return Level.SEVERE;
        else if (level.isWarning())
            return Level.WARNING;
        else
            return Level.ALL;
    }
    private TraceLevel traceLevelForLevel(Level level) {
        if (level.intValue() == Level.ALL.intValue())
            return TraceLevel.INFO;
        else if(level.intValue() == Level.CONFIG.intValue())
            return TraceLevel.CONFIG;
        else if(level.intValue() == Level.FINE.intValue())
            return TraceLevel.FINE;
        else if(level.intValue() == Level.FINER.intValue())
            return TraceLevel.FINER;
        else if(level.intValue() == Level.FINEST.intValue())
            return TraceLevel.FINEST;
        else if(level.intValue() == Level.INFO.intValue())
            return TraceLevel.INFO;
        else if(level.intValue() == Level.OFF.intValue())
            return TraceLevel.OFF;
        else if(level.intValue() == Level.SEVERE.intValue())
            return TraceLevel.SEVERE;
        else if(level.intValue() == Level.WARNING.intValue())
            return TraceLevel.WARNING;
        else
            return TraceLevel.INFO;
    }
}
