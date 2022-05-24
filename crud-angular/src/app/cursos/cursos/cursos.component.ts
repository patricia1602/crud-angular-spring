import { Component, OnInit } from '@angular/core';
import { Curso } from '../model/curso';
import { CursosService } from '../service/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  cursos: Curso[] = [];
  displayedColumns = ['name','category'];

  //cursosService: CursosService;

  constructor(private cursosService: CursosService) {
    //this.cursos = [];
   // this.cursosService = new CursosService();
  }

  ngOnInit(): void {
    this.cursos = this.cursosService.list();

  }

}
