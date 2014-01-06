import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.docfacto.common.DocfactoException;

public class XSDTreeDumper extends JFrame {

    /**
     * Create new instance of XSDTreeDumper.
     * @param xsdPath path of XSD to process
     */
    public XSDTreeDumper(String xsdPath) {

        // JFrame stuff
        getRootPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call the traverser
        final XSDTreeTraverser traverser = new XSDTreeTraverser();

        traverser.setDebug(true);

        // Parse the file we are interested in
        try {
            traverser.visit(new File(xsdPath));
        }
        catch (final DocfactoException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Create a tree
        final JTree tree = new JTree(traverser.getRootNode());
        final JScrollPane scrollPane = new JScrollPane(tree);

        getRootPane().add(scrollPane,BorderLayout.CENTER);

        pack();

        setVisible(true);
    }
}