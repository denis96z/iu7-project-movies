import {Injectable} from '@angular/core';
import {Movie} from './movie';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = '/api';

  public async getTopMovies(limit: number): Promise<Array<Movie>> {
    const path = this.apiUrl +
      '/movies?' + limit.toString();

    const response = await fetch(path);

    switch (response.status) {
      case 200:
        return await response.json();

      case 404:
        return [];

      default:
        throw new Error('500 Internal Server Error');
    }
  }
}
