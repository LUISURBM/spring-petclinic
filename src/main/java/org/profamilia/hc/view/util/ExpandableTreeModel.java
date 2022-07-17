package org.profamilia.hc.view.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.myfaces.custom.tree2.TreeModelBase;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeState;
import org.apache.myfaces.custom.tree2.TreeStateBase;


public class ExpandableTreeModel extends TreeModelBase {

    protected Set<TreeNode> expandedNodes = new HashSet<TreeNode>();

    public ExpandableTreeModel(TreeNode root) {
        super(root);
    }

    public void setExpanded(TreeNode node, boolean expanded) {
        if (expanded)
            expandedNodes.add(node);
        else
            expandedNodes.remove(node);
    }

    public boolean isExpanded(TreeNode node) {
        return expandedNodes.contains(node);
    }

    @Override
    public TreeState getTreeState() {
        return new ExpandableTreeState(super.getTreeState(), this);
    }

    private static class ExpandableTreeState extends TreeStateBase {

        private TreeState state;
        private ExpandableTreeModel model;

        public ExpandableTreeState(TreeState state, 
                                   ExpandableTreeModel model) {
            this.state = state;
            this.model = model;
        }

        @Override
        public boolean isNodeExpanded(String nodeid) {
            return model.isExpanded(model.getNodeById(nodeid));
        }

        //Delegated methods from state:

        public void collapsePath(String[] arg0) {
            state.collapsePath(arg0);
        }

        public void expandPath(String[] arg0) {
            state.expandPath(arg0);
        }

        public boolean isSelected(String arg0) {
            return state.isSelected(arg0);
        }

        public boolean isTransient() {
            return state.isTransient();
        }

        public void setSelected(String arg0) {
            state.setSelected(arg0);
        }

        public void setTransient(boolean arg0) {
            state.setTransient(arg0);
        }

        public void toggleExpanded(String arg0) {
            state.toggleExpanded(arg0);
        }
    }
}

