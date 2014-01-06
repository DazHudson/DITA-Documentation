import com.docfacto.doclets.adam.AdamResults;

/**
 * A Adamlet is an extension point to Adam. This allows for custom warning
 * messages to be generated
 * 
 * @author dhudson - created 8 Jul 2012
 * @since 2.0
 */
public interface Adamlet {

    /**
     * Adam will call this method when processing comments, if a
     * {@code tag-name} element has been specified then this will only be called
     * with the tag comment.
     * 
     * Errors and warnings can be added to the results set with severity levels
     * <p>
     * If the Adamlet is in the all section, then will be called for
     * <ul>
     * <li>packages
     * <li>classes
     * <li>constructors
     * <li>methods
     * <li>fields
     * </ul>
     * </p>
     * 
     * @param comment to process
     * @return a collection of warnings
     * @since 2.2
     */
    public AdamResults processComment(String comment);
}