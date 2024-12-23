package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogicsImpl implements Logics {

	private List<Integer> values;

	public LogicsImpl(int size) {
		this.values = new ArrayList<>(Collections.nCopies(size,0));
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(values);
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream().map(a -> a < values.size()).toList();
	}

	@Override
	public int hit(int elem) {
		int n = this.values.get(elem);
		this.values.set(elem, ++n);
		return n;
	}

	@Override
	public String result() {
		String result = "<<";
		int count=0;
		for(Integer a : values){
			if(count == values.size()-1){
				result = result + Integer.toString(a);
			}else{
				result = result + Integer.toString(a) + "|";
			}
			count++;
		}
		result = result + ">>";
		return result;
	}

	@Override
	public boolean toQuit() {
		return this.values.stream().allMatch(i -> i == this.values.get(0));
	}
}
