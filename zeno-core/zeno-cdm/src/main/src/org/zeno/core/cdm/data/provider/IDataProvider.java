/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.provider;

public interface IDataProvider {
    byte[] read();

    void write(byte[] data);
}
