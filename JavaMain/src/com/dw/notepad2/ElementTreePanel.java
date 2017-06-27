package com.dw.notepad2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


@SuppressWarnings("serial")
public class ElementTreePanel extends JPanel
implements CaretListener, DocumentListener, PropertyChangeListener, TreeSelectionListener {

	/** Tree showing the documents element structure. */
	protected JTree tree;
	/** Text component showing elemenst for. */
	protected JTextComponent editor;
	/** Model for the tree. */
	protected ElementTreeModel treeModel;
	/** Set to true when updatin the selection. */
	protected boolean updatingSelection;
	
	
	@SuppressWarnings("LeakingThisInConstructor")
	public ElementTreePanel(JTextComponent editor) {
		this.editor = editor;

		Document document = editor.getDocument();

		// Create the tree.
		treeModel = new ElementTreeModel(document);
		tree = new JTree(treeModel) {

			@Override
			public String convertValueToText(Object value, boolean selected, boolean expanded, boolean leaf, int row,
					boolean hasFocus)
			{
				// Should only happen for the root
				if (!(value instanceof Element)) {
					return value.toString();
				}

				Element e = (Element) value;
				AttributeSet as = e.getAttributes().copyAttributes();
				String asString;

				if (as != null) {
					StringBuilder retBuffer = new StringBuilder("[");
					Enumeration names = as.getAttributeNames();

					while (names.hasMoreElements()) {
						Object nextName = names.nextElement();

						if (nextName != StyleConstants.ResolveAttribute) {
							retBuffer.append(" ");
							retBuffer.append(nextName);
							retBuffer.append("=");
							retBuffer.append(as.getAttribute(nextName));
						}
					}
					retBuffer.append(" ]");
					asString = retBuffer.toString();
				} else {
					asString = "[ ]";
				}

				if (e.isLeaf()) {
					return e.getName() + " [" + e.getStartOffset() + ", " + e.getEndOffset() + "] Attributes: "
							+ asString;
				}
				return e.getName() + " [" + e.getStartOffset() + ", " + e.getEndOffset() + "] Attributes: " + asString;
			}
		};
		tree.addTreeSelectionListener(this);
		tree.setDragEnabled(true);
		// Don't show the root, it is fake.
		tree.setRootVisible(false);
		// Since the display value of every node after the insertion point
		// changes every time the text changes and we don't generate a change
		// event for all those nodes the display value can become off.
		// This can be seen as '...' instead of the complete string value.
		// This is a temporary workaround, increase the needed size by 15,
		// hoping that will be enough.
		tree.setCellRenderer(new DefaultTreeCellRenderer() {

			@Override
			public Dimension getPreferredSize()
			{
				Dimension retValue = super.getPreferredSize();
				if (retValue != null) {
					retValue.width += 15;
				}
				return retValue;
			}
		});
		// become a listener on the document to update the tree.
		document.addDocumentListener(this);

		// become a PropertyChangeListener to know when the Document has
		// changed.
		editor.addPropertyChangeListener(this);

		// Become a CaretListener
		editor.addCaretListener(this);

		// configure the panel and frame containing it.
		setLayout(new BorderLayout());
		add(new JScrollPane(tree), BorderLayout.CENTER);

		// Add a label above tree to describe what is being shown
		JLabel label = new JLabel("Elements that make up the current document", SwingConstants.CENTER);

		label.setFont(new Font("Dialog", Font.BOLD, 14));
		add(label, BorderLayout.NORTH);

		setPreferredSize(new Dimension(400, 400));
	}


	
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static class ElementTreeModel extends DefaultTreeModel {
		protected Element[] rootElements;

		public ElementTreeModel(Document document) {
			super(new DefaultMutableTreeNode("root"), false);
			rootElements = document.getRootElements();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setEditor(JTextComponent editor)
	{
		if (this.editor == editor) {
			return;
		}

		if (this.editor != null) {
			Document oldDoc = this.editor.getDocument();

			oldDoc.removeDocumentListener(this);
			this.editor.removePropertyChangeListener(this);
			this.editor.removeCaretListener(this);
		}
		this.editor = editor;
		if (editor == null) {
			treeModel = null;
			tree.setModel(null);
		} else {
			Document newDoc = editor.getDocument();

			newDoc.addDocumentListener(this);
			editor.addPropertyChangeListener(this);
			editor.addCaretListener(this);
			treeModel = new ElementTreeModel(newDoc);
			tree.setModel(treeModel);
		}
	}

}
