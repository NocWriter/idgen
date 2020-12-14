package nocwriter.idgen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for {@link SecureRandomIdGenerator} implementation.
 *
 * @author Guy Raz Nir
 * @since 13/12/2020
 */
public class SecureRandomIdGeneratorTest {

    /**
     * Smoke test for verifying that generating large number of unique identifiers does not generate collisions.
     */
    @Test
    @DisplayName("Test should return unique value for each call")
    public void testShouldReturnUniqueValueForEachCall() {
        TestHelpers.validateUniqueIdentifiers(new NumericIdGenerator(), 1000000);
    }

    /**
     * We want to test that the size of the token (number of characters constructing the identifier) is of
     * a size we specified.
     */
    @Test
    @DisplayName("Test should generate identifier with known length")
    public void testShouldGenerateIdentifiersWithExpectedLength() {
        final int TOKEN_SIZE = 105;

        // Create an id generator with expected token length.
        SecureRandomIdGenerator generator = new SecureRandomIdGenerator(TOKEN_SIZE);

        // Make sure the generated token is of expected length.
        String id = generator.generate();
        Assertions.assertThat(id).hasSize(TOKEN_SIZE);
    }
}
