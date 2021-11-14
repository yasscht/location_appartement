package com.appartementlocation.projet.payload;

public class MinMax {
private int max;
private int min;
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public MinMax(int max, int min) {
	super();
	this.max = max;
	this.min = min;
}
public MinMax() {
	super();
}

}
