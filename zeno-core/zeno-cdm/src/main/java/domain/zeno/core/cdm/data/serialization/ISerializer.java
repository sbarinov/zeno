package domain.zeno.core.cdm.data.serialization;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.eip.ITranslator;

public interface ISerializer<T> extends ITranslator<T, byte[]> {
    byte[] serialize(T object);

    @Override
    default byte[] translate(T object) {
        return serialize(object);
    }
}
