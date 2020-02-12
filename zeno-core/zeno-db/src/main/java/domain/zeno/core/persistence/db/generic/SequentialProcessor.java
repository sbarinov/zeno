package domain.zeno.core.persistence.db.generic;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

import java.util.ArrayList;
import java.util.Collection;

public class SequentialProcessor<SOURCE, TARGET> implements IProcessor<SOURCE, TARGET> {
    private final Collection<IProcessor<SOURCE, TARGET>> delegates = new ArrayList<>();

    public SequentialProcessor(Collection<IProcessor<SOURCE, TARGET>> delegates) {
        this.delegates.addAll(delegates);
    }

    public SequentialProcessor() {
    }

    @Override
    public TARGET process(SOURCE source) {
        TARGET result = null;

        for (IProcessor<SOURCE, TARGET> delegate : delegates) {
            result = delegate.process(source);
        }

        return result;
    }

    public void add(IProcessor<SOURCE, TARGET> delegate) {
        delegates.add(delegate);
    }
}
