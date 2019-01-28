/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.serialization;

import org.zeno.core.pattern.eip.ITranslator;

public interface ISerializer<T> extends ITranslator<T, byte[]> {
    byte[] serialize(T object);

    @Override
    default byte[] translate(T object) {
        return serialize(object);
    }
}
