package domain.zeno.core.cdm.data.serialization.xml;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import javax.xml.bind.JAXBContext;

public interface IJaxbContextProvider {
    <T> JAXBContext getContext(Class<T> clazz);
}
