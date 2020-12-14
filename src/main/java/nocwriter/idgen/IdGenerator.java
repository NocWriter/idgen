package nocwriter.idgen;

/**
 * Generate unique identifier for each call. Each underlying implementation may have its custom setup.<p>
 * <p>
 * All implementations must be thread-safe (can be safely used in concurrent environment).
 *
 * @author Guy Raz Nir
 * @since 19/06/2016
 */
public interface IdGenerator {

    /**
     * @return Unique identifier for each call.
     */
    String generate();

}
