package app.manager.apple.service;

import java.io.File;

/**
 * @author nb
 */
@FunctionalInterface
public interface FuritFactory<T> {
    /**
     *
     * @param t
     * @return
     */
    boolean test(File t);
}
