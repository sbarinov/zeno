package domain.zeno.core.persistence;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public interface IResourceManager<KEY, RESOURCE> {
    KEY create(RESOURCE resource);

    RESOURCE read(KEY key);

    void update(RESOURCE resource);

    void delete(RESOURCE resource);
}
