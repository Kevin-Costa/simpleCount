package controler;

import java.util.ArrayList;

import model.AbsModel;

public abstract class AbsControler {

	  protected AbsModel calc;
	  protected String op = "";
	  protected String nbr = "";
	  protected ArrayList<String> listOperateur = new ArrayList<String>();

	  public AbsControler(AbsModel calcul){
	    this.calc = calcul;
	    this.listOperateur.add("+");
	    this.listOperateur.add("-");
	    this.listOperateur.add("*");
	    this.listOperateur.add("/");
	    this.listOperateur.add("=");
	    this.listOperateur.add("%");
	   }
	  public void setOperateur(String ope){
	    this.op = ope;
	    control();
	  }
	  public void setNombre(String nombre){
	    this.nbr = nombre;
	    control();
	  }
	  public void reset(){
	    this.calc.reset();
	  }
	  abstract void control();
	}
