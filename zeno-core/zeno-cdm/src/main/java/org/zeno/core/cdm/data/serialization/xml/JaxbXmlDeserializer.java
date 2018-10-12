/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.serialization.xml;

import org.zeno.core.cdm.data.serialization.IDeserializer;

import java.nio.charset.Charset;

public class JaxbXmlDeserializer<T> implements IDeserializer<T> {
    private final IJaxbContextProvider contextProvider;
    private final Charset charset;

    public JaxbXmlDeserializer(IJaxbContextProvider contextProvider, Charset charset) {
        this.contextProvider = contextProvider;
        this.charset = charset;
    }

    public JaxbXmlDeserializer(IJaxbContextProvider contextProvider) {
        this(contextProvider, Charset.defaultCharset());
    }

    @Override
    public T deserialize(byte[] data) {
        // todo
        return null;
    }
}
