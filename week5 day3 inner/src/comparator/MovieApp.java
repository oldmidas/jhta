package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieApp {
	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<>();
		movieList.add(new Movie("해리포터", "판타지", 1, 8000));
		movieList.add(new Movie("반지의 제왕", "판타지", 2, 9000));
		movieList.add(new Movie("스파이더맨", "액션", 3, 9000));
		movieList.add(new Movie("대부", "드라마", 4, 15000));
		movieList.add(new Movie("뽀로로", "어린이", 5, 3000));
		movieList.add(new Movie("토이스토리", "애니메이션", 6, 7000));
		
		Comparator<Movie> c = new Comparator<Movie>() {
			public int compare(Movie m1,Movie m2) {
				return -(m1.getPrice() - m2.getPrice());
			}
		};

		Collections.sort(movieList, c);
		for (Movie m : movieList) {
			System.out.println(m.toString());
		}
	}
}
