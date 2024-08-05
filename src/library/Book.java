package library;

public class Book {
	    private String title;
	    private String author;
	    private String category;
	    private boolean isBorrowed;

	    public Book(String title, String author, String category) {
	        this.title = title;
	        this.author = author;
	        this.category = category;
	        this.isBorrowed = false;
	    }

	    
	    public String getTitle() { return title; }
	    public String getAuthor() { return author; }
	    public String getCategory() { return category; }
	    public boolean isBorrowed() { return isBorrowed; }
	    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
	}



