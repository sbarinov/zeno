package domain.zeno.core.cdm.data.serialization.xml;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.nio.charset.Charset;

import domain.zeno.core.cdm.data.serialization.ISerializer;

public class JaxbXmlSerializer<T> implements ISerializer<T> {
    private final IJaxbContextProvider contextProvider;
    private final Charset charset;

    public JaxbXmlSerializer(IJaxbContextProvider contextProvider, Charset charset) {
        this.contextProvider = contextProvider;
        this.charset = charset;
    }

    public JaxbXmlSerializer(IJaxbContextProvider contextProvider) {
        this(contextProvider, Charset.defaultCharset());
    }

    @Override
    public byte[] serialize(T object) {
        // todo
        return new byte[0];
    }
}
