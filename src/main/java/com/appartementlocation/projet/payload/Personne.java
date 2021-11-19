package com.appartementlocation.projet.payload;

public class Personne {
private int min;
private int max;
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public Personne(int min, int max) {
	super();
	this.min = min;
	this.max = max;
}
public Personne() {
	super();
}

}
