/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listproject;

import stackproject.ListItem;

/**
 *
 * @author heikki
 */
public class List {

	protected ListItem start;
	protected ListItem pos;
	protected int size;

	public List() {
		pos = null;
		size = 0;
		start = null;
	}

	public void add(String data) {

		ListItem prev = pos;	
		pos = new ListItem(data);

		if( prev != null ) {
			ListItem next = prev.getNext();
			pos.setNext(next);
			prev.setNext(pos);
		} else {
			start = pos;
		}

		size++;

	}


	public ListItem remove() {
		if(pos == null) {
			return null;
		}

		ListItem removable = pos.getNext();
		if (removable == null) {
			removable = pos;
			pos = start = null;
			return removable;
		}

		ListItem next = removable.getNext();
		pos.setNext(next);
		return removable;
	}

	public boolean revPos() {
		ListItem mypos = start;
		ListItem prev = start;
		while(mypos != pos) {
			prev = mypos;
			mypos = mypos.getNext();
		}

		pos = prev;
		return true;
	}

	public boolean nextPos() {
		if(pos.getNext() == null) {
			return false;
		}

		pos = pos.getNext();
		return true;
	}


	public boolean toStart() {
		pos = start;
		return true;
	}


	public ListItem getPos() {
		return pos;
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		ListItem mypos = start;
		String toReturn = "";

		while(mypos != null) {
			toReturn = toReturn + mypos.getData();
			if (mypos == pos) {
				toReturn = toReturn + "  <-";
			}
			toReturn = toReturn + "\n";

			mypos = mypos.getNext();
		}
		return toReturn;
	}

	

	
}
