package nocwriter.idgen;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple identity generator based on numeric value. The generator returns a sequence of numeric values, starting
 * from a given initial value and based on known increment.<p>
 * <p>
 * By default, the initial value is 0 and the increment is 1.
 *
 * @author Guy Raz Nir
 * @since 2020/12/12
 */
public class NumericIdGenerator implements IdGenerator {

    /**
     * Increment.
     */
    private final long increment;

    /**
     * The counter that holds the next value.
     */
    private final AtomicLong counter;

    /**
     * Class constructor.
     */
    public NumericIdGenerator() {
        this(0, 1);
    }

    /**
     * Class constructor.
     *
     * @param initialValue Initial value to start with.
     */
    public NumericIdGenerator(long initialValue) {
        this(initialValue, 1);
    }

    /**
     * Class constructor.
     *
     * @param initialValue Initial value to start with.
     * @param increment    Increment count.
     */
    public NumericIdGenerator(long initialValue, long increment) {
        this.counter = new AtomicLong(initialValue);
        this.increment = increment;
    }

    /**
     * Return the next available identifier and increment internal count by a known increment.
     *
     * @return Next numeric identifier, represented as string.
     */
    @Override
    public String generate() {
        return Long.toString(counter.getAndAdd(increment));
    }
}
