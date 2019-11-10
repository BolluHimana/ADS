class Book implements Comparable<Book>{
	String title;
	String author;
	double price;
	Book(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int compareTo(Book that){
		return this.title.compareTo(that.title);
	}
}