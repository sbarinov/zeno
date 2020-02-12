package domain.zeno.core.cdm.data.serialization.json;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.nio.charset.Charset;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.zeno.core.cdm.data.serialization.ISerializer;

public class JacksonJsonSerializer<T> implements ISerializer<T> {
    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

    private final ObjectMapper objectMapper;
    private final Charset charset;

    public JacksonJsonSerializer(ObjectMapper objectMapper, Charset charset) {
        this.objectMapper = objectMapper;
        this.charset = charset;
    }

    public JacksonJsonSerializer(Charset charset) {
        this(DEFAULT_OBJECT_MAPPER, charset);
    }

    public JacksonJsonSerializer(ObjectMapper objectMapper) {
        this(objectMapper, Charset.defaultCharset());
    }

    public JacksonJsonSerializer() {
        this(DEFAULT_OBJECT_MAPPER, Charset.defaultCharset());
    }

    @Override
    public byte[] serialize(T object) {
        // todo
        return new byte[0];
    }
}
