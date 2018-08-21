/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.cdf.v0.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.zeno.core.cdm.data.serialization.xml.IJaxbContextProvider;
import org.zeno_cdf.core.v0.CdfObject;
import org.zeno_cdf.core.v0.ObjectFactory;

public class CdfJaxbContextProvider implements IJaxbContextProvider {
    private final JAXBContext context;

    public CdfJaxbContextProvider() {
        try {
            context = JAXBContext.newInstance(ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> JAXBContext getContext(Class<T> clazz) {
        if (!CdfObject.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(clazz.getName());
        }

        return context;
    }
}
