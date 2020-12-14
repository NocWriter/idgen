package nocwriter.idgen;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

/**
 * Collection of helpers for testing.
 *
 * @author Guy Raz Nir
 * @since 13/12/2020
 */
public class TestHelpers {

    /**
     * Given a <i>generator</i> and number of iterations to run, this method makes sure there are no repetitions in
     * generated values.
     *
     * @param generator          Generator to test.
     * @param numberOfIterations Number of iterations to run.
     * @throws AssertionError If <i>generator</i> generated an identifier more than once.
     */
    public static void validateUniqueIdentifiers(IdGenerator generator, int numberOfIterations) throws AssertionError {
        Set<String> generatedValues = new HashSet<>();
        for (int counter = 0; counter < numberOfIterations; counter++) {
            String newId = generator.generate();
            boolean newValue = generatedValues.add(newId);
            assertThat(newValue).withFailMessage(() -> "Value " + newId + " generated more than once.").isTrue();
        }
    }
}
