package domain.zeno.core.pattern.common;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public interface IProcessor<SOURCE, TARGET> {
    TARGET process(SOURCE source);
}
