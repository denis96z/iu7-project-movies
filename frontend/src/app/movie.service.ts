import {Injectable} from '@angular/core';
import {Movie} from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  public async getTopMovies(): Promise<Array<Movie>> {
    const movies = [];
    for (const i of [0, 1, 2, 3, 4]) {
      const movie = new Movie();
      movie.title = 'Movie' + i.toString();
      movie.rating = i;
      movies[i] = movie;
    }
    return movies;
  }
}
