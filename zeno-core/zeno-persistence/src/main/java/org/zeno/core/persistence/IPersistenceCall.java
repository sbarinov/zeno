/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.persistence;

public interface IPersistenceCall<T> {
    T call(IPersistenceContext context);
}
