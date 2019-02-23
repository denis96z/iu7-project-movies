import {Component} from '@angular/core';
import {MovieService} from './movie.service';
import {Movie} from './movie';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  movies: Array<Movie> = null;
  selectedMovie: Movie = null;

  constructor(private movieService: MovieService) {
    this.getTopMovies();
  }

  onUpdateBtnClick(): void {
    this.getTopMovies();
  }

  onMovieSelect(movieIndex: number): void {
    console.log('ok');
    this.selectedMovie = this.movies[movieIndex];
  }

  private getTopMovies(): void {
    this.movieService.getTopMovies()
      .then(movies => {
        if (movies.length > 0) {
          this.movies = movies;
          this.selectedMovie = movies[0];
          console.log(this.selectedMovie);
        } else {
          this.movies = null;
          this.selectedMovie = null;
        }
      })
      .catch(err => {
        console.log(err);
      });
  }
}
