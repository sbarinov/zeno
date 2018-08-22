/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.persistence;

import org.zeno.core.persistence.entity.IEntity;

public interface IPersistenceContext {
    <T extends IEntity> IEntityProvider<T> getEntityProvider(Class<T> clazz);
}
