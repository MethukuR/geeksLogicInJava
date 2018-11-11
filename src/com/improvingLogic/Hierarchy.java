package com.improvingLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Hierarchy {
	static Item rootNode= new Item();
	public static void main(String[] args) {
		List<Item> goods= new ArrayList<>(Arrays.asList(new Item(1,"Electronics",0, null),
														new Item(2,"TV",1, null),
														new Item(3,"21inch",2, null),
														new Item(4,"23inch",2, null),
														new Item(5,"LCD",2, null),
														new Item(6,"player",1, null),
														new Item(7,"mp3",6, null),
														new Item(8,"mp4",6, null),
														new Item(9,"dvd",6, null),
														new Item(10,"hd",8, null)
				));
		
		Iterator<Item> itr = goods.iterator();
		
		while(itr.hasNext()){
			Item newItem=itr.next();
			addChild(newItem);
		}
		//System.out.println("dhjhk");
		//System.out.println(rootNode);
		System.out.println(toStringHierarchy(rootNode,0));
		
		
			
		
	}
	
	static void addChild(Item newItem){
		
		if(newItem.getParentId() == 0){
			rootNode = newItem;
		}
		else{
			Item parentItem = findParent(newItem.getParentId());
			List<Item> childs= parentItem.getChildren();
			if(childs == null){
				ArrayList<Item> newChildren= new ArrayList<>();
				newChildren.add(newItem);
				parentItem.setChildren(newChildren);
			}
			else{
				childs.add(newItem);
			}
			
		}
		//System.out.println("root node : "+rootNode);
		
	}

	private static Item findParent(int parentId) {
		return getItemWithParent(rootNode,parentId);
	}
	
	public static Item getItemWithParent(Item node,int parentID){
	    Item result = null;
	    if(node.getCategory() == parentID){
	        result = node;
	    } else {
	    	if(node.getChildren() != null){
	    		for(Item nextChild : node.getChildren()){
		            result = getItemWithParent(nextChild,parentID);
		            if(result != null){
		                break;
		            }
		        }
	    	}
	        
	    }
	    return result;
	}
	
	public static String toStringHierarchy(Item rootNode,int tabLevel){
	    StringBuilder builder = new StringBuilder();
	    for(int i = 0; i < tabLevel; i++){
	        builder.append("\t");
	    }
	    builder.append("-" + rootNode.getName());
	    builder.append("\n");
	    if(rootNode.getChildren() != null){
	    	for(Item nextChild : rootNode.getChildren()){
		        builder.append(toStringHierarchy(nextChild,tabLevel + 1));
		    }
	    }
	    
	    return builder.toString();
	}
}

class Item {

    private int category;
    private String name;
    private int parentId;
    private ArrayList<Item> children =new ArrayList<>();
    
    public Item(){
    	
    }
	
	public Item(int category, String name, int parentId, ArrayList<Item> children) {
		super();
		this.category = category;
		this.name = name;
		this.parentId = parentId;
		this.children = children;
	}


	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public ArrayList<Item> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Item> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Item [category=" + category + ", name=" + name + ", parentId=" + parentId + ", children=" + children
				+ "]";
	}
	
	
    

    
}