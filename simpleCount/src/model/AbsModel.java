package model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;

public abstract class AbsModel implements Observable{
protected double res = 0;
protected double ans = 0;
protected String op = "";
protected String calcul = "";
private ArrayList<Observer> listobs = new ArrayList<Observer>();
public abstract void reset();
public abstract void calc();
public abstract void getRes();
public abstract void setOp(String op);
public abstract void setNombre(String nb);
public void addObserver(Observer obs) {
    this.listobs.add(obs);
  }
public void notifyObserver(String str) {
    if(str.matches("^0[0-9]+"))
      str = str.substring(1, str.length());
    for(Observer obs : listobs)
      obs.update(str);
  }
public void removeObserver() {
    listobs = new ArrayList<Observer>();
  }  
}
