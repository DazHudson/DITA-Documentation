import com.docfacto.config.generated.Severity;
import com.docfacto.doclets.adam.AdamResults;

/**
 * Simple Adamlet to check the since tag for numerical correctness and it's
 * within range
 * 
 * @author dhudson - created 8 Jul 2012
 * @since 2.0
 */
public class SinceAdamlet implements Adamlet {

    /**
     * @see com.docfacto.doclets.adam.Adamlet#processComment(java.lang.String)
     */
    @Override
    public AdamResults processComment(String comment) {
        // New result set
        final AdamResults results = new AdamResults();

        // The since notation is major.minor
        if (comment.isEmpty()) {
            // Adam will grumble if configured to do so, but we could add
            // another one
            results.addResult("Missing description",Severity.ERROR);
            return results;
        }

        final int index = comment.indexOf(".");

        if (index==-1) {
            results.addResult("Invalid release number ["+comment+"]",Severity.WARNING);
        } else {

            try {
                final int major = Integer.parseInt(comment.substring(0,index));
                Integer.parseInt(comment.substring(index+1,comment.length()));
                if (major>2) {
                    results.addResult("Major release number too high",Severity.WARNING);
                }
            }
            catch (final NumberFormatException ex) {
                results.addResult("Invalid release number ["+comment+"]",Severity.WARNING);
            }
        }

        return results;
    }

}	