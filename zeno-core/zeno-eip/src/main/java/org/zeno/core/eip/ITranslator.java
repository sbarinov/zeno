/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */
package org.zeno.core.eip;

public interface ITranslator<SOURCE, TARGET> {
    TARGET translate(SOURCE source);
}
