package Model;

public class Movie {
	
	private int idMovie;
	private String title;
	private String description;
	private double ratingImdb;
	private int idImdb;
	private int idTmdb;
	
	public Movie(int idMovie, String title, String description, double ratingImdb, int idImdb, int idTmdb) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.description = description;
		this.ratingImdb = ratingImdb;
		this.idImdb = idImdb;
		this.idTmdb = idTmdb;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRatingImdb() {
		return ratingImdb;
	}

	public void setRatingImdb(double ratingImdb) {
		this.ratingImdb = ratingImdb;
	}

	public int getIdImdb() {
		return idImdb;
	}

	public void setIdImdb(int idImdb) {
		this.idImdb = idImdb;
	}

	public int getIdTmdb() {
		return idTmdb;
	}

	public void setIdTmdb(int idTmdb) {
		this.idTmdb = idTmdb;
	}
	

}
