package nocwriter.idgen;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generator that returns identifies from a list of predefined strings. Useful for testing.
 *
 * @author Guy Raz Nir
 * @since 13/12/2020
 */
public class StaticIdGenerator implements IdGenerator {

    /**
     * List of values to return from.
     */
    private final String[] values;

    /**
     * Running index to indicate the next value from {@link #values}.
     */
    private final AtomicInteger index = new AtomicInteger();

    /**
     * Class constructor.
     *
     * @param values List of values to use as identifiers.
     * @throws IllegalArgumentException If either <i>values</i> is an empty list or it contains a {@code null} value.
     */
    public StaticIdGenerator(String... values) throws IllegalArgumentException {
        // Make sure list is not empty.
        if (values.length == 0) {
            throw new IllegalArgumentException("Must provide at least 1 value.");
        }

        // Make sure no 'null' value exists.
        for (String value : values) {
            if (value == null) {
                throw new IllegalArgumentException("Value list must not include a 'null' value.");
            }
        }

        this.values = values;
    }

    @Override
    public String generate() {
        return this.values[index.getAndIncrement() % values.length];
    }
}
