package domain.zeno.core.cdm.data.provider;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public interface IDataProvider {
    byte[] read();

    void write(byte[] data);
}
