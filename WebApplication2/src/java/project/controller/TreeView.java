/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name="treeView")
@ViewScoped
public class TreeView{
     
    private TreeNode root1;
     
    private TreeNode root2;
     
    private TreeNode selectedNode1;
     
    private TreeNode selectedNode2;
     
    public TreeView() {
        root1 = new DefaultTreeNode("Root", null);
        root1.setRowKey("hgf");
        root1.getRowKey();
        TreeNode node0 = new DefaultTreeNode(root1.getRowKey(), root1);
        TreeNode node1 = new DefaultTreeNode("Node 1", root1);
        TreeNode node2 = new DefaultTreeNode("Node 2", root1);
         
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
         
        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
         
        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
         
        root2 = new DefaultTreeNode("Root2", null);
        TreeNode item0 = new DefaultTreeNode("Item 0", root2);
        TreeNode item1 = new DefaultTreeNode("Item 1", root2);
        TreeNode item2 = new DefaultTreeNode("Item 2", root2);
         
        TreeNode item00 = new DefaultTreeNode("Item 0.0", item0);
    }
 
    public TreeNode getRoot1() {
        return root1;
    }
 
    public TreeNode getRoot2() {
        return root2;
    }
 
    public TreeNode getSelectedNode1() {
        return selectedNode1;
    }
 
    public void setSelectedNode1(TreeNode selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }
 
    public TreeNode getSelectedNode2() {
        return selectedNode2;
    }
 
    public void setSelectedNode2(TreeNode selectedNode2) {
        this.selectedNode2 = selectedNode2;
    }
        
    public void onDragDrop(TreeDragDropEvent event) {
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        int dropIndex = event.getDropIndex();
         
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}