package domain.zeno.core.cdm.data.serialization.json;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.zeno.core.cdm.data.serialization.IDeserializer;

import java.nio.charset.Charset;

public class JacksonJsonDeserializer<T> implements IDeserializer<T> {
    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

    private final ObjectMapper objectMapper;
    private final Charset charset;

    public JacksonJsonDeserializer(ObjectMapper objectMapper, Charset charset) {
        this.objectMapper = objectMapper;
        this.charset = charset;
    }

    public JacksonJsonDeserializer(Charset charset) {
        this(DEFAULT_OBJECT_MAPPER, charset);
    }

    public JacksonJsonDeserializer(ObjectMapper objectMapper) {
        this(objectMapper, Charset.defaultCharset());
    }

    public JacksonJsonDeserializer() {
        this(DEFAULT_OBJECT_MAPPER, Charset.defaultCharset());
    }

    @Override
    public T deserialize(byte[] data) {
        // todo
        return null;
    }
}
