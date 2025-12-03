package activity1;


abstract class Book{
	
	protected  String title;
	
	public abstract void setTitle(String s);
	
	public String getTitle() {
		return title;
	}
}

//Child class extending abstract class

class MyBook extends Book{
	
	public void setTitle(String s) {
		title = s;
	}
	
}
	
public class Activity5{
	
	public static void main(String[] args) {
		MyBook b= new MyBook();
		b.setTitle("Ibm Fst training broucher");		
		System.out.println("Book Title is"+ "  :  " + b.getTitle());
	}
	
}


