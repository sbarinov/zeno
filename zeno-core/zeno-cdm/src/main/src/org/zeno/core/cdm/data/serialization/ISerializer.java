/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.serialization;

import org.zeno.core.eip.ITranslator;

public interface ISerializer<T> extends ITranslator<T, byte[]> {
    byte[] serialize(T object);

    T deserialize(byte[] data);

    @Override
    default byte[] translate(T object) {
        return serialize(object);
    }
}
