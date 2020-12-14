package nocwriter.idgen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Test suite for {@link NumericIdGenerator} class.
 *
 * @author Guy Raz Nir
 * @since 13/12/2020
 */
public class NumericIdGeneratorTest {

    /**
     * Smoke test for verifying that generating large number of unique identifiers does not generate collisions.
     */
    @Test
    @DisplayName("Test should return unique value for each call")
    public void testShouldReturnUniqueValueForEachCall() {
        TestHelpers.validateUniqueIdentifiers(new NumericIdGenerator(), 100000);
    }

    /**
     * Testing that our generator starts from a known value we specified.
     */
    @Test
    @DisplayName("Test should generate value starting at a given initial value")
    public void testShouldGenerateValuesStartingAtKnownValue() {
        final int INITIAL_VALUE = 1000;
        IdGenerator generator = new NumericIdGenerator(INITIAL_VALUE);

        Assertions.assertThat(generator.generate()).isEqualTo(Integer.toString(INITIAL_VALUE));
    }

    /**
     * Testing that our generator applies interval as we specified.
     */
    @Test
    @DisplayName("Test should generate value with known interval")
    public void testShouldGenerateValueWithInterval() {
        final int INCREMENT = 10;
        IdGenerator generator = new NumericIdGenerator(0, INCREMENT);

        for (int index = 0; index < 10; index++) {
            Assertions.assertThat(generator.generate()).isEqualTo(Integer.toString(index * INCREMENT));
        }
    }

}
