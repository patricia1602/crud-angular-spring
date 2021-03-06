import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Curso } from '../model/curso';
import { first, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  private readonly API = 'http://localhost:8080/api/cursos';

  constructor(private httpClient: HttpClient) { }

    list() {
      return this.httpClient.get<Curso[]>(this.API)
      .pipe(
        first(),
        //delay(5000),
        //tap(cursos => console.log(cursos))
      );
    }

    save(record: Curso){
      if (record._id) {
        return this.httpClient
          .post<Curso>(`${this.API}/update`, record)
          .pipe(first());
      } else {
        return this.httpClient
          .post<Curso>(`${this.API}/create`, record)
          .pipe(first());
      }
    }

    delete(id: string) {
      return this.httpClient.post<Curso>(`${this.API}/delete`, id).pipe(first());
    }
    }


