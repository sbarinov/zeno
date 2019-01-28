/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.serialization;

import org.zeno.core.pattern.eip.ITranslator;

public interface IDeserializer<T> extends ITranslator<byte[], T> {
    T deserialize(byte[] data);

    @Override
    default T translate(byte[] object) {
        return deserialize(object);
    }
}
