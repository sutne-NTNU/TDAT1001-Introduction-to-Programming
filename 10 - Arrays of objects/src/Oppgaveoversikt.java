/*
*	Øving 10, oppgave 12.10.1 side 417
*	
*/
public class Oppgaveoversikt{
	private Student[] studenter;
	private int antStudenter;
	
	public Oppgaveoversikt(Student[] studenter){
		this.studenter = studenter;
		this.antStudenter = studenter.length;
	}
	public Student[] getStudenter(){
		return studenter;
	}
	public int antStudenter(){
		return antStudenter;
	}
	public String antOppgaver(int indeks){
		return studenter[indeks].getNavn() +" har gjort " + studenter[indeks].getAntOppg() + " oppgave(r).";
	}
	public void endreAntOppg(int indeks, int økning){
		studenter[indeks].endreAntOppg(økning);
	}
	public void nyStudent(String navn, int antOppg){
		boolean leggTil = true;
		for(int i = 0; i < studenter.length; i++){
			if(navn.equals(studenter[i].getNavn())){
				leggTil = false;
				System.out.println("Denne studenten er allerede lagt til!");
				//throw new IllegalArgumentException("Denne studenten er allerede lagt til!");
			}
		}
		if(leggTil){
			Student[] hjelpeTabell = new Student[studenter.length + 1]; 
			for(int j = 0; j < studenter.length; j++){
				hjelpeTabell[j] = studenter[j];
			}
			hjelpeTabell[hjelpeTabell.length - 1] = new Student(navn, antOppg);
			this.studenter = hjelpeTabell;
			this.antStudenter +=1;
			System.out.println("Student (" + navn + ") lagt til");
		}	
	}
	public String[] getNavnStudenter(){
		String[] navnStudenter = new String[studenter.length];
		for(int i = 0; i < studenter.length; i++){
			navnStudenter[i] = studenter[i].getNavn();
		}
		return navnStudenter;
	}
	public String toString(){
		String toString = "";
		for(int i = 0; i < studenter.length; i++){
					toString += studenter[i].getNavn() + " har gjort " + studenter[i].getAntOppg() + " oppgave(r)\n";
				}
		return toString;
	}
}