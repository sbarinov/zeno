/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdm.data.serialization.xml;

import javax.xml.bind.JAXBContext;

public interface IJaxbContextProvider {
    <T> JAXBContext getContext(Class<T> clazz);
}
