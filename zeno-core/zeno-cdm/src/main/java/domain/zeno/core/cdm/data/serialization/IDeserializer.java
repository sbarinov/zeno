package domain.zeno.core.cdm.data.serialization;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.eip.ITranslator;

public interface IDeserializer<T> extends ITranslator<byte[], T> {
    T deserialize(byte[] data);

    @Override
    default T translate(byte[] object) {
        return deserialize(object);
    }
}
