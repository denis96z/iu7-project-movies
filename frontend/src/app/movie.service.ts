import {Injectable} from '@angular/core';
import {Movie} from './movie';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private moviesLimit = 10;

  constructor(private apiService: ApiService) {
  }

  public async getTopMovies(): Promise<Array<Movie>> {
    return this.apiService.getTopMovies(this.moviesLimit);
  }
}
