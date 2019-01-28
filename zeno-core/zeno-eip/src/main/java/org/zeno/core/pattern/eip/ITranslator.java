/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.pattern.eip;

public interface ITranslator<SOURCE, TARGET> {
    TARGET translate(SOURCE source);
}
